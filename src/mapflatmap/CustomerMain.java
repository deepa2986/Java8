package java8.streams.mapflatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerMain {

    public static void main(String[] args) {

        List<Customer> customers = CustomerData.getCustomers();

        List<String> customerEmails = customers
                .stream()
                .map(Customer::getEmail)
                .collect(Collectors.toList());

        System.out.println(customerEmails);

        List<List<String>> phoneNumbers = customers.stream()
                .map(Customer::getPhoneNumber)
                .collect(Collectors.toList());

        System.out.println(phoneNumbers);

        List<String> phoneNumbersF = customers.stream()
                .flatMap(customer -> customer.getPhoneNumber().stream())
                .collect(Collectors.toList());
        System.out.println(phoneNumbersF);
        System.out.println("-----------------------------------------------------");
        
        List<String> emailList = customers.stream().map(Customer::getEmail).collect(Collectors.toList());
        System.out.println(emailList);
        System.out.println("-------------------------------------------------------");

        List<Integer> integers = customers.stream()
                .map(customer -> customer.getId() * 10).collect(Collectors.toList());

        System.out.println(integers);

    }
}
