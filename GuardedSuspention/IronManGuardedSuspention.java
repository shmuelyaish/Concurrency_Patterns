package GuardedSuspention;

public class IronManGuardedSuspention {
    private boolean winner;
    private int score;
    public IronManGuardedSuspention() {
        this.winner = false;
        this.score = 0;
    }
    synchronized public void announceWon() {
        System.out.println("thanos has gontlet");
        while (winner == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("And I, am Iron Man");
    }
    synchronized public void addStone() {
        this.score++;
        System.out.println("I am, inevitable!");
        if(this.score > 10) {
            this.winner = true;
        }
        notify();
    }
    public static void main(String[] args) {
        IronManGuardedSuspention thanos = new IronManGuardedSuspention();
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                thanos.announceWon();
            }
        });
        th.start();
        for(int i = 0; i<12; i++) {
            thanos.addStone();
        }

    }
}
