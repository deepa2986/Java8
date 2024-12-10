package programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintNumberStartsWith {

    public static void main(String[] args) {
        int[] numbers = {5,9,11,2,8,21,1,26};

        List<String> list = Arrays.stream(numbers)
                .boxed()
                .map(integer -> integer + "")
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());
        System.out.println(list);

        List<String> list1 = Arrays.stream(numbers)
                .boxed()
                .map(i -> i + "")
                .filter(s -> s.startsWith("2"))
                .collect(Collectors.toList());
        System.out.println(list1);

    }
}
