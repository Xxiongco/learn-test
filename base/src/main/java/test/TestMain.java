package test;

import java.util.Objects;

public class TestMain {
    public static void main(String[] args) {
        Integer a = new Integer(200);
        Integer b = new Integer(200);

        System.out.println(a.equals(b));

        System.out.println(Objects.equals(a, b));

    }
}
