package SupplierExamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {
    static int count = 0;

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Harry", "Daniel", "Lucifer", "Jenifer");
        names.stream().forEach(x -> {
            System.out.println(printNames(() -> x));
        });
    }

    private static String printNames(Supplier<String> s) {

        return s.get() + count++;
    }
}
