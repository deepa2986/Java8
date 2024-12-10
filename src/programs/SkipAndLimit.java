package programs;

import java.util.stream.IntStream;

public class SkipAndLimit {

    public static void main(String[] args) {
        IntStream.rangeClosed(1,10)
                .skip(1)
                .limit(8)
                .forEach(System.out::println);
    }
}
