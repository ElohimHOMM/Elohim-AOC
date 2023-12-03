package de.elohim.aoc2023;

import java.util.Date;

import de.elohim.aoc2023.day01.Day01;
import de.elohim.aoc2023.day02.Day02;
import de.elohim.aoc2023.day03.Day03;
import de.elohim.helpers.Outputter;

public class AOC2023 {

    public static void main(String[] args) {
        Date date = new Date();
        long milis = date.getTime();
        Outputter.startingLines("2023");
        new Day01();
        new Day02();
        new Day03();
        Outputter.endingLines();
        date = new Date();
        System.out.println(date.getTime() - milis);
    }
    
}
