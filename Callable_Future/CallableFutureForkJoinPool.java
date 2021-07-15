package Callable_Future;

import java.util.concurrent.*;

public class CallableFutureForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Future<String> f = pool.submit(new MyCallable());
        Future<String> g = pool.submit(()->{
            for(int i = 0; i <12; i++)
                System.out.println("hi");
            return "boogey";
        });
        System.out.println("1");
        try {
            System.out.println(f.get());
            System.out.println(g.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("ERROR 2");
        }
        System.out.println("2");
        pool.shutdown();
    }
}
