package com.yak.example;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    LocalTime startTime;
    LocalTime finishTime;
    int timeLength;
    int numberToParse;
    long timeDiff;

    public static void main(String[] args) {
	// write your code here
        Main m = new Main();
        int loopsNumber = 10000;
        System.out.println("So, it begins");
        m.numberToParse = new Scanner(System.in).nextInt();
        m.loopParseInt(m.numberToParse, loopsNumber);
        m.loopParseString(m.numberToParse, loopsNumber);
        m.loopParseChar(m.numberToParse, loopsNumber);
    }

    private void loopParseInt(int number, int loopCount) {
        int[] indexSymbol = new int[2];
        int i = 0;
        startTime = LocalTime.now();
        for(; i<loopCount; i++) {
            indexSymbol = parseInt(number);
        }
        finishTime = LocalTime.now();
        timeDiff = ChronoUnit.NANOS.between(startTime, finishTime);
        System.out.println("int parsing: ");
        System.out.println("max number is: index - " + indexSymbol[0] + " symbol - " + indexSymbol[1]);
        System.out.println("calculating time legth: " + timeDiff);
        System.out.println();
    }

    private void loopParseString(int number, int loopCount) {
        int[] indexSymbol = new int[2];
        int i = 0;
        startTime = LocalTime.now();
        for(; i<loopCount; i++) {
            indexSymbol = parseString(number);
        }
        finishTime = LocalTime.now();
        timeDiff = ChronoUnit.NANOS.between(startTime, finishTime);
        System.out.println("String parsing: ");
        System.out.println("max number is: index - " + indexSymbol[0] + " symbol - " + indexSymbol[1]);
        System.out.println("calculating time legth: " + timeDiff);
        System.out.println();
    }

    private void loopParseChar(int number, int loopCount) {
        int[] indexSymbol = new int[2];
        int i = 0;
        startTime = LocalTime.now();
        for(; i<loopCount; i++) {
            indexSymbol = parseChar(number);
        }
        finishTime = LocalTime.now();
        timeDiff = ChronoUnit.NANOS.between(startTime, finishTime);
        System.out.println("Chars parsing: ");
        System.out.println("max number is: index - " + indexSymbol[0] + " symbol - " + indexSymbol[1]);
        System.out.println("calculating time legth: " + timeDiff);
        System.out.println();
    }

    private int[] parseString(int number) {
        int[] indexSymbol = new int[2];
        int maxSymbol = 0;
        char maxSymbolChar = '0';
        char currentSymbolChar = '0';
        int maxIndex = 1;
        String strNumber = String.valueOf(number);
        int numberLength = strNumber.length();
        for (int i=0; i<numberLength; i++) {
            currentSymbolChar = strNumber.charAt(i);
            if (currentSymbolChar > maxSymbolChar) {
                maxSymbolChar = currentSymbolChar;
                maxIndex = i + 1;
            }
        }
        maxSymbol = Character.getNumericValue(maxSymbolChar);
        indexSymbol[0] = maxIndex;
        indexSymbol[1] = maxSymbol;
        return indexSymbol;
    }

    private int[] parseChar(int number) {
        int[] indexSymbol = new int[2];
        int maxSymbol = 0;
        char maxSymbolChar = '0';
        char currentSymbolChar = '0';
        int maxIndex = 1;
        char[] numberChars = String.valueOf(number).toCharArray();
        int numberLength = numberChars.length;
        for (int i=0; i<numberLength; i++) {
            currentSymbolChar = numberChars[i];
            if (currentSymbolChar > maxSymbolChar) {
                maxSymbolChar = currentSymbolChar;
                maxIndex = i + 1;
            }
        }
        maxSymbol = Character.getNumericValue(maxSymbolChar);
        indexSymbol[0] = maxIndex;
        indexSymbol[1] = maxSymbol;
        return indexSymbol;
    }

    private int[] parseInt(int number) {
        int[] indexSymbol = new int[2];
        int numberCurrentState = number;
        int maxSymbol = 0;
        int maxIndex = 1;
        int currentSymbol = 0;
        int numberLength = 1;
        while (numberCurrentState >= 10) {
            numberCurrentState = Math.floorDiv(numberCurrentState, 10);
            numberLength++;
        }
        numberCurrentState = number;
        for (int i=numberLength; i>0; i--) {
            currentSymbol = Math.floorMod(numberCurrentState, 10);
            numberCurrentState = Math.floorDiv(numberCurrentState, 10);
            if(currentSymbol > maxSymbol) {
                maxIndex = i;
                maxSymbol = currentSymbol;
                if(currentSymbol == 9) {
                    break;
                }
            }
        }
        indexSymbol[0] = maxIndex;
        indexSymbol[1] = maxSymbol;
        return indexSymbol;
    }
}
