package com.sai.robot.component;

public class Table {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
    }

}
