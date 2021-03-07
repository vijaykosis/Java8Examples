package BiConsumerExamples;

import java.util.function.BiConsumer;

public class BiConsumerDemoEx1 {
    public static void main(String[] args) {
        BiConsumer<Integer,Integer> operation=(a,b)-> System.out.println(a+b);
        operation.accept(10,20);

    }
}
