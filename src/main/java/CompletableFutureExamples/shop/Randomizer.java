package CompletableFutureExamples.shop;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    public static int random(int size) {
        return ThreadLocalRandom.current().nextInt(size);
    }
}