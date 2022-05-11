import collection.Cat;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import learn.domian.Student;
import learn.domian.Two;
import org.junit.Test;
import test.StudentTwo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMain {

    @Test
    public void test(){
        Student student = new Student();
        student.setId(1);
        student.setName(null);

        String s = JSONObject.toJSONString(student);
        System.out.println(s);


    }

    @Test
    public void testAssert(){
        Student student = new Student();

        assert student == null : "student not null";

    }

    /**
     * 测试重载是否可以发生在子父类中
     */
    @Test
    public void test2(){
        Two two = new Two();
        
    }

    @Test
    public void test3(){

        List<Cat> catList = init();

        Map<Integer, String> collect = catList.stream().collect(Collectors.toMap(Cat::getId, Cat::toString));

        Set<Map.Entry<Integer, String>> entries = collect.entrySet();

        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @Test
    public void test4() {
        List<Cat> init = init();

        Optional<Cat> first = init.stream().filter(a -> a.getId() > 10).findFirst();

        System.out.println(first.isPresent());
        System.out.println(first.get());


    }

    @Test
    public void test5() {

        String s = "  你好， panda    ";
        String s1 = s.replaceAll("，", ",");
        String s2 = s1.replaceAll(" ", "");
        System.out.println(s1);
        System.out.println(s2);

        String s3 = s.replaceAll("[\\s,，]", "");

        System.out.println(s3);

        String[] split = s2.split(",");
        System.out.println(split.length);
        for (String s4 : split) {
            System.out.println(s4);
        }

    }
    @Test
    public void test6() {

        List<Cat> init = init();

//        List<String> list = init.stream().map(Cat::getName).collect(Collectors.toList());
//
//        System.out.println(list);

        List<String> collect = init.stream().map(Cat::getNum).distinct().collect(Collectors.toList());

        System.out.println(collect);

    }

    @Test
    public void test7(){

        Cat cat = new Cat();

        System.out.println(cat);


    }

    @Test
    public void test8() {

        List<Cat> init = init();

        Map<Integer, Cat> map = init.stream().collect(Collectors.toMap(Cat::getId, Function.identity()));

        Cat cat = new Cat();

        cat.setId(10);

        Cat gello = map.computeIfAbsent(cat.getId(), x -> {
            return new Cat(x, "2022", 20, "gello");
        });

        System.out.println(gello);

        System.out.println(map);

    }

    @Test
    public void test9() {
        Long a = 1L;

        Date date = new Date();
        Date clone = (Date)date.clone();

        System.out.println(clone == date);

        System.out.println(date.after(clone));

        System.out.println(date.equals(clone));

        System.out.println(date.compareTo(clone) >= 0);

    }

    @Test
    public void test10() {
        String str = "hello.java";

        System.out.println(str.length());

        int i = str.indexOf('.');
        System.out.println(i);

        System.out.println(str.length() - i - 1);

        System.out.println(str.substring(i + 1));




    }

    @Test
    public void test11() {
        Cat cat1 = new Cat(1, "2011", 11, "panda");
        Cat cat2 = new Cat(1, "2011", 11, "panda");
        Cat cat3 = new Cat(1, "2012", 13, "panda");
        Cat cat4 = new Cat(1, "2012", 14, "panda4");

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);

        List<Cat> collect = cats.stream().distinct().collect(Collectors.toList());

        System.out.println(collect.size());

    }
    @Test
    public void test12() {
        int y = 0;
        boolean x = y > 0 ;

    }

    public static List<Cat> init(){
        Cat cat1 = new Cat(1, "2011", 11, "panda1");
        Cat cat2 = new Cat(2, "2011", 12, "panda2");
        Cat cat3 = new Cat(3, "2012", 13, "panda3");
        Cat cat4 = new Cat(4, "2012", 14, "panda4");
        Cat cat5 = new Cat(5, "2015", 15, "panda5");
        Cat cat6 = new Cat(6, "2015", 16, "panda6");
        Cat cat7 = new Cat(7, "2015", 17, "panda7");
        Cat cat8 = new Cat(8, "2016", 18, "panda8");
        Cat cat9 = new Cat(9,"2016",100,"panda9");

        cat9.setName(null);

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);
        cats.add(cat6);
        cats.add(cat7);
        cats.add(cat8);
        cats.add(cat9);


        return cats;
    }

    @Test
    public void testgg() {
        int a = 1;
        int b = 2;

        int c = (2*a + 2*b - 1) / 2;
        int d = a + b - 1;

       System.out.println(c);
       System.out.println(d);

    }



}
