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
            int highestPriceHour = 0;
            int lowestPriceHour = 0;
            int lowestPrice = Integer.MAX_VALUE;
            for (int i = 0; i <minMaxPriceArray.length; i++) {
                if (minMaxPriceArray[i] > highestPrice) {
                    highestPrice = minMaxPriceArray[i];
                    highestPriceHour = i;
                }
                if (minMaxPriceArray[i] < lowestPrice) {
                    lowestPrice = minMaxPriceArray[i];
                    lowestPriceHour = i;
                }
                sum = minMaxPriceArray[i] + sum;
            }
            averagePrice = ((float) sum /minMaxPriceArray.length);
            System.out.printf("Lägsta pris: %02d-%02d, %d öre/kWh\n" , lowestPriceHour, (lowestPriceHour + 1), lowestPrice);
            System.out.printf("Högsta pris: %02d-%02d, %d öre/kWh\n" , highestPriceHour, (highestPriceHour+1), highestPrice);
            System.out.printf("Medelpris: " + "%.2f öre/kWh\n", averagePrice);
        }

        public void sort(){
            int[] valueArray  = new int[inData.length];
            for (int i = 0; i < inData.length; i++) {
                valueArray[i] = inData[i];
            }
            int[]hourArray = new int[24];
            for (int i = 0; i < 24; i++) {
                hourArray[i] = i;
            }
            int tempValue;
            int tempPosition;
            boolean swapped;
            for (int i = 0; i < valueArray.length-1; i++) {
                swapped = false;
                for (int j = 0; j < valueArray.length-1; j++) {
                    if (valueArray[j] < valueArray[j+1]) {
                        tempValue = valueArray[j];
                        valueArray[j] = valueArray[j+1];
                        valueArray[j+1] = tempValue;
                        tempPosition = hourArray[j];
                        hourArray[j] = hourArray[j+1];
                        hourArray[j+1] = tempPosition;
                        swapped = true;
                    }
                }
                if (!swapped) {break;}
            }
            for (int i = 0; i <inData.length ; i++) {
                System.out.printf("%02d-%02d %d öre\n" , hourArray[i], (hourArray[i] + 1), valueArray[i]);
            }
        }
        public void cheapest(){
            float cheapestFour = Integer.MAX_VALUE;
            int cheapestFirst = 0;
            for (int i = 0; i < inData.length-3; i++) {
                if (cheapestFour > inData[i] + inData[i+1] + inData[i+2] + inData[i+3]){
                    cheapestFour = inData[i] + inData[i+1] + inData[i+2] + inData[i+3];
                    cheapestFirst = i;
                }
            }
            System.out.printf("Påbörja laddning klockan %02d\n", cheapestFirst);
            System.out.printf("Medelpris 4h: %.1f öre/kWh\n",cheapestFour/4);
        }
        public void visual(){
            int lowestPrice = Integer.MAX_VALUE;
            for (int inDataValue : inData) {
                if (lowestPrice > inDataValue) {
                    lowestPrice = inDataValue;
                }
            }
            int seventh =530;
            int sixth = 432;
            int fifth = 334;
            int fourth =  236;
            int third = 138;
            int second =40;
            if (lowestPrice < 0) {
                seventh = 100;
                sixth = 77;
                fifth = 55;
                fourth = 32;
                third = 10;
                second = -12;
            }
        System.out.print(seventh +"|");
            for (int i = 7; i >= 0; i--) {
                for (int j = 0; j < inData.length; j++) {
                    String blank = " ";
                    if (i == 0 ) {
                        System.out.printf(" %02d", j);
                    } else if (i == 1) {
                        System.out.print("---");
                    } else if (inData[j] >= second && i == 2) {
                        System.out.print(blank + " x");
                    } else if (inData[j] >= third && i == 3) {
                        System.out.print(blank + " x");
                    } else if (inData[j] >= fourth && i == 4) {
                        System.out.print(blank + " x");
                    } else if (inData[j] >= fifth && i == 5) {
                        System.out.print(blank + " x");
                    } else if (inData[j] >= sixth && i == 6) {
                        System.out.print(blank + " x");
                    } else if (inData[j] >= seventh && i == 7) {
                        System.out.print(blank + " x");
                    } else {
                        System.out.print(blank + "  ");
                    }
                }
                if(i == 3) {
                    if (second<0) {
                        System.out.print("\n"+second+"|");
                    } else {
                        System.out.print("\n "+second+"|");
                    }
                } else if (i > 0) {
                    System.out.print("\n   |");
                }
            }
            System.out.print("\n");
        }
    }



