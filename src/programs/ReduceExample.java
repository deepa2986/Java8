package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReduceExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,7,8,1,5,9);

        List<String> words = Arrays.asList("london","japan","sweden","mexico","north america","switzerland","india","canada");
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        System.out.println(sum);

        int sum1 = list
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum1);

        int sum2 = list
                .stream()
                .mapToInt(i -> i)
                .sum();
        System.out.println(sum2);

        Integer reduce = list
                .stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("reduce : " +reduce);

        Integer integer = list.stream()
                .reduce(Integer::sum)
                .get();
        System.out.println(integer);

        Integer max = list
                .stream()
                .reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(max);

        Integer maxNumber = list
                .stream()
                .reduce(Integer::max)
                .get();
        System.out.println(maxNumber);

        Integer min = list
                .stream()
                .reduce(Integer::min)
                .get();
        System.out.println(min);

        List<Integer> integers = list
                .stream()
                .map(i -> i * 10)
                .collect(Collectors.toList());
        System.out.println(integers);

        String longestWord = words
                .stream()
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();
        System.out.println(longestWord);

        String smallestWord = words
                .stream()
                .reduce((w1, w2) -> w1.length() < w2.length() ? w1 : w2)
                .get();
        System.out.println(smallestWord);

    }
}
