package de.elohim.aoc2024.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day01 {
    private static final String name = "Day 1: Historian Hysteria";
    
    private List<Integer> leftNumbers;
    private List<Integer> rightNumbers;

    public Day01() {
        parseInput(Parser.readFile("2024", "01"));

        Outputter.output(name, partOne(), partTwo());
    }

    /**
     * 29905342: too high
     * 
     */

    private String partOne() {
        int sum = 0;
        for (int i = 0; i < leftNumbers.size(); i++) {
            sum += Math.abs(leftNumbers.get(i) - rightNumbers.get(i));
        }
        return sum + "";
    }

    private String partTwo() {
        int similarityScore = 0;
        for (Integer i : leftNumbers) {
            similarityScore += (i * Collections.frequency(rightNumbers, i));
        }
        return similarityScore + "";
    }

    private void parseInput(List<String> input) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (String line : input) {
            var splits = line.split("   ");
            left.add(Integer.parseInt(splits[0]));
            right.add(Integer.parseInt(splits[1]));
        }
        leftNumbers = left.stream().sorted().collect(Collectors.toList());
        rightNumbers = right.stream().sorted().collect(Collectors.toList());
    }
}
