package com.softserve.edu04rest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AppExample {
  final OkHttpClient client = new OkHttpClient();

  String run(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
  }

  public static void main(String[] args) throws IOException {
    AppExample appExample = new AppExample();
    String response = appExample.run("https://raw.github.com/square/okhttp/master/README.md");
    System.out.println(response);
  }
}