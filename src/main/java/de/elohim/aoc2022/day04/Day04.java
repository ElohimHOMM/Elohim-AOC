package de.elohim.aoc2022.day04;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Day04 {
    private static final String name = "Day 4: Camp Cleanup";

    public Day04() {
        List<String> input = Parser.readFile("2022", "04");
        Outputter.output(name, partOne(input), partTwo(input));
    }

    public String partOne(List<String> input) {
        AtomicInteger counter = new AtomicInteger();
        input.forEach((string) -> {
            String[] elves = string.split(",");
            CleanupElf elf1 = new CleanupElf(elves[0]);
            CleanupElf elf2 = new CleanupElf(elves[1]);
            if((elf1.getStart() >= elf2.getStart() && elf1.getEnd() <= elf2.getEnd()) || (elf1.getStart() <= elf2.getStart() && elf1.getEnd() >= elf2.getEnd()))  {
                counter.getAndIncrement();
            }
        });
        return counter + "";
    }

    public String partTwo(List<String> input) {
        AtomicInteger counter = new AtomicInteger();
        input.forEach((string) -> {
            String[] elves = string.split(",");
            CleanupElf elf1 = new CleanupElf(elves[0]);
            CleanupElf elf2 = new CleanupElf(elves[1]);
            if(elf1.getEnd() < elf2.getStart() || elf1.getStart() > elf2.getEnd())  {
                counter.getAndIncrement();
            }
        });
        return (1000 - counter.get()) + "";
    }
}