package BiFunctionExamples;

import java.util.function.BiFunction;

public class TestBiFunction {
    public static void main(String[] args) {


        BiFunction<Integer, Integer, String> biFunction = (num1, num2) -> "Result>>>>>" + num1 + num2;
        String result = biFunction.apply(10, 5);
        System.out.println(result);
    }
}
