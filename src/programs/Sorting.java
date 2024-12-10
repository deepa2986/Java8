package programs;

import java8.streams.filterforeach.Employee;
import java8.streams.filterforeach.EmployeeData;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(9,2,1,1,8,3,10,4,6);

        Collections.sort(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployee();

        employees.stream().sorted((e1,e2) -> Math.toIntExact((int) e1.getSalary() - e2.getSalary())).forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------");
        employees.stream().sorted(Comparator.comparing(e -> e.getDept())).forEach(System.out::println);

        System.out.println("----------------------------------------------------------------------------");
        employees.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
    }
}
