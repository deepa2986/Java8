package java8.streams.reduce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeData {


    public static List<Employee> getAllEmployee(){
        return Stream.of(new Employee(108,"vishnu","A",50000),
                new Employee(103,"arjun","B",80000),
                new Employee(102,"mini","A",49000),
                new Employee(101,"lilly","C",65000),
                new Employee(106,"ram","B",89000),
                new Employee(104,"dev","A",67000),
                new Employee(106,"ram","D",89000),
                new Employee(104,"dev","D",67000),
                new Employee(107,"shankar","C",90000)).collect(Collectors.toList());
    }
}
