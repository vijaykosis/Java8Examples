package BiPredicateExamples;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
    public static void main(String[] args) {

        BiPredicate<String, String> biPredicate = (x, y) -> x.startsWith("j") && x.endsWith("a");
        System.out.println(biPredicate.test("java", ""));
        BiPredicate<Integer, String> biPredicate1 = (x, y) -> x % 2 != 0 && y.startsWith("j");
        System.out.println(biPredicate1.test(10, "java"));
    }
}
