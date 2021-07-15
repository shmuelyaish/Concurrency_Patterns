package Thread_Scheduling;

import java.io.IOException;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class PeteAndRepeat {
    private static class Riddle extends TimerTask {
        @Override
        public void run() {
            System.out.println("Pete and Repeat were on a boat, pete fell out, whos left?");
        }
    }
    private static class Answer extends TimerTask {

        @Override
        public void run() {
            System.out.println("Repeat.");
        }
    }
    public static void main(String[] args) {
        Riddle r = new Riddle();
        Answer a = new Answer();
        Timer t = new Timer();
        t.scheduleAtFixedRate(r, 0, 2300);
        t.scheduleAtFixedRate(a, 1600, 2300);
        /*
            r.cancel();
            a.cancel();
            t.cancel();
        */

    }
}
