package de.elohim.aoc2022.day03;

import java.util.ArrayList;
import java.util.List;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day03 {
    private static final String name = "Day 3: Rucksack Reorganization";

    public Day03() {
        List<String> input = Parser.readFile("2022", "03");
        Outputter.output(name, partOne(input), partTwo(input));
    }
    
    private String partOne(List<String> input) {
        int priorities = 0;
        for (String line : input) {
            line = line.strip();
            String compartmentOne = line.substring(0, Math.floorDiv(line.length(), 2));
            String compartmentTwo = line.substring(Math.floorDiv(line.length(), 2), line.length());
            String commonLetters = getCommonLetters(compartmentOne, compartmentTwo);
            priorities += getPriority(commonLetters.toCharArray()[0]);
        }
        return priorities + "";
    }

    private String partTwo(List<String> input) {
        int priorities = 0;
        String elfOne = "";
        String elfTwo = "";
        String elfThree = "";
        int counter = 1;
        for (String line : input) {
            line = line.strip();
            if (counter == 1) {
                elfOne = line;
                counter++;
                continue;
            } else if (counter == 2) {
                elfTwo = line;
                counter++;
                continue;
            } 
            elfThree = line;
            counter = 1;
            String commonLetters = getCommonLetters(elfTwo, elfThree);
            commonLetters = getCommonLetters(elfOne, commonLetters);
            priorities += getPriority(commonLetters.toCharArray()[0]);
        }
        return priorities + "";
    }

    private String getCommonLetters(String s1, String s2) {
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();
        for (Character c : s1.toCharArray()) {
            l1.add(c);
        }
        for (Character c : s2.toCharArray()) {
            l2.add(c);
        }
        l1.retainAll(l2);
        StringBuilder ret = new StringBuilder();
        for (Character c : l1) {
            ret.append(c);
        }
        return ret.toString();
    }

    private int getPriority(char c) {
        int asciiValue = c;
        if (asciiValue < 95) {
            return asciiValue - 38;
        } else {
            return asciiValue - 96;
        }
    }
}
