package programs;

import java8.streams.filterforeach.Employee;
import java8.streams.filterforeach.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMiscellaneous {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("neema","kill",null,"bill","siva",null,null);
        List<String> strings = list
                .stream()
                .filter(name -> name != null)
                .collect(Collectors.toList());

        System.out.println(strings);

        List<String> collect = list
                .stream()
                .flatMap(Stream::ofNullable)
                .collect(Collectors.toList());
        System.out.println(collect);

        //infinite numbers
        Stream.iterate(0,n->n+2)
                .limit(5)
                .forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployee();

        Long avg = employees
                .stream()
                .map(Employee::getSalary)
                .collect(Collectors.collectingAndThen(Collectors.averagingDouble(Long::longValue), Math::round));
        System.out.println(avg);

//        employees
//                .stream()
//                .map(Employee::getSalary)
//                .
    }
}
