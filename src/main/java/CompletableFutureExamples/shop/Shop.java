package CompletableFutureExamples.shop;


import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {

    private String name;


    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Future<BigDecimal> getPriceAsync() {
        CompletableFuture<BigDecimal> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                BigDecimal price = calculatePrice();
                future.complete(price);
            } catch (Exception e) {
                future.completeExceptionally(e);
            }
        }).start();
        return future;
    }

    public BigDecimal getPrice() {
        return calculatePrice();
    }

    public BigDecimal calculatePrice() {
        SlowNetwork.delay(1);
        return BigDecimal.valueOf(Randomizer.random(1000));
    }

}