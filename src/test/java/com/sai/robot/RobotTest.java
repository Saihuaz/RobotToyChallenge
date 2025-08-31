package com.sai.robot;

import com.sai.robot.component.Direction;
import com.sai.robot.component.Robot;
import com.sai.robot.component.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    private Robot robot;
    private Table table;

    @BeforeEach
    void setUp() {
        table = new Table();
        robot = new Robot(table);
    }

    @Test
    void testPlaceValid() {
        robot.place(0, 0, Direction.NORTH);
        assertTrue(robot.isPlaced());
        assertEquals("0,0,NORTH", robot.report());
    }

    @Test
    void testPlaceInvalid() {
        robot.place(-1, 0, Direction.NORTH);
        assertFalse(robot.isPlaced());
    }

    @Test
    void testMoveNorth() {
        robot.place(0, 0, Direction.NORTH);
        robot.move();
        assertEquals("0,1,NORTH", robot.report());
    }

    @Test
    void testMoveEast() {
        robot.place(0, 0, Direction.EAST);
        robot.move();
        assertEquals("1,0,EAST", robot.report());
    }

    @Test
    void testMoveToEdge() {
        robot.place(0, 0, Direction.SOUTH);
        robot.move(); // Should not move
        assertEquals("0,0,SOUTH", robot.report());
    }

    @Test
    void testLeftTurn() {
        robot.place(0, 0, Direction.NORTH);
        robot.left();
        assertEquals("0,0,WEST", robot.report());
    }

    @Test
    void testRightTurn() {
        robot.place(0, 0, Direction.NORTH);
        robot.right();
        assertEquals("0,0,EAST", robot.report());
    }

    @Test
    void testFullRotation() {
        robot.place(0, 0, Direction.NORTH);
        robot.right();
        robot.right();
        robot.right();
        robot.right();
        assertEquals("0,0,NORTH", robot.report());
    }

}
