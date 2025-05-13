package se.mojujo.projektarbete.game;

import java.util.Scanner;

public class TerminalInputProvider implements InputProvider {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}
