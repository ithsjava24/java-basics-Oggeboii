package org.example;

import java.util.*;

public class App {

    public Scanner scanner;
    public int[] inData;


        public static void main (String[]args) {
            App app = new App();
            app.run();
        }
        public App(){
            this.scanner = new Scanner(System.in);
            this.inData = new int[24];
        }
        public void run () {
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
                menuSelected = scanner.nextLine();
                switch (menuSelected.toLowerCase()) {
                    case "1":
                        Inmatning();
                        break;
                    case "2":
                        minMaxMiddle();
                        break;
                    case "3":
                        sort();
                        break;
                    case "4":
                        cheapest();
                        break;
                    case "e":
                        gameOn = false;
                        break;
                }
            }
        }
        public void Inmatning() {
            for (int i = 0; i < inData.length; i++) {
                try {
                    inData[i] = Integer.parseInt(scanner.nextLine());

                } catch (NumberFormatException e) {
                    System.out.print("Skriv in öre/kWh tack: \n");
                    i--;
                }
            }
        }
        public void minMaxMiddle() {
            int[] minMaxPriceArray = inData;
            int sum = 0;
            float avaragePrice =0f;
            int highestPrice = 0;
            int highestPricePosition = 0;
            int lowestPricePosition = 0;
            int lowestPrice = Integer.MAX_VALUE;
            for (int i = 0; i <minMaxPriceArray.length; i++) {
                if (minMaxPriceArray[i] > highestPrice) {
                    highestPrice = minMaxPriceArray[i];
                    highestPricePosition = i;
                }
                if (minMaxPriceArray[i] < lowestPrice) {
                    lowestPrice = minMaxPriceArray[i];
                    lowestPricePosition = i;
                }
                sum = minMaxPriceArray[i] + sum;
            }
            avaragePrice = ((float) sum /minMaxPriceArray.length);
            //prinf(%02d -%02d,
            System.out.printf("Lägsta pris: %02d-%02d, %d öre/kWh\n" , lowestPricePosition, (lowestPricePosition + 1), lowestPrice);
            System.out.printf("Högsta pris: %02d-%02d, %d öre/kWh\n" , highestPricePosition, (highestPricePosition+1), highestPrice);
            System.out.printf("Medelpris: " + "%.2f öre/kWh\n", avaragePrice);
        }
        public void sort(){
            int[] sortArray  = new int[inData.length];
            for (int i = 0; i < inData.length; i++) {
                sortArray[i] = inData[i];
            }
            int[]positionArray = new int[24];
            for (int i = 0; i < 24; i++) {
                positionArray[i] = i;
            }
            int tempValue;
            int tempPosition;
            boolean swapped;
            for (int i = 0; i < sortArray.length-1; i++) {
                swapped = false;
                for (int j = 0; j < sortArray.length-1; j++) {
                    if (sortArray[j] < sortArray[j+1]) {
                        tempValue = sortArray[j];
                        sortArray[j] = sortArray[j+1];
                        sortArray[j+1] = tempValue;
                        tempPosition = positionArray[j];
                        positionArray[j] = positionArray[j+1];
                        positionArray[j+1] = tempPosition;
                        swapped = true;
                    }
                }
                if (!swapped) {break;}
            }
            for (int i = 0; i <inData.length ; i++) {
                System.out.printf("%02d-%02d %d öre\n" , positionArray[i], (positionArray[i] + 1), sortArray[i]);
            }
        }
        public void cheapest(){
            float cheapestFour = Integer.MAX_VALUE;
            int cheapestFirst = 0;
            for (int i = 0; i < inData.length-4; i++) {
                if (cheapestFour > inData[i] + inData[i+1] + inData[i+2] + inData[i+3]){
                    cheapestFour = inData[i] + inData[i+1] + inData[i+2] + inData[i+3];
                    cheapestFirst = i;
                }
            }
            System.out.printf("Påbörja laddning klockan %02d\n", cheapestFirst);
            System.out.printf( "Medelpris 4h: %.1f öre/kWh\n",cheapestFour/4);
        }

    }



