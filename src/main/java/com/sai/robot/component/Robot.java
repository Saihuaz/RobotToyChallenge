package com.sai.robot.component;

public class Robot {
    private int x;
    private int y;
    private Direction facing;
    private final Table table;
    private boolean placed;

    public Robot(Table table) {
        this.table = table;
        this.placed = false;
    }

    public void place(int x, int y, Direction facing) {
        if (table.isValidPosition(x, y)) {
            this.x = x;
            this.y = y;
            this.facing = facing;
            this.placed = true;
        }
    }

    public void move() {
        if (!placed) return;

        int newX = x;
        int newY = y;

        switch (facing) {
            case NORTH -> newY++;
            case EAST -> newX++;
            case SOUTH -> newY--;
            case WEST -> newX--;
        }

        if (table.isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
        } else {
            System.out.println("Unable to move to new position, as it is invalid.");
        }
    }

    public void left() {
        if (placed) {
            facing = facing.left();
        }
    }

    public void right() {
        if (placed) {
            facing = facing.right();
        }
    }

    public String report() {
        if (!placed) {
            return "Robot not placed on table";
        }
        return x + "," + y + "," + facing;
    }

    public boolean isPlaced() {
        return placed;
    }

}
