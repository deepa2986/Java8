package mapflatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerData {

    public static List<Customer> getCustomers(){
        List<Customer> customers = Stream.of(new Customer(1, "lilly", "lilly@gmail.com", Arrays.asList("9860922345", "3215674323")),
                new Customer(3, "dev", "dev@gotmail.com", Arrays.asList("9023421233", "4532167890")),
                new Customer(2, "giggy", "gig@gmail.com", Arrays.asList("7637823909", "1230994432"))).collect(Collectors.toList());
        return customers;
    }
}
