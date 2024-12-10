package programs;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NthHighestSalary {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("anil",1100);
        map.put("maya",1400);
        map.put("kila",1800);
        map.put("bheem",1200);
        map.put("dev",1500);
        map.put("ciel",1300);

        Map.Entry<String, Integer> secondSmallestSalary = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList())
                .get(1);
        System.out.println("secondSmallestSalary : " + secondSmallestSalary);

//
//        Map.Entry<String, Integer> secondHighestSalary = map
//                .entrySet()
//                .stream()
//                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .collect(Collectors.toList())
//                .get(1);
//
//        System.out.println("secondHighestSalary : " +secondHighestSalary);

        Map.Entry<String, Integer> secondHighestSalary1 = getsSecondHighestSalary(1, map);
        System.out.println("secondHighestSalary1 : " + secondHighestSalary1);


        Map<String,Integer> map1 = new HashMap<>();
        map1.put("anil",1800);
        map1.put("paras",1500);
        map1.put("maya",1400);
        map1.put("arjun",1300);
        map1.put("kila",1800);
        map1.put("rekha",1300);
        map1.put("ria",1200);
        map1.put("bheem",1200);
        map1.put("dev",1500);
        map1.put("ciel",1300);

        Map<Integer, List<String>> integerListMap = map1.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(integerListMap);

        Map.Entry<Integer, List<String>> secondHoighestSalaryList = map1
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(1);
        System.out.println(secondHoighestSalaryList);


    }

    public static Map.Entry<String, Integer> getsSecondHighestSalary(int num, Map<String,Integer> map){
        return map
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num);
    }
}
