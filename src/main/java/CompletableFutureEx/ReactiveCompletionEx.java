package CompletableFutureEx;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReactiveCompletionEx {


    ExecutorService service= Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        Integer n=new Integer("123");
        System.out.println(n);

    }

}
