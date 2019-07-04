package functionsExamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TestFunctionsEx {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);


        Function<Integer, Double> half = a -> Math.sqrt(a);

        System.out.println(half.apply(2));

        Converter<String, Double> converter = Double::parseDouble;
        Double d = converter.convert("12.90");
        System.out.println(d);
    }
}

interface Converter<F, T> {
    T convert(F from);
}