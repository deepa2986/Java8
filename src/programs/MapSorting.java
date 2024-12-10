package java8.streams;

import java8.streams.filterforeach.Employee;

import java.util.*;

public class MapSorting {

    public static void main(String[] args) {

        Map<String,Integer>  map = new HashMap<>();

        map.put("nine",9);
        map.put("four",4);
        map.put("april",1);
        map.put("june",3);
        map.put("may",5);
        map.put("feb",2);

        map.entrySet().stream().forEach(System.out::println);

        System.out.println("-------------------------------------------");

        List<Map.Entry<String,Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String,Integer>>(){

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

      for (Map.Entry<String,Integer> entry : entries)
          System.out.println(entry.getKey() + " : " + entry.getValue());

        System.out.println("_____________________");

      Collections.sort(entries,((o1,o2) -> o1.getValue().compareTo(o2.getValue())));

        for (Map.Entry<String,Integer> entry : entries)
            System.out.println(entry.getKey() + " : " + entry.getValue());

        System.out.println("_______________________________");

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        System.out.println("---------------------------------------------");

        Map<Employee,Integer> employeeMap = new TreeMap<>((e1,e2) -> Math.toIntExact(e1.getSalary() - e2.getSalary()));

        employeeMap.put(new Employee(1,"june","IT",180000,true),50);
        employeeMap.put(new Employee(4,"bina","Account",900000,false),40);
        employeeMap.put(new Employee(3,"maya","IT",1000000,false),30);
        employeeMap.put(new Employee(2,"arjun","HR",800000,true),90);
        employeeMap.put(new Employee(8,"jia","Account",400000,false),20);
        employeeMap.put(new Employee(5,"ankit","IT",600000,false),70);
        employeeMap.put(new Employee(6,"reva","HR",500000,true),10);

        System.out.println(employeeMap);

        System.out.println("-------------------------------------------------------");

        employeeMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary)))
                .forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");
        employeeMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        System.out.println("---------------------------------------------------------");

        employeeMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName)))
                .forEach(System.out::println);





    }
}
