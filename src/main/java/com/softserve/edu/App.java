package com.softserve.edu;

public class App {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.print("o");
            System.err.print("_");
            Thread.sleep(1);
        }
    }
}
