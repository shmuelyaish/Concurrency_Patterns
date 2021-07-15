package Callable_Future;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        try {
            sleep(2000);
        } catch(Exception e) {
            System.out.println("error");
        }
        return "Hello";
    }
}
