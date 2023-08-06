package de.elohim.aoc2022.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicLong;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day08 {

    private static final String name = "Day 8: Treetop Tree House";

    public Day08() {
        List<List<Integer>> input = parseInput();
        Outputter.output(name, partOne(input), partTwo(input));
    }

    private List<List<Integer>> parseInput() {
        List<String> rawInput = Parser.readFile("2022", "08");
        List<List<Integer>> ret = new ArrayList<>();
        rawInput.forEach(s -> {
            List<Integer> list = new ArrayList<>();
            for (char c : s.strip().toCharArray()) {
                list.add(Character.getNumericValue(c));
            }
            ret.add(list);
        });
        return ret;
    }

    private String partOne(List<List<Integer>> input) {
        int rows = input.size();
        int cols = input.get(0).size();

        List<List<Boolean>> hits = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            List<Boolean> hitRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                hitRow.add(Boolean.FALSE);
            }
            hits.add(hitRow);
        }

        /*
         * 0-98 -> 99 rows / cols
         * 
         */
        for (int row = 0; row < rows; row++) {
            int highestTree = -1;
            // Walk through row forwards
            for (int col = 0; col < cols; col++) {
                int currentTree = input.get(row).get(col);
                if (currentTree > highestTree) {
                    highestTree = currentTree;
                    hits.get(row).set(col, Boolean.TRUE);
                }
                if (highestTree == 9) break;
            }
            highestTree = -1;
            // Walk through row backwards
            for (int col = cols - 1; col >= 0; col--) {
                int currentTree = input.get(row).get(col);
                if (currentTree > highestTree) {
                    highestTree = currentTree;
                    hits.get(row).set(col, Boolean.TRUE);
                }
                if (highestTree == 9) break;
            }
        }

        for (int col = 0; col < cols; col++) {
            int highestTree = -1;
            // Walk through column forwards
            for (int row = 0; row < rows; row++) {
                List<Integer> intRow = input.get(row);
                int currentTree = intRow.get(col);
                if (currentTree > highestTree) {
                    highestTree = currentTree;
                    hits.get(row).set(col, Boolean.TRUE);
                }
                if (highestTree == 9) break;
            }
            highestTree = -1;
            // Walk through column backwards
            for (int row = rows - 1; row >= 0; row--) {
                List<Integer> intRow = input.get(row);
                int currentTree = intRow.get(col);
                if (currentTree > highestTree) {
                    highestTree = currentTree;
                    hits.get(row).set(col, Boolean.TRUE);
                }
                if (highestTree == 9) break;
            }
        }

        AtomicLong hitCount = new AtomicLong(0);
        hits.forEach(l -> hitCount.getAndAdd(l.stream().filter(b -> b.booleanValue()).count()));
        return String.valueOf(hitCount.get());
    }

    private String partTwo(List<List<Integer>> input) {
        int rows = input.size();
        int cols = input.get(0).size();

        List<List<Integer>> score = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            List<Integer> scoreRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                scoreRow.add(Integer.valueOf(1));
            }
            score.add(scoreRow);
        }

        Stack<Integer> stack = new Stack<>();
        for (int row = 0; row < rows; row++) {
            // Visibility positive x-Axis
            for (int col = 0; col < cols; col++) {
                while (!stack.isEmpty() && input.get(row).get(col) >= input.get(row).get(stack.peek())) {
                    int i = stack.pop();
                    score.get(row).set(i, score.get(row).get(i) * (col - i));
                }
                stack.push(col);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                score.get(row).set(i, score.get(row).get(i) * (cols - i - 1));
            }
            // Visibility negative x-Axis
            for (int col = cols - 1; col >= 0; col--) {
                while (!stack.isEmpty() && input.get(row).get(col) >= input.get(row).get(stack.peek())) {
                    int i = stack.pop();
                    score.get(row).set(i, score.get(row).get(i) * (i - col));
                }
                stack.push(col);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                score.get(row).set(i, score.get(row).get(i) * i);
            }
        }

        for (int col = 0; col < cols; col++) {
            // Visibility positive y-Axis
            for (int row = 0; row < rows; row++) {
                while (!stack.isEmpty() && input.get(row).get(col) >= input.get(stack.peek()).get(col)) {
                    int i = stack.pop();
                    score.get(i).set(col, score.get(i).get(col) * (row - i));
                }
                stack.push(row);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                score.get(i).set(col, score.get(i).get(col) * (rows - i - 1));
            }
            // Visibility negative y-Axis
            for (int row = rows - 1; row >= 0; row--) {
                while (!stack.isEmpty() && input.get(row).get(col) >= input.get(stack.peek()).get(col)) {
                    int i = stack.pop();
                    score.get(i).set(col, score.get(i).get(col) * (i - row));
                }
                stack.push(row);
            }
            while (!stack.isEmpty()) {
                int i = stack.pop();
                score.get(i).set(col, score.get(i).get(col) * i);
            }
        }

        AtomicLong highestScore = new AtomicLong(0);
        score.forEach(l -> l.forEach(i -> {
            if (highestScore.get() < i) highestScore.set(i);
        }));
        
        return String.valueOf(highestScore.get());
    }
    
}
