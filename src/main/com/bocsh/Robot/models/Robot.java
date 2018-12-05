package com.bocsh.Robot.models;

import com.bocsh.Robot.components.Position;

public class Robot {

    private String faceDirection = "North";
    private Position location = null;

    public Robot(String faceDirection, Position location) {
        this.faceDirection = faceDirection;
        this.location = location;
    }

    public String getFaceDirection() {
        return faceDirection;
    }

    public void setFaceDirection(String faceDirection) {
        this.faceDirection = faceDirection;
    }

    public Position getLocation() {
        return location;
    }
}
