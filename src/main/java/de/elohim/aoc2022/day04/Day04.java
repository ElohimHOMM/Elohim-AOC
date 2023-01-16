package de.elohim.aoc2022.day04;

import de.elohim.helpers.Parser;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day04 {

    public static void partOne(List<String> input) {
        AtomicInteger counter = new AtomicInteger();
        input.forEach((string) -> {
            String[] elves = string.split(",");
            CleanupElf elf1 = new CleanupElf(elves[0]);
            CleanupElf elf2 = new CleanupElf(elves[1]);
            if((elf1.getStart() >= elf2.getStart() && elf1.getEnd() <= elf2.getEnd()) || (elf1.getStart() <= elf2.getStart() && elf1.getEnd() >= elf2.getEnd()))  {
                counter.getAndIncrement();
            }
        });
        System.out.println("Elves with overlap: " + counter);
    }

    public static void partTwo(List<String> input) {
        AtomicInteger counter = new AtomicInteger();
        input.forEach((string) -> {
            String[] elves = string.split(",");
            CleanupElf elf1 = new CleanupElf(elves[0]);
            CleanupElf elf2 = new CleanupElf(elves[1]);
            if(elf1.getEnd() < elf2.getStart() || elf1.getStart() > elf2.getEnd())  {
                counter.getAndIncrement();
            }
        });
        System.out.println("Elves with overlap: " + (1000 - counter.get()));
    }

    public static void main(String[] args) {
        List<String> input = Parser.readFile("2022", "04");
        partOne(input);
        partTwo(input);
    }
}