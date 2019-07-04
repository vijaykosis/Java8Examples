package FunctionalInterfaceExamples;

import java.util.function.Predicate;

public class TestFunctionalInterfaceEx {

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        Converter<String, String> stringConverter = new Something()::startsWith;
        System.out.println(stringConverter.convert("Java"));

        int num = 1;
        Converter<Integer, String> converter1 =
                (from) -> String.valueOf(from + num);

        Predicate<String> predicate = (s) -> s.length() > 0;

        System.out.println(predicate.test("Vija"));

    }
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}