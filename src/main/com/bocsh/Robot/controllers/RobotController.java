package com.bocsh.Robot.controllers;

import com.bocsh.Robot.models.Robot;
import com.bocsh.Robot.services.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController {

    @Autowired
    RobotService service;

    @RequestMapping(value = "/robotMove" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Robot robotMove(@RequestParam(value="faceDirection", defaultValue="North") char direction,
                           @RequestParam(value="position", defaultValue = "0,0") String position,
                           @RequestParam(value = "command") String command) {

        System.out.println("Service " + service);
        service.prepareRobot(direction, position);
        service.move(command);
        return service.getRobot();
    }
}
