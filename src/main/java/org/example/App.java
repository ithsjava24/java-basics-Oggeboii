package org.example;

import java.util.*;

public class App {

    public Scanner scanner;
    public int[] inData;


        public static void main (String[]args) {
            App app = new App();
            app.run();
            Locale.setDefault(Locale.of ("sv","SE"));

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
                        "5. Visualisering\n",
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
                    case "5":
                        visual();
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
            float averagePrice;
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

            averagePrice = ((float) sum /minMaxPriceArray.length);
            System.out.printf("Lägsta pris: %02d-%02d, %d öre/kWh\n" , lowestPricePosition, (lowestPricePosition + 1), lowestPrice);
            System.out.printf("Högsta pris: %02d-%02d, %d öre/kWh\n" , highestPricePosition, (highestPricePosition+1), highestPrice);
            System.out.printf("Medelpris: " + "%.2f öre/kWh\n", averagePrice);
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
        public void visual(){
            int lowestPrice = Integer.MAX_VALUE;
            for (int inDatum : inData) {
                if (lowestPrice > inDatum) {
                    lowestPrice = inDatum;
                }
            }
            int sixth =530;
            int fifth = 432;
            int fourth = 334;
            int third =  236;
            int second = 138;
            int first =40;
            if (lowestPrice < 0) {
                sixth = 100;
                fifth = 77;
                fourth = 55;
                third = 32;
                second = 10;
                first = -12;
            }
        System.out.print(sixth +"|");
            for (int i = 7; i > 0; i--) {
                if (i >1) {
                    for (int inDatum : inData) {
                        String blank = " ";
                        if (inDatum >= first && i == 2) {
                            System.out.print(blank + " x");
                        } else if (inDatum >= second && i == 3) {
                            System.out.print(blank + " x");
                        } else if (inDatum >= third && i == 4) {
                            System.out.print(blank + " x");
                        } else if (inDatum >= fourth && i == 5) {
                            System.out.print(blank + " x");
                        } else if (inDatum >= fifth && i == 6) {
                            System.out.print(blank + " x");
                        } else if (inDatum >= sixth && i == 7) {
                            System.out.print(blank + " x");
                        } else {
                            System.out.print(blank + "  ");
                        }
                    }
                }
                if(i == 3) {
                    if (first<0)
                        System.out.print("\n"+first+"|");
                    else
                        System.out.print("\n "+first+"|");
                }
                else
                    System.out.print("\n   |");
                for (int j = 0; j < inData.length; j++) {
                    if (i == 2) {
                        System.out.print("---");
                    }
                    if(i == 1) {
                        System.out.printf(" %02d", j);
                    }
                }
            }
            System.out.print("\n");
        }
    }



