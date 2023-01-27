package de.elohim.aoc2022.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day01 {
    private static final String name = "Day 1: Calorie Counting";

    public Day01() {
        List<String> input = Parser.readFile("2022", "01");
        int counter = 0;
        List<Integer> elves = new ArrayList<>();
        for (String line : input) {
            line = line.strip();
            if (line == "") {
                elves.add(counter);
                counter = 0;
            } else {
                counter += Integer.parseInt(line);
            }
        }

        Collections.sort(elves, Collections.reverseOrder());
        int threeMost = elves.get(0) + elves.get(1) + elves.get(2);

        Outputter.output(name, "" + elves.get(0), "" + threeMost);
    }
}
