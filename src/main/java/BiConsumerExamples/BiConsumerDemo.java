package BiConsumerExamples;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<Integer, String> biConsumer = (x, y) -> System.out.println("Key::" + x + " Val:" + y);
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        map.forEach(biConsumer);

    }
}
