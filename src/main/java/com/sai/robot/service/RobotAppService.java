package com.sai.robot.service;

import com.sai.robot.component.Direction;
import com.sai.robot.component.Robot;
import com.sai.robot.component.Table;

import java.util.Scanner;

public class RobotAppService {

    final Table table;
    final Robot robot;
    final Scanner scanner;

    public RobotAppService(){
        this.table = new Table();
        this.robot = new Robot(this.table);
        this.scanner = new Scanner(System.in);

    }

    public void start(){

        System.out.println("Toy Robot Simulator");
        System.out.println("Commands: PLACE X,Y,F | MOVE | LEFT | RIGHT | REPORT | EXIT");
        System.out.println("Example: PLACE 0,0,NORTH");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("EXIT")) {
                break;
            }

            if (input.startsWith("PLACE")) {
                handlePlaceCommand(this.robot, input);
            } else if (input.equals("MOVE")) {
                this.robot.move();
            } else if (input.equals("LEFT")) {
                this.robot.left();
            } else if (input.equals("RIGHT")) {
                this.robot.right();
            } else if (input.equals("REPORT")) {
                System.out.println(this.robot.report());
            } else {
                System.out.println("Invalid command");
            }
        }

        scanner.close();
    }


    private void handlePlaceCommand(Robot robot, String input) {
        try {
            String[] parts = input.split(" ");
            if (parts.length < 2) {
                System.out.println("Invalid PLACE command format");
                return;
            }

            String[] params = parts[1].split(",");
            if (params.length != 3) {
                System.out.println("Invalid PLACE command format");
                return;
            }

            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            Direction facing = Direction.valueOf(params[2]);

            robot.place(x, y, facing);
        } catch (NumberFormatException e) {
            System.out.println("Invalid coordinates");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid direction. Use NORTH, EAST, SOUTH, or WEST");
        }
    }

}
