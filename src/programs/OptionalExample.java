package java8.streams;

import java8.streams.mapflatmap.Customer;
import java8.streams.mapflatmap.CustomerData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {

    public static Customer getCustomerByEmail(String email){
        List<Customer> customers = CustomerData.getCustomers();
        Customer customer1 = customers
                .stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findAny()
                .orElseThrow(() -> new RuntimeException("No email found"));
        return customer1;
    }

    public static void main(String[] args) {

        Customer customer = new Customer(1,"ram","ram@gmail.com", Arrays.asList("3344211344","099049494332"));
        Customer customer1 = new Customer(2,"raj",null,Arrays.asList("9099494400","83848484333"));

        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

       // Optional<String> optionalEmail = Optional.of(customer1.getEmail());
      //  System.out.println(optionalEmail); //null pointer exception

        Optional<String> optionalEmailOfNullable = Optional.ofNullable(customer1.getEmail());
        System.out.println(optionalEmailOfNullable);

        Optional<String> customerEmail = Optional.ofNullable(customer1.getEmail());
      //  System.out.println(customerEmail.get());//No such element exception

        Optional<String> optionalEmailGet = Optional.ofNullable(customer1.getEmail());
        if(optionalEmailGet.isPresent()){
            System.out.println(optionalEmailGet.get()); //does not return anything if the value is null
        }
//        String orElse = optionalEmailGet.orElse("default@email.com");
//        System.out.println(orElse);
//        String emailNotPresent = optionalEmailGet.orElseThrow(() -> new IllegalArgumentException("email not present"));
//        System.out.println(emailNotPresent);
//
        Optional<String> email = Optional.ofNullable(customer1.getEmail());
        String orElseGet = email.map(String::toUpperCase).orElseGet(() -> "default email...");
        System.out.println(orElseGet);

        getCustomerByEmail("abc");
    }
}
