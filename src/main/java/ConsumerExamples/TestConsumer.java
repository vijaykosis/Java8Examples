package ConsumerExamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumer {
    public static void main(String[] args) {

        SimpleConsumerExample simpleConsumerExample = new SimpleConsumerExample();
        simpleConsumerExample.accept(new Long(5));


        Consumer<String> stringConsumer = (s) -> System.out.println(s + " word");
        stringConsumer.accept("Hello");
        ConsumerCodeEx();

    }


    private static void ConsumerCodeEx() {
        Consumer<Integer> consumer = i -> System.out.println(" " + i+">>");
        Consumer<Integer> consumerWithAndThen = consumer.andThen(i -> System.out.println("(printed " + i + ")"));

        List<Integer> integerList = Arrays.asList(new Integer(1),
                new Integer(10), new Integer(200),
                new Integer(101), new Integer(-10),
                new Integer(0));
        printList(integerList, consumerWithAndThen);
    }

    public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
        for (Integer integer : listOfIntegers) {
            consumer.accept(integer);
        }
    }

}



class SimpleConsumerExample implements Consumer<Long> {

    @Override
    public void accept(Long o) {

        System.out.println(o * o);
    }
}