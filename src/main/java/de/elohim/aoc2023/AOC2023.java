package de.elohim.aoc2023;

import java.util.Date;

import de.elohim.aoc2023.day05.Day05;
import de.elohim.helpers.Outputter;

public class AOC2023 {

    public static void main(String[] args) {
        Date date = new Date();
        long milis = date.getTime();
        Outputter.startingLines("2023");
        /**
        new Day01();
        new Day02();
        new Day03();
        new Day04();
        */
        new Day05();
        date = new Date();
        Outputter.endingLines("" + (date.getTime() - milis));
    }
    
}
