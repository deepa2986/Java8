package filterforeach;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMain {

    public static List<Employee> evaluateTaxUsers(){
        List<Employee> employees = EmployeeData.getEmployee()
                .stream()
                .filter(employee -> employee.getSalary() > 500000)
                .collect(Collectors.toList());
        return employees;
    }

    public static List<Employee> taxUsers(String input){
        return input.equalsIgnoreCase("tax")?
                EmployeeData.getEmployee().stream().filter(employee -> employee.getSalary() > 500000).collect(Collectors.toList())
                :EmployeeData.getEmployee().stream().filter(employee -> employee.getSalary() <= 500000).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Employee> employeeTaxUser = evaluateTaxUsers();
        System.out.println(employeeTaxUser);

        List<Employee> taxUsers = taxUsers("non tax");
        System.out.println(taxUsers);

        System.out.println(" ____________________________________________________________ ");

        List<Employee> employees = EmployeeData.getEmployee();

        employees
                .stream()
                .sorted(Comparator.comparing(Employee::getDept))
                .forEach(System.out::println);

        employees
                .stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getName)
                .forEach(System.out::println);

        List<String> employeeNames = employees
                .stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed())
                .filter(Employee::isActive)
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Active employees : " +employeeNames);

        List<String> namesList = employees
                .stream()
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("namesList : " + namesList);

        Set<String> nameSet = employees
                .stream()
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.toSet());

        System.out.println("nameSet : " + nameSet);

        Map<String,Employee> employeeMap = employees
                .stream()
                .limit(4)
                .collect(Collectors.toMap(e -> e.getName(),e -> e));
        // .entrySet()
        // .forEach(System.out::println);
        System.out.println(employeeMap);

        employees
                .stream()
                .limit(4)
                .collect(Collectors.toMap(e -> e.getName(),e -> e))
                .entrySet()
                .forEach(System.out::println);

        String namesEmployee = employees
                .stream()
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(namesEmployee);


       // Map<String, List<Employee>> employeeByDept =
                employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDept))
                        .entrySet().forEach(System.out::println);
       // System.out.println(employeeByDept);

       // Map<String, Long> employeeDeptCounting =
                employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()))
                        .entrySet()
                        .forEach(System.out::println);

       // System.out.println(employeeDeptCounting);


    }
}
