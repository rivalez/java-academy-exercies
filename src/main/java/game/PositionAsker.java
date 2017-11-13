package game;

import java.util.Scanner;

public class PositionAsker {

    public int askForPosition(){
        Scanner scanner = new Scanner(System.in);
        new Communicate("please type number in which you want to place your symbol ").getMessage();
        return scanner.nextInt();
    }
}
