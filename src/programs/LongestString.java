package programs;

import java.util.Arrays;

public class LongestString {

    public static void main(String[] args) {

        String[] strings = {"amazon","gcp webservice","microsoft azure","kill bill pandey"};

        String longestString = Arrays
                        .stream(strings)
                        .reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2)
                        .get();
        System.out.println("longest string : "+longestString);

        String smallestString = Arrays
                .stream(strings)
                .reduce((s1, s2) -> s1.length() < s2.length() ? s1 : s2)
                .get();
        System.out.println("smallest string : " +smallestString);

    }
}
