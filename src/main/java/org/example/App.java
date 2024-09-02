package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int gameOn = 0;
        int menuSelected = 0;
        while (gameOn == 0) {
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
            menuSelected = scanner.nextInt();

//
//            else if (scanner.nextLine().equalsIgnoreCase("e")) {
//                menuSelected = 5;
//            }
            switch (menuSelected) {
                case 1:
                    System.out.println("Inmatning");
                    break;
                case 2:
                    System.out.println("Min, Max och Medel");
                    break;
                case 3:
                    System.out.println("Sortera");
                    break;
                case 4:
                    System.out.println("Bästa Laddningstid (4h) ");
                    break;
                case 5:
                    gameOn = 1;
                    break;
            }
        }
    }
}
