package de.fillikos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DayThree implements Questions {

    int sum = 0;
    List<String> rucksack = new ArrayList<>();

    public DayThree() {
        File file = new File("src\\main\\resources\\InputDayThree.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String zeile;
            while ( (zeile = in.readLine()) != null ) {
                rucksack.add(zeile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void addSum(char charAt) {
        switch (charAt) {
            case 'Z': sum += 1;
            case 'Y': sum += 1;
            case 'X': sum += 1;
            case 'W': sum += 1;
            case 'V': sum += 1;
            case 'U': sum += 1;
            case 'T': sum += 1;
            case 'S': sum += 1;
            case 'R': sum += 1;
            case 'Q': sum += 1;
            case 'P': sum += 1;
            case 'O': sum += 1;
            case 'N': sum += 1;
            case 'M': sum += 1;
            case 'L': sum += 1;
            case 'K': sum += 1;
            case 'J': sum += 1;
            case 'I': sum += 1;
            case 'H': sum += 1;
            case 'G': sum += 1;
            case 'F': sum += 1;
            case 'E': sum += 1;
            case 'D': sum += 1;
            case 'C': sum += 1;
            case 'B': sum += 1;
            case 'A': sum += 1;
            case 'z': sum += 1;
            case 'y': sum += 1;
            case 'x': sum += 1;
            case 'w': sum += 1;
            case 'v': sum += 1;
            case 'u': sum += 1;
            case 't': sum += 1;
            case 's': sum += 1;
            case 'r': sum += 1;
            case 'q': sum += 1;
            case 'p': sum += 1;
            case 'o': sum += 1;
            case 'n': sum += 1;
            case 'm': sum += 1;
            case 'l': sum += 1;
            case 'k': sum += 1;
            case 'j': sum += 1;
            case 'i': sum += 1;
            case 'h': sum += 1;
            case 'g': sum += 1;
            case 'f': sum += 1;
            case 'e': sum += 1;
            case 'd': sum += 1;
            case 'c': sum += 1;
            case 'b': sum += 1;
            case 'a': sum += 1;
            default: break;
        }
    }

    @Override
    public void getQeustionOne() {
        sum = 0;

        for (String zeile: rucksack) {
            String itemOne = zeile.substring(0, zeile.length() / 2);
            String itemTwo = zeile.substring(zeile.length() / 2);

            for (int i = 0; i<itemOne.length(); i++) {
                if ( itemTwo.indexOf(itemOne.charAt(i)) != -1 ) {
                    addSum(itemOne.charAt(i));
                    break;
                }
            }
        }

        System.out.println("Die Summe der Elemente mit Priorisierung beträgt: " + sum);
    }

    @Override
    public void getQuestionTwo() {
        sum = 0;
        int j = 0;
        String zeileOne;
        String zeileTwo;
        String zeileThree;

        while (j < rucksack.size()) {
            zeileOne = rucksack.get(j);
            zeileTwo = rucksack.get(j+1);
            zeileThree = rucksack.get(j+2);

            for (int i = 0; i<zeileOne.length(); i++) {
                if ( zeileTwo.indexOf(zeileOne.charAt(i)) != -1 &&
                        zeileThree.indexOf(zeileOne.charAt(i)) != -1) {
                    addSum(zeileOne.charAt(i));
                    break;
                }

            }

            j = j + 3;
        }

        System.out.println("Die Summe der Gruppen-Elemente mit Priorisierung beträgt: " + sum);
    }
}
