package de.fillikos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayTwo implements Questions {

    List<Integer> zuege = new ArrayList<>();
    List<String> strategie = new ArrayList<>();


    public DayTwo() {
        // A Stein  > Z Schere
        // C Schere > Y Papier
        // B Papier > X Stein
        // Stein    = 1
        // Papier   = 2
        // Schere   = 3
        // verloren = 0
        // equals   = 3
        // gewonnen = 6
        // Gegner Ich

        // Einlesen des Strategieleitfadens
        File file = new File("src\\main\\resources\\InputDayTwo.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));

            String zeile;
//            List<String> uebung = new ArrayList<>();
//            uebung.add("A Y");
//            uebung.add("B X");
//            uebung.add("C Z");
//            for (String zeile: uebung) {
            while ( (zeile = in.readLine()) != null ) {
                strategie.add(zeile);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private int first(String zeile) {
        int ergebnis = 0;
        switch (zeile.charAt(2)) {
            case 'X':
                // X = Stein
                ergebnis = 1;
                switch (zeile.charAt(0)) {
                    // Stein - Stein
                    case 'A': ergebnis += 3; break;
                    // Papier > Stein
                    case 'B': ergebnis += 0; break;
                    // Schere < Stein
                    case 'C': ergebnis += 6; break;
                    default: break;
                }
                break;
            case 'Y':
                // Y = Papier
                ergebnis = 2;
                switch (zeile.charAt(0)) {
                    // Stein < Papier
                    case 'A': ergebnis += 6; break;
                    // Papier - Papier
                    case 'B': ergebnis += 3; break;
                    // Schere > Papier
                    case 'C': ergebnis += 0; break;
                    default: break;
                }
                break;
            case 'Z':
                // Z = Schere
                ergebnis = 3;
                switch (zeile.charAt(0)) {
                    // Stein > Schere
                    case 'A': ergebnis += 0; break;
                    // Papier < Schere
                    case 'B': ergebnis += 6; break;
                    // Schere - Schere
                    case 'C': ergebnis += 3; break;
                    default: break;
                }
                break;
            default: break;
        }
        return ergebnis;
    }

    private int second(String zeile) {
        int ergebnis = 0;
        switch (zeile.charAt(2)) {
            case 'X':
                // X = loose
                switch (zeile.charAt(0)) {
                    // Stein > Schere
                    case 'A': ergebnis += 3; break;
                    // Papier > Stein
                    case 'B': ergebnis += 1; break;
                    // Schere > Papier
                    case 'C': ergebnis += 2; break;
                    default: break;
                    // Stein    = 1
                    // Papier   = 2
                    // Schere   = 3
                }
                break;
            case 'Y':
                // Y = draw
                ergebnis = 3;
                switch (zeile.charAt(0)) {
                    // Stein - Stein
                    case 'A': ergebnis += 1; break;
                    // Papier - Papier
                    case 'B': ergebnis += 2; break;
                    // Schere - Schere
                    case 'C': ergebnis += 3; break;
                    default: break;
                }
                break;
            case 'Z':
                // Z = win
                ergebnis = 6;
                switch (zeile.charAt(0)) {
                    // Stein < Papier
                    case 'A': ergebnis += 2; break;
                    // Papier < Schere
                    case 'B': ergebnis += 3; break;
                    // Schere < Stein
                    case 'C': ergebnis += 1; break;
                    default: break;
                }
                break;
            default: break;
        }
        return ergebnis;
    }

    @Override
    public void getQeustionOne() {
        int ergebnis;
        int gesamtErgebnis = 0;
        for (String zeile: strategie) {
            ergebnis = first(zeile);
            zuege.add(ergebnis);
            gesamtErgebnis += ergebnis;
        }
        System.out.println("Die Gesamtpunktzahl des eigenen Strategieleitfadens beträgt: " + gesamtErgebnis + " Punkte.");
    }

    @Override
    public void getQuestionTwo() {
        int ergebnis;
        int gesamtErgebnis = 0;
        for (String zeile: strategie) {
            ergebnis = second(zeile);
            zuege.add(ergebnis);
            gesamtErgebnis += ergebnis;
        }
        System.out.println("Die Gesamtpunktzahl des tatsächlichen Strategieleitfadens beträgt: " + gesamtErgebnis + " Punkte.");
    }
}
