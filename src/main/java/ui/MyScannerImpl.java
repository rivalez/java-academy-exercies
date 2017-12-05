package ui;

import java.util.Scanner;

public class MyScannerImpl implements MyScanner {

    private static final String UTF_8 = "UTF-8";
    private static final String EXIT = "exit";
    private final Scanner scanner;

    public MyScannerImpl(){
        scanner = new Scanner(System.in, UTF_8);
    }

    @Override
    public String nextLine() {
        String nextLine = scanner.nextLine();
        exit(nextLine);
        return nextLine;
    }

    private void exit(String nextLine) {
        if(nextLine.equals(EXIT)) System.exit(0);
    }

}