package de.fillikos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayOne implements Questions{

    List<Integer> daten = new ArrayList<>();

    public DayOne() {
        try {
            // Einlesen der Quelldaten
            File file = new File("src\\main\\resources\\InputDayOne.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));

            String zeile;
            int kcal = 0;
            while ( (zeile = in.readLine()) != null) {
                if (zeile.isEmpty()) {
                    // Bei einer leeren Zeile wird die GesamtKcal anzahl eines Elchs der Liste Hinzugefügt
                    daten.add(kcal);
                    kcal = 0;
                } else {
                    // Ist die Zeile nicht Leer enthält sie weitere Snacks für die Elche, welche addiert werden
                    kcal += Integer.parseInt(zeile);
                }
            }
            // Die letzte Anzahl von Snacks muss noch hinzugefügt werden
            daten.add(kcal);
            // Die Liste sortieren, 0...1000
            Collections.sort(daten);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void getQeustionOne() {
        // Ausgabe des größten Snackbeutels (letztes Element der Liste)
        System.out.println("Der größte Snackbeutel ist " + daten.get(daten.size() - 1) + " kcal groß.");
    }

    public void getQuestionTwo() {
        // Ausgabe der addierten drei größten Snackbeutel (letzten drei Elemente der Liste)
        System.out.println("Die drei größten Snackbeutel haben zusammen " +
                (daten.get(daten.size() - 1) + daten.get(daten.size() - 2) + daten.get(daten.size() - 3)) +
                " kcal.");
    }
}
