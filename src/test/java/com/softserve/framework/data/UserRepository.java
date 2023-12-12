package com.softserve.framework.data;

public final class UserRepository {

    private UserRepository() {
    }

    public static User getDefault() {
        return getValidUserQwertyY();
    }

    public static User getValidUserQwertyY() {
        return new User("tyv09754@zslsz.com", "Qwerty_1", "QwertyY");
    }

    public static User getValidUserQwertyY2() {
        return new User("uvsshemwlgedtlowbi@cazlv.com", "Qwerty_1", "QwertyY2");
    }

    /*
    public List<User> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }

    public List<User> fromCsv() {
        return fromCsv("users.csv");
    }

    public List<User> fromExcel(String filename) {
        return User.getByLists(new ExcelReader(filename).getAllCells());
    }

    public List<User> fromExcel() {
        return fromExcel("users.xlsx");
    }
    */
}