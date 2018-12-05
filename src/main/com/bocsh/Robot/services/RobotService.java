package com.bocsh.Robot.services;

import com.bocsh.Robot.components.Position;
import com.bocsh.Robot.models.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RobotService {

    enum Directions {
        N(1, "North"),
        E(2, "East"),
        S(3, "South"),
        W(4, "West");

        private int direction;
        private String name;

        Directions(int direction, String name) {
            this.direction = direction;
            this.name = name;
        }

        public int getDirection() {
            return this.direction;
        }

        public String getName() {
            return name;
        }

        public Directions getByValue(int id) {
            for (Directions value : Directions.values()) {
                if (value.getDirection() == id) {
                    return value;
                }
            }
            return null;
        }
    }

    private Directions faceDirection = Directions.N;
    @Autowired
    private Position position;

    public void prepareRobot(char direction, String positions) {
        String[] pos = positions.split(",");
        int xCoordinate = Integer.valueOf(pos[0]);
        int yCoordinate = Integer.valueOf(pos[1]);

        this.position.setxPosition(xCoordinate);
        this.position.setyPosition(yCoordinate);

        setFaceDirection(getDirection(direction));
    }

    private Directions getDirection(char direction) {
        switch (direction) {
            case 'N':
            case 'n':
                return Directions.N;
            case 'E':
            case 'e':
                return Directions.E;
            case 'S':
            case 's':
                return Directions.S;
            case 'W':
            case 'w':
                return Directions.W;
            default:
                return null;
        }
    }

    public Directions getFaceDirection() {
        return faceDirection;
    }

    public void setFaceDirection(Directions faceDirection) {
        this.faceDirection = faceDirection;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(String moveCommand) {
        char[] moves = moveCommand.toLowerCase().toCharArray();

        for (char step : moves) {
            processStep(step);
        }
    }

    public void turnLeft() {
        faceDirection = faceDirection.getDirection() == 1 ? Directions.W : faceDirection.getByValue(faceDirection.getDirection() - 1);
    }

    public void turnRight() {
        faceDirection = faceDirection.getDirection() == 4 ? Directions.N : faceDirection.getByValue(faceDirection.getDirection() + 1);
    }

    private void processStep(char step) {
        switch (step) {
            case 'r':
                turnRight();
                break;
            case 'l':
                turnLeft();
                break;
            case 'a':
                advance();
                break;
            default:
                System.out.println("Wrong command");
                break;
        }
    }

    public void advance() {
        switch (faceDirection) {
            case N:
                position.increaseY();
                break;
            case E:
                position.increaseX();
                break;
            case S:
                position.decreaseY();
                break;
            case W:
                position.decreaseX();
                break;
            default:
                System.out.println("Robot is dead, not faced to any direction!");
        }
    }

    public Robot getRobot() {
        System.out.println("Face Direction " + faceDirection.getName());
        System.out.println("Position  " + getPosition().getxPosition() + ", " + getPosition().getyPosition());
        return new Robot(faceDirection.getName(), getPosition());
    }
}
