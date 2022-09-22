package com.vinilemess.marsrover;

public class MarsRover {

    private CardinalPoint direction;
    private int coordinateX;
    private int coordinateY;

    public MarsRover() {
        direction = CardinalPoint.NORTH;
        coordinateX = 0;
        coordinateY = 0;
    }

    public String executeCommand(String command) {
        for (char character : command.toCharArray()) {
           moveRover(character);
        }
        return printCurrentPosition();
    }

    private void moveRover(char character) {
        if (character == "M".charAt(0)) switch (this.direction.getCardinalDirection()) {
            case "S" -> moveSouth();
            case "N" -> moveNorth();
            case "E" -> moveEast();
            case "W" -> moveWest();
        } else if (character == "R".charAt(0)) {
            turnRight();
        } else if (character == "L".charAt(0)) {
            turnLeft();
        }
    }

    private void moveNorth() {
        if (coordinateY + 1 > 9) {
            invertDirection();
            return;
        }
        coordinateY++;
    }

    private void moveSouth() {
        if (coordinateY - 1 < 0) {
            invertDirection();
            return;
        }
        coordinateY--;
    }

    private void moveEast() {
        if (coordinateX + 1 > 9) {
            invertDirection();
            return;
        }
        coordinateX++;
    }

    private void moveWest() {
        if (coordinateX - 1 < 0) {
            invertDirection();
            return;
        }
        coordinateX--;
    }

    private void turnLeft() {
        switch (this.direction.getCardinalDirection()) {
            case "N" -> this.direction = CardinalPoint.WEST;
            case "W" -> this.direction = CardinalPoint.SOUTH;
            case "S" -> this.direction = CardinalPoint.EAST;
            case "E" -> this.direction = CardinalPoint.NORTH;
        }
    }

    private void turnRight() {
        switch (this.direction.getCardinalDirection()) {
            case "N" -> this.direction = CardinalPoint.EAST;
            case "E" -> this.direction = CardinalPoint.SOUTH;
            case "S" -> this.direction = CardinalPoint.WEST;
            case "W" -> this.direction = CardinalPoint.NORTH;
        }
    }

    private void invertDirection() {
        switch (this.direction.getCardinalDirection()) {
            case "N" -> this.direction = CardinalPoint.SOUTH;
            case "E" -> this.direction = CardinalPoint.WEST;
            case "S" -> this.direction = CardinalPoint.NORTH;
            case "W" -> this.direction = CardinalPoint.EAST;
        }
    }

    public String printCurrentPosition() {
        return "%d:%d:%s".formatted(coordinateX, coordinateY, direction.getCardinalDirection());
    }
}


