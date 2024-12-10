package foodstore;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class DishMain {

    public static void main(String[] args) {
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


        List<String> dishNamesByCalorie = menu
                .stream()
                .filter(c -> c.getCalories() > 400)
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(dishNamesByCalorie);

        List<String> sortedDishNames = menu
                .stream()
                .filter(c -> c.getCalories() > 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(sortedDishNames);


        Map<Dish.Type, List<Dish>> dishesByType = menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType))
                .entrySet()
                .forEach(System.out::println);

        List<String> threeHighestCalorieDishNames = menu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighestCalorieDishNames);


        List<String> threeHighestCalorieDishNamess = menu
                .stream()
                .filter(dish -> {
                    System.out.println("filtering : " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping : " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighestCalorieDishNamess);

        List<String> dishNames = menu
                .stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<String> vegetarianDishes = menu
                .stream()
                .filter(dish -> dish.isVegetarian())
                .map(Dish::getName)
                .collect(Collectors.toList());
        System.out.println(vegetarianDishes);

        List<String> allDishNames = menu
                .stream()
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(allDishNames);

        System.out.println("--------------------map --------------------");

        List<Integer> dishNamesLength =
                menu
                        .stream()
                        .map(Dish::getName)
                        .map(String::length)
                        .collect(Collectors.toList());

        System.out.println("dishNamesLength : " +dishNamesLength);

        boolean allMatch = menu
                .stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(allMatch);

        boolean noneMatch =
                menu
                        .stream()
                        .noneMatch(dish -> dish.getCalories() > 1500);
        System.out.println(noneMatch);

        boolean anyMatch = menu
                .stream()
                .anyMatch(dish -> dish.getCalories() <  30);
        System.out.println("anyMatch : " +anyMatch);

        menu
                .stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));

        menu
                .stream()
                .filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(System.out::println);

        Dish dish =
                menu
                        .stream()
                        .min(Comparator.comparing(Dish::getCalories)).get();
        System.out.println(dish);

        Integer sum = menu
                .stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(sum);

        int sum1 = menu
                .stream()
                .mapToInt(Dish::getCalories)
                .sum();

        System.out.println(sum1);

        int max = menu
                .stream()
                .mapToInt(Dish::getCalories)
                .max()
                .getAsInt();
        System.out.println("max : " +max);

        int min = menu
                .stream()
                .mapToInt(Dish::getCalories)
                .min()
                .getAsInt();

        System.out.println("min : "+min);

        Long dishesCount =
                         menu
                        .stream()
                        .collect(Collectors.counting());
        System.out.println(dishesCount);

        long count = menu
                .stream()
                .count();

        System.out.println("no of dishes : " + count);


        Dish maxDish = menu
                .stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)))
                .get();

        System.out.println(maxDish);

        Integer calorieSum = menu
                .stream()
                .collect(Collectors.summingInt(Dish::getCalories));

        System.out.println(calorieSum);

        Double avgCalorie = menu
                .stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(avgCalorie);

        IntSummaryStatistics menuSummaryStatistics = menu
                .stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println("menuSummaryStatistics : " +menuSummaryStatistics);


        String shortMenu = menu
                .stream()
                .map(Dish::getName)
                .collect(joining(","));
        System.out.println("shortMenu : " + shortMenu);

        Integer totalCalories = menu
                .stream()
                .collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories);

        Dish highestCalorieDish = menu
                .stream()
                .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2))
                .get();

        System.out.println("highestCalorieDish : " +highestCalorieDish);


        Integer maxOfCalorie = menu
                .stream()
                .map(Dish::getCalories)
                .reduce(Integer::max)
                .get();
        System.out.println("maxOfCalorie : "+ maxOfCalorie);

        menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType))
                .entrySet()
                .forEach(System.out::println);

        Map<Dish.Type, List<Dish>> dishesByType1 =
                menu
                .stream()
                .collect(groupingBy(Dish::getType));

        System.out.println(dishesByType1);


        Map<Dish.Type, List<Dish>> dishesByType2 =
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType2);

        Map<Dish.Type, List<Dish>> dishesByTypeAndCalorie = menu
                .stream()
                .collect(groupingBy(Dish::getType, filtering(dish1 -> dish1.getCalories() > 500, toList())));

        System.out.println(dishesByTypeAndCalorie);


        Map<Dish.Type, List<String>> dishesTypeAndNames = menu
                .stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        System.out.println(dishesTypeAndNames);



    }
}
