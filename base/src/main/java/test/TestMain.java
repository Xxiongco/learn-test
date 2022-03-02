package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class TestMain {
    public static void main(String[] args) throws InterruptedException {

        //-----------------------------------------------------
//        Random random = new Random();
//        while (true){
//            System.out.println(random.nextBoolean());
//            Thread.sleep(1000L);
//        }

        // -----------------------------测试加上某一天
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        Date now = new Date();
//        Date end ;
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(now);
//        calendar.add(Calendar.DATE, 3);
//        end = calendar.getTime();
//
//        System.out.println(simpleDateFormat.format(now));
//        System.out.println(simpleDateFormat.format(end));

        // --------------------------------------------------
//        Integer a = new Integer(1);
//
//        System.out.println(Objects.equals(null,1));



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
