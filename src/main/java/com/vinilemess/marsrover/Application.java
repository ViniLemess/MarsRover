package com.vinilemess.marsrover;

import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MarsRover marsRover = new MarsRover();

        while (true) {
            System.out.println("Command the Mars Rover: (type Q to finish the program)");
            String command = scanner.next().toUpperCase();
            if (command.equals("Q")) break;
            try {
                System.out.println(marsRover.executeCommand(command));
            } catch (IllegalArgumentException exception) {
                System.err.println(exception.getMessage());
            }

        }
        System.out.println("Program finished");
    }
}
