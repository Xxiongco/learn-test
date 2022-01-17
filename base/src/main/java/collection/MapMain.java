package collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class MapMain {
    public static void main(String[] args) {
        Map<Integer, Cat> map = init();

        System.out.println("*****      before       *****");
        map.forEach((integer, cat) -> {
            System.out.println(integer + " : " + cat);
        });

        test(map,9);

        System.out.println("*****      after       *****");

        map.forEach((integer, cat) -> {
            System.out.println(integer + " : " + cat);
        });

    }
    public static void test(Map<Integer,Cat> map,Integer id){
        map.computeIfAbsent(id,item -> {
            return new Cat(item,item.toString(),item,item.toString());
        });
    }

    public static Map<Integer, Cat> init(){

        List<Cat> cats = ListToMapMain.init();
        HashMap<Integer, Cat> map = new HashMap<>();

        for (int i = 0; i < cats.size(); i++) {
            map.put(i,cats.get(i));
        }
        return map;
    }
}
