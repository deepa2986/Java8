package modernjava.foodstore;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DishMainWithStreamSlicing {

    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120,  Dish.Type.OTHER),
                new Dish("Mutton", false, 600,  Dish.Type.MEAT),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("pork", false, 500, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER));

        System.out.println("----------------------take while--------------");
      //  List<Dish> specialMenuWithLessCalories =
                specialMenu
                .stream()
                .takeWhile(dish -> dish.getCalories() < 320)
               // .map(Dish::getName)
               // .collect(Collectors.toList());
                       .forEach(System.out::println);
   //     System.out.println(specialMenuWithLessCalories);
        System.out.println("------------------drop while----------------");
        specialMenu
                .stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .forEach(System.out::println);

        System.out.println("-------------limit-------------------");
        specialMenu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("------------------skip----------------");
        specialMenu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .forEach(System.out::println);

        System.out.println("---------------limit------------------");

        specialMenu
                .stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .forEach(System.out::println);

        Integer maxCalorie = specialMenu
                .stream()
                .map(Dish::getCalories)
                .reduce(Integer::max)
                .get();

        System.out.println(maxCalorie);


        Integer minCalorie = specialMenu
                .stream()
                .map(Dish::getCalories)
                .reduce(Integer::min)
                .get();
        System.out.println(minCalorie);

        long count = specialMenu
                .stream()
                .count();
        System.out.println(count);

    }
}
