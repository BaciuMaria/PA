package org.example;

public class TimeKeeper implements Runnable {
    private int timeLimit;
    Exploration explore;
    private boolean running;

    public TimeKeeper(int timeLimit, Exploration explore){
        this.timeLimit = timeLimit;
        this.running=true;
        this.explore = explore;
    }
    public void stop() {
        this.running = false;
    }
    public void run() {
        long startTime = System.currentTimeMillis();
        while (running) {
            if (explore.getMap().werewAllCellsVisited()) {
                running = false;
                System.out.println("Exploration finished.");
                break;
            }
            long Time = System.currentTimeMillis() - startTime;
            System.out.println("Time: " + Time / 1000 + " seconds");
            if (Time >= timeLimit) {
                System.out.println("Time limit exceeded.");
                explore.stop();
                System.exit(0);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}