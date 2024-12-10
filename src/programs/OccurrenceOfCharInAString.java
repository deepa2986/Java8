package programs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurrenceOfCharInAString {

    public static void main(String[] args) {
        String s = "dillileaves";
        char[] chars = s.toCharArray();

        System.out.println("--------each char and its occurrences-------");
        Map<String, Long> map = Arrays
                .stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // .forEach((s1, count) -> System.out.println(s1 + " : " +count ));

        System.out.println(map);

        System.out.println("----------duplicates and is count------------");
        List<Map.Entry<String, Long>> list = Arrays
                .stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() > 1)
                //  .forEach((k) -> System.out.println(k));
                .collect(Collectors.toList());
        System.out.println(list);

        System.out.println("-----------duplicates------------");

        // List<String> duplicates =
        Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .forEach(k -> System.out.print(k + " "));
        // .collect(Collectors.toList());
        // System.out.println(duplicates);

        System.out.println();

        System.out.println("-----------------uniques-----------------");

        List<String> uniques = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(uniques);


        System.out.println("-------first non repeating char-------------------");

        String firstNonRepeatingChar = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
        System.out.println(firstNonRepeatingChar);

        System.out.println("-------first repeating char---------------");

        String firstRepeatingChar = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m -> m.getValue() > 1)
                .findFirst()
                .get()
                .getKey();
        System.out.println(firstRepeatingChar);

    }
}
