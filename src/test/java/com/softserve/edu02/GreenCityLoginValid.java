package com.softserve.edu02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GreenCityLoginValid {


    private static final String BASE_URL = "https://www.greencity.social/#/ubs";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private static final Long ONE_SECOND_DELAY = 1000L;
    private static WebDriver driver;

    // Overload
    protected void presentationSleep() {
        presentationSleep(1);
    }

    // Overload
    protected void presentationSleep(int seconds) {
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
        driver.manage().deleteAllCookies();
        // TODO delete token
        // window.localStorage.removeItem('accessToken');
        // window.localStorage.removeItem('refreshToken');
        // js.executeScript(String.format("window.localStorage.clear();"));
        // Refresh page
        presentationSleep(4); // For Presentation ONLY
        //
        System.out.println("\t@AfterEach executed");
    }

    private void signIn(String email, String password) {
        // Click Login Button
        //driver.findElement(By.cssSelector("a.ubs-header-sign-in")).click();
        //driver.findElement(By.cssSelector(".ubs-header-sing-in-img")).click();
        //driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img")).click();
        //
        // Burger menu click
        //driver.findElement(By.cssSelector("div.menu-icon-wrapper")).click();
        //driver.findElement(By.cssSelector("a.tertiary-global-button")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Fill email input
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        presentationSleep(); // For Presentation ONLY
        //
        // Fill password input
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        presentationSleep(); // For Presentation ONLY
        //
        // Press Button Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        presentationSleep(); // For Presentation ONLY
    }

    @Test
    public void checkLogin() {
        /*
        // Steps TC
        // Click Login Button
        //driver.findElement(By.cssSelector("a.ubs-header-sign-in")).click();
        //driver.findElement(By.cssSelector(".ubs-header-sing-in-img")).click();
        //driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img")).click();
        //
        // Burger menu click
        //driver.findElement(By.cssSelector("div.menu-icon-wrapper")).click();
        //driver.findElement(By.cssSelector("a.tertiary-global-button")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Fill email input
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        presentationSleep(); // For Presentation ONLY
        //
        // Fill password input
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        presentationSleep(); // For Presentation ONLY
        //
        // Press Button Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        presentationSleep(); // For Presentation ONLY
        */
        //
        signIn("tyv09754@zslsz.com", "Qwerty_1");
        //
        // get Username
        String actualUserName = driver.findElement(By.cssSelector("li.ubs-user-name")).getText();
        String expectedUserName = "QwertyY";
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        Assertions.assertEquals(expectedUserName, actualUserName);
        presentationSleep(); // For Presentation ONLY
        //
        System.out.println("\t\tTest testUi() executed");
    }

    @Test
    public void checkMyHabit() {
        /*
        // Steps TC
        // Click Login Button
        //driver.findElement(By.cssSelector("a.ubs-header-sign-in")).click();
        //driver.findElement(By.cssSelector(".ubs-header-sing-in-img")).click();
        //driver.findElement(By.cssSelector("app-header:nth-child(1) .ubs-header-sing-in-img")).click();
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img")).click();
        //
        // Burger menu click
        //driver.findElement(By.cssSelector("div.menu-icon-wrapper")).click();
        //driver.findElement(By.cssSelector("a.tertiary-global-button")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Fill email input
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("tyv09754@zslsz.com");
        presentationSleep(); // For Presentation ONLY
        //
        // Fill password input
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Qwerty_1");
        presentationSleep(); // For Presentation ONLY
        //
        // Press Button Login
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        presentationSleep(); // For Presentation ONLY
        */
        //
        signIn("tyv09754@zslsz.com", "Qwerty_1");
        //
        // get Username
        String actualUserName = driver.findElement(By.cssSelector("li.ubs-user-name")).getText();
        String expectedUserName = "QwertyY";
        presentationSleep(); // For Presentation ONLY
        //
        // Green City menu Click
        //driver.findElement(By.xpath("//ul[@role='tablist']//a[contains(text(),'Green City')]")).click();
        driver.findElement(By.cssSelector("app-header:nth-child(1) ul[role='tablist'] a[href*='greenCity']")).click();
        presentationSleep(); // For Presentation ONLY
        //
        // Start forming a habit button click
        driver.findElement(By.cssSelector("div#main-content button.primary-global-button.btn")).click();
        presentationSleep(); // For Presentation ONLY
        //
        String actualLabel = driver.findElement(By.cssSelector("div[aria-selected='true'] div.mat-tab-label-content")).getText();
        String expectedLabel = "My habits";
        presentationSleep(); // For Presentation ONLY
        //
        // Check
        Assertions.assertTrue(actualLabel.contains(expectedLabel));
        presentationSleep(); // For Presentation ONLY
        //
        System.out.println("\t\tTest testUi() executed");
    }

}
