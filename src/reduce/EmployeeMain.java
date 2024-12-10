package reduce;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeData.getAllEmployee();
        employees.forEach(employee -> System.out.println(employee));

        double avgSalary = employees
                .stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();

        System.out.println(avgSalary);

        double sumOfSalaryOfGradeA = employees
                .stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(Employee::getSalary)
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.println(sumOfSalaryOfGradeA);

        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
               // .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("------------------------------------------------------");

        Employee employeeWithMaxSalary = employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                .get();
        System.out.println(employeeWithMaxSalary);

        System.out.println("------------------------------------------------");

        Employee employeeWithMinSalary = employees.stream()
                .reduce((e1,e2) -> e1.getSalary() < e2.getSalary() ? e1 : e2)
                .get();

        System.out.println(employeeWithMinSalary);

        System.out.println("--------------------------------");

      //  Map<String, List<Employee>> employeeByGrade =
                employees.stream()
                .collect(Collectors.groupingBy(Employee::getGrade))
                .entrySet()
                .forEach((k) -> System.out.println(k));
//        for (Map.Entry <String,List<Employee>> entry : employeeByGrade.entrySet()){
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
      //  System.out.println(employeeByGrade);

        System.out.println("------------------------------");

        Double totalSalary = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));

        System.out.println(totalSalary);

        System.out.println("---------------------------");

        long countGrade = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGrade))
                .entrySet()
                .stream()
                .count();
        System.out.println(countGrade);


    }
}
