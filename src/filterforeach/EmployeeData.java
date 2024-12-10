package filterforeach;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployee(){
        List<Employee> employees =new ArrayList<>();
        employees.add(new Employee(1,"amith","IT",500000,true));
        employees.add(new Employee(12,"manav","Accounts",390000,false));
        employees.add(new Employee(3,"heina","HR",800000,false));
        employees.add(new Employee(41,"arjun","Accounts",700000,true));
        employees.add(new Employee(8,"naina","HR",590000,true));
        employees.add(new Employee(2,"mandira","Support",100000,false));
        employees.add(new Employee(34,"tulasi","IT",88000,true));
        return employees;
    }
}
