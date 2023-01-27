package de.elohim.aoc2022.day06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day06 {
    private static final String name = "Day 6: Tuning Trouble";

    public Day06() {
        String input = Parser.readFile("2022", "06").get(0);
        Outputter.output(name, detect(4, input), detect(14, input));
    }

    private static String detect(int size, String input) {
        List<Character> buffer = Arrays.asList(input.substring(0, size).chars().mapToObj(c -> (char) c).toArray(Character[]::new));
        Set<Character> set = new HashSet<>();
        int index = 0;
        int i = size - 1;
        while (set.size() < size) {
            i++;
            set = new HashSet<>(buffer);
            Character c = input.toCharArray()[i];
            buffer.set(index, c);
            index = (index + 1) % size;
        }
        return i + "";
    }
}
