package org.example;

import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    int size;
    private SharedMemory mem;
    public int visitedCells;

    public ExplorationMap(int size, SharedMemory mem) {
        this.size=size;
        matrix = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = new Cell();
            }
        }
        this.mem= mem;
        this.visitedCells = 0;
    }
    public int getSize(){
        return size;
    }
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].getNrList().isEmpty()) {
                List<Token> tokens = mem.extractTokens(size);
                matrix[row][col].setNrList(tokens);
                System.out.println("Robot " + robot.getName() + " successfully visited cell (" + row + ", " + col + ")");
                visitedCells++;
                return true;
            } else {
                System.out.println("Cell (" + row + ", " + col + ") has already been visited");
                return false;
            }
        }
    }
    public boolean isVisited(int row, int col) {
        synchronized (matrix[row][col]) {
            return !matrix[row][col].getNrList().isEmpty();
        }
    }
    public boolean werewAllCellsVisited(){
        return visitedCells == size * size;
    }
    public synchronized int getVisitedCellsCount() {
        return visitedCells;
    }
    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}