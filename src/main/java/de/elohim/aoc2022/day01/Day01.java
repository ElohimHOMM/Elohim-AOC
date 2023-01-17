package de.elohim.aoc2022.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.elohim.helpers.Parser;

public class Day01 {
    
    public static void main(String[] args) {
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

        System.out.println("The elf with the most calories is carrying " + elves.get(0) + " calories.");
        System.out.println("The three elves with the most calories are carrying " + threeMost + " calories.");
    }
}
