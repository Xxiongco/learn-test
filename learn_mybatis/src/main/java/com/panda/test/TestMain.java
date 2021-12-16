package com.panda.test;

public class TestMain {
    public static void main(String[] args) {

        String s = testStringValueIsNUll(null);
        System.out.println(s);

    }
    public static String testStringValueIsNUll(String str){
        int length = str.length();
        System.out.println(length);
        return String.valueOf(length);
    }
}
