package Callable_Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {
    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(2);
        Future<String> f = execute.submit(new MyCallable());
        System.out.println("1");
        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("ERROR 2");
        }
        System.out.println("2");
        execute.shutdown();
    }
}
