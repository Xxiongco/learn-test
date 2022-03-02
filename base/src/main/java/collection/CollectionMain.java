package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用于学习集合
 */
public class CollectionMain {
    public static void main(String[] args) {
        testAnd();
    }
    public static void testAnd(){
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        b.add(3);
        b.add(4);
        b.add(5);

        List<Integer> collect = a.stream().filter(b::contains).collect(Collectors.toList());
        System.out.println(collect);


    }



}
