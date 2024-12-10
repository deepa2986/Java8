package person;

import java.util.ArrayList;
import java.util.List;

public class PersonData {

    public static List<Person> getAllPerson(){

        List<Person> list = new ArrayList<>();
        list.add(new Person(90,"nina"));
        list.add(new Person(28,"shankar"));
        list.add(new Person(19,"amar"));
        list.add(new Person(23,"mayur"));
        list.add(new Person(22,"janaki"));
        list.add(new Person(20,"thiru"));
        return list;
    }
}
