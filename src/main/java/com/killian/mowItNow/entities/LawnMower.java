package com.killian.mowItNow.entities;

public class LawnMower {
    Position position;
    String instructions;

    public LawnMower(Position position, String instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    public void move(int maxX, int maxY) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    turnLeft();
                    break;
                case 'D':
                    turnRight();
                    break;
                case 'A':
                    moveForward(maxX, maxY);
                    break;
                default:
                    break;
            }
        }
    }

    private void turnLeft() {
        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation('W');
                break;
            case 'W':
                position.setOrientation('S');;
                break;
            case 'S':
                position.setOrientation('E');
                break;
            case 'E':
                position.setOrientation('N');
                break;
        }
    }

    private void turnRight() {
        switch (position.getOrientation()) {
            case 'N':
                position.setOrientation('E');
                break;
            case 'E':
                position.setOrientation('S');
                break;
            case 'S':
                position.setOrientation('W');
                break;
            case 'W':
                position.setOrientation('N');
                break;
        }
    }

    private void moveForward(int maxX, int maxY) {
        switch (position.getOrientation()) {
            case 'N':
                if (position.getY() < maxY) {
                    position.setY(position.getY() + 1);
                }
                break;
            case 'E':
                if (position.getX() < maxX) {
                    position.setX(position.getX() + 1);
                }
                break;
            case 'S':
                if (position.getY() > 0) {
                    position.setY(position.getY() - 1);
                }
                break;
            case 'W':
                if (position.getX() > 0) {
                    position.setX(position.getX() - 1);
                }
                break;
        }
    }

    public String toString() {
        return position.getX() + " " + position.getY() + " " + position.getOrientation();
    }
}