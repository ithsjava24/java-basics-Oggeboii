package org.example;

import java.nio.channels.ScatteringByteChannel;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        boolean gameOn = true;
        String menuSelected;
        while (gameOn) {
            String[] menu = {
                    "Elpriser\n",
                    "========\n",
                    "1. Inmatning\n",
                    "2. Min, Max och Medel\n",
                    "3. Sortera\n",
                    "4. Bästa Laddningstid (4h)\n",
                    "e. Avsluta\n"};
            for (String menuOption : menu) {
                System.out.print(menuOption);
            }
            Scanner scanner = new Scanner(System.in);
            menuSelected = scanner.nextLine();

            switch (menuSelected) {
                case "1":
                    Inmatning();
                    break;
                case "2":
                    System.out.println("Min, Max och Medel");
                    break;
                case "3":
                    System.out.println("Sortera");
                    break;
                case "4":
                    System.out.println("Bästa Laddningstid (4h) ");
                    break;
                case "e", "E":
                    gameOn = false;
                    break;
            }
        }
    }
    public static void Inmatning(){
        Random rand = new Random();
    int[] anArray = new int[24];
    for (int i = 0; i < 9; i++) {
        anArray[i] = rand.nextInt(1,600); ;
        System.out.println("0" + i + "-" + "0" + (i+1) + "-" + anArray[i]);

    }
    System.out.println("09" + ":" + "10");
    for (int i = 10; i < 19; i++) {
        anArray[i] = rand.nextInt(1,600);
        System.out.println(i + "-" + (i+1) + ":" + anArray[i]);
    }
    System.out.println("19" + "-" + "20");
    for (int i = 20; i < 24; i++) {
        anArray[i] = rand.nextInt(1,600);
        System.out.println(i + "-" + (i+1) + ":" + anArray[i]);
    }

    }
}
