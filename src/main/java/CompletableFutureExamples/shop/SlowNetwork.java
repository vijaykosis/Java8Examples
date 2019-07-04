package CompletableFutureExamples.shop;

import java.util.concurrent.TimeUnit;

public class SlowNetwork {
    public static void delay(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}