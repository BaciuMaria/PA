package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exploration {
    int size;
    private final SharedMemory mem;
    private final ExplorationMap map;
    private final List<Robot> robots = new ArrayList<>();
    private static boolean running ;

    public Exploration(int size) {
        this.size = size;
        this.mem = new SharedMemory(size);
        this.map = new ExplorationMap(size, mem);
    }
    public void addRobot(Robot robot) {
        robot.setExplore(this);
        robots.add(robot);
    }
    public void start() {
        for (Robot robot : robots) {
            Thread t = new Thread(robot);
            t.start();
        }
    }
    public void pauseRobot(String robotName) {
        for (Robot robot : robots) {
            if(robot.getName()==robotName)
            robot.pause();
        }
    }
    public void pauseAllRobots() {
        for (Robot robot : robots) {
            robot.pause();
        }
    }
    public void startRobot(String robotName) {
        for (Robot robot : robots) {
            if(robot.getName()==robotName)
                robot.start();
        }
    }
    public void startAllRobots() {
        for (Robot robot : robots) {
            robot.start();
        }
    }
    public void stop() {
        running = false;
        for (Robot robot : robots) {
            robot.stop();
        }
    }
    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }
    public static void main(String args[]) {
        if (args.length < 1) {
            System.err.println("Not enough arguments!");
            System.exit(1);
        }
        int matrixSize = Integer.parseInt(args[0]);
        var explore = new Exploration(matrixSize);
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));

        TimeKeeper timekeeper = new TimeKeeper(60000,explore);
        Thread timekeeperThread = new Thread(timekeeper);
        timekeeperThread.setDaemon(true);
        timekeeperThread.start();

        Scanner scanner = new Scanner(System.in);
        running = true;
        explore.start();
        while (running) {
            String command = scanner.nextLine();

            switch (command) {
                case "pause":
                    System.out.print("Enter a robot name to pause.");
                    String robotName = scanner.nextLine();

                    if (robotName.equalsIgnoreCase("all")) {
                        explore.pauseAllRobots();
                    } else {
                        explore.pauseRobot(robotName);
                    }

                    break;

                case "start":
                    System.out.print("Enter a robot name to start.");
                    robotName = scanner.nextLine();

                    if (robotName.equalsIgnoreCase("all")) {
                        explore.startAllRobots();
                    } else {
                        explore.startRobot(robotName);
                    }

                    break;

                case "exit":
                    explore.stop();
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }
        scanner.close();
    }
}