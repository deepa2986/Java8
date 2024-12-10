package programs;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Map.entry;

public class ReplaceAll {

    public static void main(String[] args) {

        Map<String ,String> movies = new HashMap<>();
        movies.put("rapheal","star wars");
        movies.put("olivia","matrix");

        System.out.println(movies);

        movies.replaceAll((k,v) -> v.toUpperCase());
        movies.forEach((k,v) -> System.out.println(k + " : " + v));

        Map<String,String> family = Map.ofEntries(entry("Teo", "Star Wars"), entry("Cristina", "James Bond"));

        Map<String, String> friends = Map.ofEntries(entry("Raphael", "Star Wars"));

        Map everyOne = new HashMap<>(family);

        everyOne.putAll(friends);
        System.out.println(everyOne);

        System.out.println("-------------------------------------------------");


        Map<String, String> familyNew = Map.ofEntries(
                entry("Teo", "Star Wars"), entry("Cristina", "James Bond"));
        Map<String, String> friendsNew = Map.ofEntries(
                entry("Raphael", "Star Wars"), entry("Cristina", "Matrix"));

        Map<String,String>  all = new HashMap<>(familyNew);
        friendsNew.forEach((k,v) -> all.merge(k,v,(m1,m2) -> m1 + " &" +m2));
        System.out.println(all);

        System.out.println("===================================");

        boolean b = movies.entrySet().removeIf((k) -> k.getValue().startsWith("S"));
        System.out.println(b);
        System.out.println(movies);

        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        long parallelismThreshold = 1;
        Optional<Integer> maxValue =
                Optional.ofNullable(Math.toIntExact(map.reduceValues(parallelismThreshold, Long::max)));
        System.out.println(maxValue);
    }
}
