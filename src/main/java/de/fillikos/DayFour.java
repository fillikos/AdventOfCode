package de.fillikos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayFour implements Questions {

    List<String> inputData = new ArrayList<>();

    public DayFour() {
        File file = new File("src\\main\\resources\\InputDayFour.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String zeile;
            while ( (zeile = in.readLine()) != null ) {
                inputData.add(zeile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void getQeustionOne() {
        int sum = 0;

        List<String> testDaten = new ArrayList<>();
        testDaten.add("2-4,6-8");
        testDaten.add("2-3,4-5");
        testDaten.add("5-7,7-9");
        testDaten.add("2-8,3-7");
        testDaten.add("6-6,4-6");
        testDaten.add("2-6,4-8");

        for (String zeile: inputData) {
            int[] section = new int[4];
            section[0] = Integer.parseInt(zeile.substring(0,zeile.indexOf("-")));
            section[1] = Integer.parseInt(zeile.substring(zeile.indexOf("-")+1,zeile.indexOf(",")));
            section[2] = Integer.parseInt(zeile.substring(zeile.indexOf(",")+1,zeile.lastIndexOf("-")));
            section[3] = Integer.parseInt(zeile.substring(zeile.lastIndexOf("-")+1));

            if ( section[0] >= section[2] && section[0] <= section[3] &&
                    section[1] >= section[2] && section[1] <= section[3] ||
                    section[2] >= section[0] && section[2] <= section[1] &&
                            section[3] >= section[0] && section[3] <= section[1]) {
                sum++;
            }
        }

        System.out.println("Bei " + sum + " pärchen wird der gleiche Inhalt gereinigt.");

    }

    @Override
    public void getQuestionTwo() {
        int sum = 0;

        List<String> testDaten = new ArrayList<>();
        testDaten.add("5-7,7-9");
        testDaten.add("2-8,3-7");
        testDaten.add("6-6,4-6");
        testDaten.add("2-6,4-8");
        testDaten.add("2-4,5-6");

        for (String zeile: inputData) {
            int[] section = new int[4];
            section[0] = Integer.parseInt(zeile.substring(0,zeile.indexOf("-")));
            section[1] = Integer.parseInt(zeile.substring(zeile.indexOf("-")+1,zeile.indexOf(",")));
            section[2] = Integer.parseInt(zeile.substring(zeile.indexOf(",")+1,zeile.lastIndexOf("-")));
            section[3] = Integer.parseInt(zeile.substring(zeile.lastIndexOf("-")+1));

            if ( section[0] >= section[2] && section[0] <= section[3] ||
                    section[1] >= section[2] && section[1] <= section[3] ||
                    section[2] >= section[0] && section[2] <= section[1] ||
                            section[3] >= section[0] && section[3] <= section[1]) {
                sum++;
            }
        }

        System.out.println("Bei " + sum + " pärchen werden gleiche Inhalte gereinigt.");

    }
}
