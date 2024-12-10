package programs;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestElementOfAnArray {

    public static void main(String[] args) {
        int[] array = {5,9,11,2,8,21,1};

        Integer secondHighest = Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println("secondHighest :"+ secondHighest);

        Integer secondSmallest = Arrays.stream(array)
                .boxed()
                .sorted()
                .skip(1)
                .findFirst()
                .get();

        System.out.println("secondSmallest : "+secondSmallest);

        Integer smallest = Arrays.stream(array)
                .boxed()
                .sorted()
              //  .skip(1)
                .findFirst()
                .get();

        System.out.println(smallest);

        Integer highest = Arrays.stream(array)
                .boxed()
                .sorted(Comparator.reverseOrder())
              //  .skip(1)
                //.findFirst()
                .findAny()
                .get();
        System.out.println(highest);


    }
}
