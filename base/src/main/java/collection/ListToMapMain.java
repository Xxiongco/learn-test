package collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListToMapMain {
    public static void main(String[] args) {
        List<Cat> cats = init();
        //test(cats);
        //test2(cats);

        test3(cats);

    }


    public static void test3(List<Cat> cats){

        Comparator<Cat> comparing = Comparator.comparing(Cat::getNum);

       // Map<String, List<Cat>> collect = cats.stream().collect(Collectors.reducing);


    }

    public static void test2(List<Cat> cats){
        Map<String, Cat> map = cats.stream().collect(
                Collectors.toMap(Cat::getNum, Function.identity(), (c1, c2) -> c1.getAge() > c2.getAge() ? c1 : c2));

        map.forEach((k,v) ->{
            System.out.println(k + " : " + v);
        });


        List<Cat> catList = new ArrayList<>(map.values());

        for (Cat cat : catList) {
            System.out.println(cat);
        }


    }

    public static void test(List<Cat> cats){
        Map<String, Cat> map = cats.parallelStream().collect(
                Collectors.groupingBy(Cat::getNum,
                        Collectors.collectingAndThen(
                                Collectors.reducing((c1, c2) -> c1.getAge() > c2.getAge() ? c1 : c2),
                                Optional::get)));

        map.forEach((k,v) ->{
            System.out.println(k + " : " + v);
        });

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



        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);
        cats.add(cat6);
        cats.add(cat7);
        cats.add(cat8);

        return cats;
    }

}
