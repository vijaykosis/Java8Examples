package CompletableFutureExamples;

import CompletableFutureExamples.shop.Discount;
import CompletableFutureExamples.shop.PriceRecord;
import CompletableFutureExamples.shop.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.stream.Collectors.toList;

public class CompletableFutureApplication {

    public static int THREAD_POOL_SIZE = 100;

    public static List<Shop> shops = Arrays.asList(
            new Shop("Shop A"),
            new Shop("Shop B"),
            new Shop("Shop C"),
            new Shop("Shop D"),
            new Shop("Shop E"),
            new Shop("Shop F"),
            new Shop("Shop G"),
            new Shop("Shop J"),
            new Shop("Shop K")
    );


    public static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE, r ->

    {
        Thread t = new Thread(r);
        t.setName("ExecutorThread");
        t.setDaemon(true);
        return t;
    });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.nanoTime();
        findPricesCustomExecutorWithListener();
        long duration = milliseconds(start);
        System.out.println("Done in " + duration + " msec");
    }

    private static void findPricesCustomExecutorWithListener() {
        List<CompletableFuture<PriceRecord>> futures =
                shops.stream()
                        .map(s -> CompletableFuture.supplyAsync(s::getPrice, executorService))
                        .map(f -> f.thenCompose(p -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(p), executorService)))
                        .collect(toList());

        CompletableFuture[] all = futures.stream()
                .map(f -> f.thenAccept(System.out::println))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(all).join();
    }

    private static long milliseconds(long start) {
        return (System.nanoTime() - start) / 1_000_000;
    }

}
