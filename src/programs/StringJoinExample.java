package programs;

import java.util.Arrays;
import java.util.List;

public class StringJoinExample {

    public static void main(String[] args) {

        String s = "2022-AB2147-895";
        System.out.println(s);
        List<String> strings1 = Arrays.asList(s.split("-"));
        // System.out.println(s);

        String joined2 = String.join("/", strings1);
        System.out.println(joined2);

        String joined = String.join("/", "20","AB2147","895","22");
        System.out.println(joined);


        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println(strings);

        String joined1 = String.join("-", strings);
        System.out.println(joined1);


    }
}
