package de.elohim.aoc2023;

import de.elohim.aoc2023.day01.Day01;
import de.elohim.aoc2023.day02.Day02;
import de.elohim.helpers.Outputter;

public class AOC2023 {

    public static void main(String[] args) {
        Outputter.startingLines("2023");
        new Day01();
        new Day02();
        Outputter.endingLines();
    }
    
}
