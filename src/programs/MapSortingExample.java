package java8.streams;

import java.security.MessageDigest;
import java.util.Map;


public class MapSortingExample {

    public static void main(String[] args) {

        Map<String, String> ofEntries = Map.ofEntries(Map.entry("raphael", "starwars"),
                Map.entry("cristina", "matrix"), Map.entry("olivia", "jamesbond"));

        ofEntries.
                entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);

        System.out.println("---------------------------------------");
        ofEntries
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);


        String orDefault = ofEntries.getOrDefault("olivia", "matrix");
        System.out.println(orDefault);

     //   MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    }
}
