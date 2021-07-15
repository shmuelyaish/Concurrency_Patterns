import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkPool extends RecursiveTask<Integer> {
    private int num;
    public ForkPool(int num) {
        this.num = num;
    }
    @Override
    protected Integer compute() {
        System.out.println(this.num);
        if(num < 1) {
            return num;
        }
        ForkPool f1 = new ForkPool(num-1);
        //puts compute for f1 in queue
        f1.fork();
        return new ForkPool(num - 1).compute() + f1.join();
    }
    public static void main(String[] args){
        ForkPool f = new ForkPool(10);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("Done"+ pool.invoke(f));
    }
}
