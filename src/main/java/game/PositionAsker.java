package game;

import UI.Communicate;

import java.util.Scanner;

public class PositionAsker {

    public int askForPosition(){
        Scanner scanner = new Scanner(System.in);
        new Communicate("please type number in which you want to place your symbol ").getMessage();
        int i = 0;
        try {
            i = scanner.nextInt();
        } catch (Exception e){
            new Communicate("Something Went wrong try again...").getMessage();
            askForPosition();
        }
        return i;
    }
}
