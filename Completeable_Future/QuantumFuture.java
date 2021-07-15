package Completeable_Future;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class QuantumFuture {
    public static String deepThought() {
        try {
            sleep(3000);
        } catch (Exception e) {
            System.out.println("Quantum realm didnt go");
        }
        return "Changing the past doesn't change the future!";

    }
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(()-> {
            return deepThought();
                }
        ).thenApply(answer->answer + " Or does it?")
                .thenAccept(answer->System.out.println(answer));
        System.out.println("I am changing the past.");
        try {
            sleep(4000);
        } catch (Exception e) {
            System.out.println("Failed to sleep");
        }
    }
}
