package com.sai.robot;

import com.sai.robot.service.RobotAppService;

public class Main {

    public static void main(String[] args){

        final var service = new RobotAppService();
        service.start();

    }
}
