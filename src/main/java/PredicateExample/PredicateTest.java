package PredicateExample;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {


    public static Predicate<Apple> isWeightAbove150() {
        return apple -> apple.getWeight() <= 150;
    }

    public static Predicate<Apple> isColorGreen() {
        return apple -> !apple.getColor().equals("green");
    }

    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate) {
        return apples.stream().filter(predicate).collect(Collectors.toList());
    }

    public static Predicate<Apple> andPredicate = isColorGreen().and(isWeightAbove150());

    public static void main(String[] args) {

        List<Apple> apples = Arrays.asList(new Apple("green", 120.0), new Apple("red", 110.0), new Apple("brown", 150.0), new Apple("green", 160.0), new Apple("red", 122.0));
        PredicateTest.filterApples(apples, isWeightAbove150()).forEach(System.out::println);

        System.out.println("<<<<<<<<<<<<<<<<<<Predicate for green>>>>>>>>>>>>>>");
        filterApples(apples, isColorGreen()).forEach(System.out::println);
        System.out.println("<<<<<<<<<<<<<<<<<<Join Predicate >>>>>>>>>>>>>>");
        filterApples(apples, andPredicate).forEach(System.out::println);
        System.out.println();

        System.out.println("<<<<<<<<<<<<<<<<<< negateExample Predicate >>>>>>>>>>>>>>");
        filterApples(apples, negateExample).forEach(x -> {
            System.out.println(x.getColor());

        });

        System.out.println("<<<<<<<<<<<<<<<<<< boolean test Predicate >>>>>>>>>>>>>>");
        Apple testApple = new Apple("green", 120.0);
        System.out.println(isColorGreen().test(testApple));
        System.out.println(isWeightAbove150().test(testApple));

    }

    public static Predicate<Apple> negateExample = PredicateTest.isColorGreen().negate();

}