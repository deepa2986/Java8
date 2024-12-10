package foodstore;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class DishCollectorMethods {

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

        System.out.println("---------------toList--------------");
       // List<Dish> dishes =
                menu
                .stream()
                .collect(Collectors.toList())
                        .forEach(System.out::println);

       // System.out.println(dishes);

        System.out.println("----------toSet-------------");

        menu
                .stream()
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("-------------------toCollection-------------");
        menu
                .stream()
                .collect(Collectors.toCollection(ArrayList::new))
                .forEach(System.out::println);

        System.out.println("----------------counting---------------");

        Long noOfDishes =
                menu
                .stream()
                .collect(counting());
        System.out.println(noOfDishes);

        System.out.println("----------summingInt----------");

        Integer totalCalorie =
                menu
                .stream()
                .collect(summingInt(Dish::getCalories));
        System.out.println(totalCalorie);


        System.out.println("--------------averagingInt-----------------");

        Double avgOfCalories = menu
                .stream()
                .collect(averagingInt(Dish::getCalories));
        System.out.println(avgOfCalories);

        System.out.println("-------------summarizingInt-----------------");

        IntSummaryStatistics menuStatistics =
                menu
                .stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatistics);

        System.out.println("------------------joining------------");

        String shortMenu =
                menu
                .stream()
                .map(Dish::getName)
                .collect(joining(", "));

        System.out.println(shortMenu);

        System.out.println("---------------maxBy--------------------");

        Dish fattestDish = menu
                .stream()
                .collect(maxBy(Comparator.comparing(Dish::getCalories)))
                .get();

        System.out.println(fattestDish);

        String fattestDishName =
                menu
                .stream()
                .collect(maxBy(Comparator.comparingInt(Dish::getCalories)))
                .get()
                .getName();

        System.out.println(fattestDishName);

        boolean b =
                menu
                .stream()
                .collect(maxBy(Comparator.comparingInt(Dish::getCalories)))
                .get()
                .getName()
                .startsWith("a");
        System.out.println(b);

        List<Dish> dishes = new ArrayList<>(Arrays.asList());

        Optional<Dish> collect =
                dishes
                .stream()
                .collect(maxBy(Comparator.comparingInt(Dish::getCalories)));
        System.out.println(collect);

//        Dish dish = dishes
//                .stream()
//                .collect(maxBy(Comparator.comparingInt(Dish::getCalories)))
//                .get(); //throw exception  java.util.NoSuchElementException: No value present
//        System.out.println(dish);


        System.out.println("---------------------minBy-------------");
        Optional<Dish> lightestDish = menu
                .stream()
                .collect(minBy(Comparator.comparing(Dish::getCalories)));

        System.out.println(lightestDish);

        System.out.println("----------------reducing--------------");

        Integer sumOfCalorie = menu
                .stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));

        System.out.println(sumOfCalorie);

        System.out.println("---------------------collectingAndThen---------------");

        Integer howManyDishes = menu
                .stream()
                .collect(collectingAndThen(toList(), List::size));

        System.out.println(howManyDishes);

        System.out.println("--------------groupingBy----Type------------");
        menu
                .stream()
                .collect(groupingBy(Dish::getType))
                .entrySet()
                .forEach(System.out::println);

        System.out.println("-------------------partitionBy----------------");
        menu
                .stream()
                .collect(partitioningBy(Dish::isVegetarian))
                .entrySet()
                .forEach(System.out::println);


    }
}
