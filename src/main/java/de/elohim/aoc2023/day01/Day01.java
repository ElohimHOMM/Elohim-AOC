package de.elohim.aoc2023.day01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day01 {
    private static final String name = "Day 1: Trebuchet?!";

    private final Map<String, String> numberMap = new HashMap<>();
    
    public Day01() {
        initializeMap(numberMap);
        List<String> input = Parser.readFile("2023", "01");
        Outputter.output(name, partOne(input), partTwo(input));
    }

    private String partOne(List<String> input) {
        int counter = 0;
        for (String line : input) {
            String lineCopy = new String(line);
            lineCopy = lineCopy.replaceAll("\\D", "");
            char char1 = lineCopy.charAt(0);
            char char2 = lineCopy.charAt(lineCopy.length() - 1);
            counter += Integer.parseInt(String.valueOf(char1) + String.valueOf(char2));
        }

        return String.valueOf(counter);
    }

    private String partTwo(List<String> input) {
        int counter = 0;
        for (String line : input) {
            String lineCopy = new String(line);
            lineCopy = wordsToNumbers(lineCopy);
            char char1 = lineCopy.charAt(0);
            char char2 = lineCopy.charAt(lineCopy.length() - 1);
            counter += Integer.parseInt(String.valueOf(char1) + String.valueOf(char2));
        }
        return String.valueOf(counter);
    }

    private String wordsToNumbers(String input) {
        Pattern pattern = Pattern.compile("(?<=(\\d|one|two|three|four|five|six|seven|eight|nine))");
        Matcher matcher = pattern.matcher(input);
        List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            matches.add(matcher.group(1));
        }
        return map(matches.get(0)) + map(matches.get(matches.size() - 1));
    }

    private String map(String in) {
        if (in.length() > 1) {
            return numberMap.get(in);
        }
        return in;
    }

    private void initializeMap(Map<String, String> map) {
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
    }
    
}
