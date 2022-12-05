package de.fillikos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayFive implements Questions {

    List<String> inputData = new ArrayList<>();
    List<String> testData = new ArrayList<>();

    public DayFive() {
        File file = new File("src\\main\\resources\\InputDayFive.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String zeile;
            while ( (zeile = in.readLine()) != null ) {
                inputData.add(zeile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> testData = new ArrayList<>();
        testData.add("    [D]");
        testData.add("[N] [C]");
        testData.add("[Z] [M] [P]");
        testData.add(" 1   2   3");
        testData.add("");
        testData.add("move 1 from 2 to 1");
        testData.add("move 3 from 1 to 3");
        testData.add("move 2 from 2 to 1");
        testData.add("move 1 from 1 to 2");
    }

    private List<List<String>> prepareData(List<String> data) {
        List<List<String>> puzzle = new ArrayList<>();
        // Aufbau des Puzzles
        // Anzahl der Listen generieren
        for (String zeile: data) {
            if (zeile.startsWith(" 1")) {
                for (int i = 0; i<zeile.length(); i++) {
                    if (zeile.charAt(i) != ' ') {
                        puzzle.add(new ArrayList<>());
                    }
                }
                break;
            }
        }

        // Listen mit den Werten befüllen
        for (String zeile: data) {
            if (zeile.startsWith(" 1")) break;
            for (int i = 0; i<zeile.length(); i++) {
                if (zeile.charAt(i) != ' ' && zeile.charAt(i) != '[' && zeile.charAt(i) != ']') {
                    if (i == 1) {
                        puzzle.get(0).add(String.valueOf(zeile.charAt(i)));
                    } else {
                        int j = (i - 1) / 4;
                        puzzle.get(j).add(String.valueOf(zeile.charAt(i)));
                    }
                }
            }
        }

        // Listeninhalt umdrehen, da von oben nach unten befüllt wurde
        for (List<String> container: puzzle) {
            Collections.reverse(container);
        }

        return puzzle;
    }

    @Override
    public void getQeustionOne() {
        List<List<String>> puzzle = prepareData(inputData);

        // Verarbeitung der Schritte
        for (String zeile: inputData) {
            if (zeile.startsWith("move")) {
                int anzahl = Integer.parseInt(zeile.substring(zeile.indexOf("move ") + 5, zeile.indexOf(" ", 5)));
                int von = Integer.parseInt(zeile.substring(zeile.indexOf("from ") + 5, zeile.indexOf(" ", zeile.indexOf("from ") + 5))) - 1;
                int zu = Integer.parseInt(zeile.substring(zeile.indexOf("to ") + 3)) - 1;
                for (int i = 0; i<anzahl; i++) {
                    puzzle.get(zu).add(puzzle.get(von).get(puzzle.get(von).size() - 1));
                    puzzle.get(von).remove(puzzle.get(von).size() - 1);
                }
            }
        }

        // Ausgabe der letzten Daten
        StringBuilder ergebnis = new StringBuilder();
        for (List<String> container: puzzle) {
            ergebnis.append(container.get(container.size() - 1));
        }

        System.out.println(ergebnis);
    }

    @Override
    public void getQuestionTwo() {
        List<List<String>> puzzle = prepareData(inputData);

        // Verarbeitung der Schritte
        for (String zeile: inputData) {
            if (zeile.startsWith("move")) {
                List<String> temp = new ArrayList<>();
                int anzahl = Integer.parseInt(zeile.substring(zeile.indexOf("move ") + 5, zeile.indexOf(" ", 5)));
                int von = Integer.parseInt(zeile.substring(zeile.indexOf("from ") + 5, zeile.indexOf(" ", zeile.indexOf("from ") + 5))) - 1;
                int zu = Integer.parseInt(zeile.substring(zeile.indexOf("to ") + 3)) - 1;
                for (int i = 0; i<anzahl; i++) {
                    temp.add(puzzle.get(von).get(puzzle.get(von).size() - 1));
                    puzzle.get(von).remove(puzzle.get(von).size() - 1);
                }
                Collections.reverse(temp);
                puzzle.get(zu).addAll(temp);
            }
        }

        // Ausgabe der letzten Daten
        StringBuilder ergebnis = new StringBuilder();
        for (List<String> container: puzzle) {
            ergebnis.append(container.get(container.size() - 1));
        }
        System.out.println(ergebnis);
    }
}
