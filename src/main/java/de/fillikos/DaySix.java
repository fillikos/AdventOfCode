package de.fillikos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaySix implements Questions {

    private final List<String> inputData = new ArrayList<>();
    private final List<String> testData = new ArrayList<>();

    public DaySix() {
        File file = new File("src\\main\\resources\\InputDaySix.txt");
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
        testData.clear();
        testData.add("bvwbjplbgvbhsrlpgdmjqwftvncz");
        testData.add("nppdvjthqldpwncqszvftbrmjlhg");
        testData.add("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        testData.add("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");

        int stellen = 4;
        getStelle(stellen, inputData);

    }

    @Override
    public void getQuestionTwo() {
        testData.clear();
        testData.add("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        testData.add("bvwbjplbgvbhsrlpgdmjqwftvncz");
        testData.add("nppdvjthqldpwncqszvftbrmjlhg");
        testData.add("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        testData.add("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");

        int stellen = 14;
        getStelle(stellen, inputData);
    }

    private void getStelle(int stellen, List<String> data) {
        for (String com: data) {
            String abschnitt;
            for (int i = 0; i<com.length()-stellen+1; i++) {
                abschnitt = com.substring(i, i+stellen);
                List<Integer> counter = new ArrayList<>();
                for (int y = 0; y<stellen; y++) {
                    counter.add(y,0);
                }
                for (int j = 0; j<abschnitt.length(); j++) {
                    for (int k = 0; k<abschnitt.length(); k++) {
                        if (abschnitt.charAt(k) == abschnitt.charAt(j)) {
                            counter.set(j, counter.get(j) + 1);
                        }
                    }
                }
                Collections.sort(counter);
                if (counter.get(counter.size()-1) == 1) {
                    System.out.println(com.charAt(i+stellen-1) + " " + (i+stellen) + ". Stelle");
                    break;
                }
            }
        }
    }
}
