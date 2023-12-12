package com.softserve.framework.test;

import com.softserve.framework.library.GuestFunctions;
import com.softserve.framework.tools.LocalStorageJS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestRunner {

    private static final String BASE_URL = "https://www.greencity.social/#/ubs";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    protected static GuestFunctions guestFunctions;

    protected static LocalStorageJS localStorageJS;

    protected static WebDriver driver;

    // Overload
    public static void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
    public static void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        //
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        //
        //driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS)); // 0 by default
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
        driver.manage( ).timeouts().scriptTimeout(Duration.ofSeconds(100));
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(800, 550));
        //
        guestFunctions = new GuestFunctions(driver);
        localStorageJS = new LocalStorageJS(driver);
        System.out.println("@BeforeAll executed");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit(); // close()
        }
        System.out.println("@AfterAll executed");
    }

    @BeforeEach
    public void setupThis() {
        driver.get(BASE_URL);
        System.out.println("\t@BeforeEach executed");
    }

    @AfterEach
    public void tearThis() {
        //
        // Logout. get Username
        //driver.findElement(By.cssSelector("li.body-2")).click();
        //driver.findElement(By.cssSelector("li[aria-label='sign-out'] > a")).click();
        //
        // delete All Cookies;
        driver.manage().deleteAllCookies();
        // TODO delete token
        // window.localStorage.removeItem('accessToken');
        // window.localStorage.removeItem('refreshToken');
        // js.executeScript(String.format("window.localStorage.clear();"));
        //
        // delete All Tokens;
        //localStorageJS.clearLocalStorage();
        localStorageJS.removeItemFromLocalStorage("accessToken");
        localStorageJS.removeItemFromLocalStorage("refreshToken");
        //
        // Refresh page
        presentationSleep(4); // For Presentation ONLY
        driver.navigate().refresh();
        //
        System.out.println("\t@AfterEach executed");
    }

}
