package de.elohim.aoc2022;

import java.util.Date;

import de.elohim.aoc2022.day01.Day01;
import de.elohim.aoc2022.day02.Day02;
import de.elohim.aoc2022.day03.Day03;
import de.elohim.aoc2022.day04.Day04;
import de.elohim.aoc2022.day05.Day05;
import de.elohim.aoc2022.day06.Day06;
import de.elohim.aoc2022.day07.Day07;
import de.elohim.aoc2022.day08.Day08;
import de.elohim.helpers.Outputter;

public class AOC2022 {
    
    public static void main(String[] args) {
        Date date = new Date();
        long milis = date.getTime();
        Outputter.startingLines("2022");
        new Day01();
        new Day02();
        new Day03();
        new Day04();
        new Day05();
        new Day06();
        new Day07();
        new Day08();
        date = new Date();
        Outputter.endingLines("" + (date.getTime() - milis));
    }
}
