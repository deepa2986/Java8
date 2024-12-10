package modernjava.foodstore;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class DishTags {

    public static void main(String[] args) {

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));


        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120,  Dish.Type.OTHER),
                new Dish("pizza", true, 550,  Dish.Type.OTHER),
                new Dish("prawns", false, 300,  Dish.Type.FISH),
                new Dish("salmon", false, 450,  Dish.Type.FISH) );

        System.out.println("--------------------dishNamesByType-------------------");
        Map<Dish.Type, List<String>> dishNamesByType =
                menu
                        .stream()
                        .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
        System.out.println(dishNamesByType);

        System.out.println("--------------------dishNamesByType-------------");
        menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.mapping(Dish::getName,Collectors.toList())))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("---------------dishNamesByType1-----------------");
        Map<Dish.Type, Set<String>> dishNamesByType1 = menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.flatMapping(dish -> dishTags.get(dish.getName()).stream(), Collectors.toSet())));
        System.out.println(dishNamesByType1);


        System.out.println("-------------dishTypeAndCount-------------");
        Map<Dish.Type, Long> dishTypeAndCount = menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(dishTypeAndCount);

        System.out.println("--------------maxCalorieDish------------");
        Map<Dish.Type, Optional<Dish>> maxCalorieDish = menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
        System.out.println(maxCalorieDish);

        System.out.println("---------------------------------------------------");

        menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))))
                .entrySet()
                .forEach(System.out::println);


        System.out.println("----------------------------------------------------------------------");
        // Map<Dish.Type, Dish> maxDish =
        menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)))
                .entrySet()
                .forEach(System.out::println);

        //  System.out.println(maxDish);

        System.out.println("-------------------------summingIntByType---------------------");

        menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.summingInt(Dish::getCalories)))
                .entrySet()
                .forEach(System.out::println);


        System.out.println("----------------------partitionBy-vegetarian-dishes-------------------------");

        menu
                .stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian))
                .entrySet()
                .forEach(System.out::println);


        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));

      //  List<Dish> vegetarianDishes =
                partitionedMenu.get(true).forEach(System.out::println);
      //  System.out.println(vegetarianDishes);

        System.out.println("-------------------vegetarian-dishes-by-type------------------");

        menu
                .stream()
                .collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType)))
                .entrySet()
                .forEach(System.out::println);

        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu
                .stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        System.out.println(vegetarianDishesByType);

        Map<Boolean, Dish> maxCaloricDishBy = menu
                .stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));

        System.out.println(maxCaloricDishBy);

        System.out.println("------------------------------calorie greaterThan 500-----------------");

        menu
                .stream()
                .collect(partitioningBy(Dish::isVegetarian,partitioningBy(d -> d.getCalories() > 500)))
                .entrySet()
                .forEach(System.out::println);

        Map<Boolean, Long> countDishes = menu
                .stream()
                .collect(partitioningBy(Dish::isVegetarian, counting()));
//                .entrySet()
//                .forEach(System.out::println);

        System.out.println(countDishes);
    }
}
