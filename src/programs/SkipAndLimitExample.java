package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SkipAndLimitExample {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 7, 5, 3, 7, 8, 9);
        List<Integer> integers = list.stream()
                .skip(2)
                .limit(6)
                .collect(Collectors.toList());

        System.out.println(integers);
    }

}
