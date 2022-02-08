package test;

import java.util.Objects;
import java.util.Random;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {

        //-----------------------------------------------------
        Random random = new Random();
        while (true){
            System.out.println(random.nextBoolean());
            Thread.sleep(1000L);
        }



        // -----------------------------------------------------
//        Integer a = new Integer(200);
//        Integer b = new Integer(200);
//
//        System.out.println(a.equals(b));
//
//        System.out.println(Objects.equals(a, b));
// ---------------------------------------------------------------------
//        Student a = new Student();
//        Student b = new Student(1,"padna","2017");
//
//        System.out.println(a);
//        test(a,b);
//        System.out.println(a);

        // --------------------------------------------------

    }

    public static void test(Student a , Student b){
        a.setId(b.getId());
        a.setName(b.getName());
        a.setNum(b.getNum());
    }

}
