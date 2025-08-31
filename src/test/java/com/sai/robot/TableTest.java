package com.sai.robot;

import com.sai.robot.component.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableTest {

    @Test
    void testValidPositions() {
        Table table = new Table();
        assertTrue(table.isValidPosition(0, 0));
        assertTrue(table.isValidPosition(4, 4));
        assertTrue(table.isValidPosition(2, 3));
    }

    @Test
    void testInvalidPositions() {
        Table table = new Table();
        assertFalse(table.isValidPosition(-1, 0));
        assertFalse(table.isValidPosition(0, -1));
        assertFalse(table.isValidPosition(5, 0));
        assertFalse(table.isValidPosition(0, 5));
    }

}
