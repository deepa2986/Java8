package modernjava.person;

import java.util.*;

public class PersonMain {

    public static void main(String[] args) {

        List<Person> list = PersonData.getAllPerson();

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()- o2.getAge();
            }
        });

        System.out.println(list);

        System.out.println("===========================================================");

        Collections.sort(list, Comparator.comparing(Person::getAge).reversed());
        System.out.println(list);

        System.out.println("=======================================================");

        Collections.sort(list,Comparator.comparing(Person::getName));
        list.forEach(person -> System.out.println(person));

        System.out.println("======================================================");

        Collections.sort(list,Comparator.comparing(Person::getAge).thenComparing(Person::getName));
        list.forEach(person -> System.out.println(person));

        System.out.println("==================================================");

        Collections.sort(list,Comparator.comparing(Person::getName).thenComparing(Person::getAge));
        list.forEach(person -> System.out.println(person));


        System.out.println("--------------------------------------------------------------");
       List<Integer> integers = Arrays.asList(5,14,1,8,2,6,0);
        System.out.println(integers);
       integers.sort(Comparator.naturalOrder());
        System.out.println(integers);

    }
}
