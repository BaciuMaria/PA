package org.example;
import java.util.Random;
import java.util.Stack;

public class Robot implements Runnable {
    private String name;
    private int nrTokens;
    private boolean running;
    Exploration explore;
    private Random rand = new Random();
    private boolean paused;
    public Robot(String name) {
        this.name = name;
        this.nrTokens=0;
    }
    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public String getName() {
        return name;
    }

    public void pause() {
        this.paused = true;this.running = true;
    }

    public void start() {
        this.paused = false;
        this.running = true;
    }
    public void stop() {
        this.running = false;
        this.paused=false;
    }
    public int getNrToken() {
        return nrTokens;
    }
    @Override
    public void run() {
        this.paused = false;
        this.running = true;
        while (running) {
            while (paused) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            if(explore.getMap().werewAllCellsVisited()){
                running = false;
                System.out.println("The robot " + name + " has placed " + nrTokens + " tokens.");
                break;
            }
            int row = rand.nextInt(explore.getMap().getSize());
            int col = rand.nextInt(explore.getMap().getSize());

            while (explore.getMap().isVisited(row, col)) {
                row = rand.nextInt(explore.getMap().getSize());
                col = rand.nextInt(explore.getMap().getSize());
            }
            explore.getMap().visit(row, col, this);
            nrTokens = nrTokens + explore.size;
            try {
                Thread.sleep(rand.nextInt(5000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
