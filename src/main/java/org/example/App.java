package org.example;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    static int[] inData = new int[24];


        public static void main (String[]args){
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
                        minMaxMiddle();
                        break;
                    case "3":
                        System.out.print("Sortera\n");
                        break;
                    case "4":
                        System.out.print("Bästa Laddningstid (4h)\n");
                        break;
                    case "e", "E":
                        gameOn = false;
                        break;
                }
            }
        }

        public static void Inmatning() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Skriv in öre/kWh tack:\n");
            for (int i = 0; i < inData.length; i++) {
                    try {
                        inData[i] = Integer.parseInt(scanner.nextLine());

                    } catch (NumberFormatException e) {
                        System.out.print("Skriv in öre/kWh tack: \n");
                    }

            }
        }

        public static void minMaxMiddle() {
            int[] minMaxValueArray = inData;
            int sum = 0;
            float middle =0f;
            int maxValue = 0;
            int maxValuePosition = 0;
            int minValuePosition = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i <minMaxValueArray.length; i++) {
                if (minMaxValueArray[i] > maxValue) {
                    maxValue = minMaxValueArray[i];
                    maxValuePosition = i;
                }
                if (minMaxValueArray[i] < minValue) {
                    minValue = minMaxValueArray[i];
                    minValuePosition = i;
                }
                sum = minMaxValueArray[i] + sum;
            }
            middle = ((float) sum /minMaxValueArray.length);
            System.out.print("Lägsta pris: ");
            if (minValuePosition < 9){
                System.out.print("Lägsta pris: " + "0" + minValuePosition + "-" + "0" + (minValuePosition + 1)  + ", " + minValue + " öre/kWh\n");
            }
            else if (minValuePosition ==9 ){
                System.out.print("Lägsta pris: " + "0" + minValuePosition + "-" + (minValuePosition+1) + ", " + minValue + " öre/kWh\n");
            }
            else{
                System.out.print("Lägsta pris: " + minValuePosition + "-" + (minValuePosition + 1) + ", " + minValue + " öre/kWh\n");
            }

            System.out.print("Högsta pris: ");
            if (maxValuePosition < 9){
                System.out.print("Högsta pris: " + "0" + maxValuePosition + "-" + "0" + (maxValuePosition + 1) + ", " + maxValue + " öre/kWh\n");
            }
            else if (maxValuePosition ==9 ){
                System.out.print("Högsta pris: " + "0" + maxValuePosition + "-" + (maxValuePosition+1) + ", " + maxValue + " öre/kWh\n");
            }
            else{
                System.out.print("Högsta pris: " + maxValuePosition + "-" + (maxValuePosition + 1) + ", " + maxValue + " öre/kWh\n");
            }
            System.out.print("Medelpris: " + middle + " öre/kWh\n");

        }
    }


