package com.bocsh.Robot.components;

import org.springframework.stereotype.Component;

@Component
public class Position {
    private int xPosition;
    private int yPosition;

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void decreaseX() {
        this.xPosition--;
    }

    public void decreaseY() {
        this.yPosition--;
    }

    public void increaseX() {
        this.xPosition++;
    }

    public void increaseY() {
        this.yPosition++;
    }
}
