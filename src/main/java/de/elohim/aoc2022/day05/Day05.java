package de.elohim.aoc2022.day05;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Day05 {
    private static final String name = "Day 5: Supply Stacks";

    public Day05() {
        InputSet inputOne = new InputSet(Parser.readFile("2022", "05"));
        InputSet inputTwo = new InputSet(Parser.readFile("2022", "05"));
        Outputter.output(name, partOne(inputOne), partTwo(inputTwo));
    }

    public String partOne(InputSet input) {
        List<Deque<Character>> stacks = input.getStacks();
        input.getInputInstructions().forEach((set) -> {
            int from = set.getStackFrom() - 1;
            int to = set.getStackTo() - 1;
            for (int i = 0; i < set.getAmount(); i++) {
                stacks.get(to).addFirst(stacks.get(from).removeFirst());
            }
        });
        StringBuilder builder = new StringBuilder();
        stacks.forEach((stack) -> builder.append(stack.getFirst()));
        return builder.toString();
    }

    public String partTwo(InputSet input) {
        List<Deque<Character>> stacks = input.getStacks();
        input.getInputInstructions().forEach((set) -> {
            int from = set.getStackFrom() - 1;
            int to = set.getStackTo() - 1;
            Deque<Character> medianStack = new ArrayDeque<>();
            for (int i = 0; i < set.getAmount(); i++) {
                medianStack.addFirst(stacks.get(from).removeFirst());
            }
            for (int i = 0; i < set.getAmount(); i++) {
                stacks.get(to).addFirst(medianStack.removeFirst());
            }
        });
        StringBuilder builder = new StringBuilder();
        stacks.forEach((stack) -> builder.append(stack.getFirst()));
        return builder.toString();
    }
}