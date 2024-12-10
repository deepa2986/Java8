package java8.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterAndForEachExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("mia","anil","hema","minch","kouch","amar");

        list.stream().filter(s->s.startsWith("m")).forEach(System.out::println);

        System.out.println("----------------");
        Map<Integer,Character> map = new HashMap<>();
        map.put(1,'a');
        map.put(2,'b');
        map.put(3,'c');
        map.put(4,'d');

        map.entrySet().stream().forEach(System.out::println);

        System.out.println("-----------------");
        map.entrySet().stream().filter(k -> k.getKey() % 2 == 0).forEach(System.out::println);

        System.out.println("------------");
        map.entrySet().stream().filter(k->k.getValue().equals('d')).forEach(System.out::println);

    }
}
