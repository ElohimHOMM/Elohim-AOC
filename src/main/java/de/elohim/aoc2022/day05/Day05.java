package de.elohim.aoc2022.day05;

import de.elohim.helpers.Parser;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Day05 {

    public static void partOne(InputSet input) {
        List<Deque<Character>> stacks = input.getStacks();
        input.getInputInstructions().forEach((set) -> {
            int from = set.getStackFrom() - 1;
            int to = set.getStackTo() - 1;
            for (int i = 0; i < set.getAmount(); i++) {
                stacks.get(to).addFirst(stacks.get(from).removeFirst());
            }
        });
        stacks.forEach((stack) -> System.out.print(stack.getFirst()));
        System.out.println();
    }

    public static void partTwo(InputSet input) {
        List<Deque<Character>> stacks = input.getStacks();
        input.getInputInstructions().forEach((set) -> {
            // System.out.println("--------------"); // This is a line of debug code
            int from = set.getStackFrom() - 1;
            int to = set.getStackTo() - 1;
            Deque<Character> medianStack = new ArrayDeque<>();
            // System.out.println(stacks.get(from) + "(" + set.getAmount() + ") -> " + stacks.get(to)); // This is a line of debug code
            for (int i = 0; i < set.getAmount(); i++) {
                medianStack.addFirst(stacks.get(from).removeFirst());
            }
            for (int i = 0; i < set.getAmount(); i++) {
                stacks.get(to).addFirst(medianStack.removeFirst());
            }

        });
        stacks.forEach((stack) -> System.out.print(stack.getFirst()));
    }

    public static void main(String[] args) {
        InputSet input = new InputSet(Parser.readFile("2022", "05"));
        partOne(input);
        input = new InputSet(Parser.readFile("2022", "05"));
        partTwo(input);
    }
}