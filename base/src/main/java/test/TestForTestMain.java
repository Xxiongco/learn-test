package test;

import org.junit.Test;

public class TestForTestMain {

    @Test
    public void test(){
        if ( false && custom()
        ){
            System.out.println("in if");
        }
        else {
            System.out.println("in else");
        }
    }

    public static boolean custom(){
        System.out.println("in custom");
        return true;
    }

}
