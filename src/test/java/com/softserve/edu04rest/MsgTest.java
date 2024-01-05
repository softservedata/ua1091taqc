package com.softserve.edu04rest;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.jupiter.api.Test;


public class MsgTest {
    @Test
    public void checkMsg() throws Exception {
        String lifeTime;
        String result;
        //
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody;
        Request request;
        Response response;
        String resultJson;
        //
        request = new Request
                .Builder()
                //.url("https://speak-ukrainian.org.ua/dev/api/messages/recipient/1")
                //.url("https://speak-ukrainian.org.ua/api/roles")
                .url("http://speak-ukrainian.eastus2.cloudapp.azure.com/dev/api/user/2")
                .get()
                .addHeader("accept","*/*")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJleHAiOjE3MDQ0ODU0NzF9.vCrpk0BrrHFFfjtSU2hoa4f4FFw8vJiBw_B0ypA28nXlCCWBh7haRDphKJq4uAjHUFqWQ1sdhNPW5Mh_wTg5xQ")
                .build();
        response = client.newCall(request).execute();
        resultJson = response.body().string();
        //
        System.out.println("resultJson: " + resultJson);
    }


}
