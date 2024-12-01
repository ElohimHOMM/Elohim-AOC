package de.elohim.aoc2024;

import java.util.Date;

import de.elohim.aoc2024.day01.Day01;
import de.elohim.helpers.Outputter;

public class AOC2024 {

    public static void main(String[] args) {
        Date date = new Date();
        long milis = date.getTime();
        Outputter.startingLines("2024");
        new Day01();
        date = new Date();
        Outputter.endingLines("" + (date.getTime() - milis));
    }
    
}
