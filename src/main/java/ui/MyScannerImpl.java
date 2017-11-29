package ui;

import java.util.Scanner;

public class MyScannerImpl implements MyScanner {

    private final Scanner scanner;

    public MyScannerImpl(){
        scanner = new Scanner(System.in, "UTF-8");
    }

    @Override
    public String nextLine() {
        String nextLine = scanner.nextLine();
        exit(nextLine);
        return nextLine;
    }

    private void exit(String nextLine) {
        if(nextLine.equals("exit")) System.exit(0);
    }

}