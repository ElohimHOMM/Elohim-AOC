package de.elohim.aoc2023.day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day04 {
    private static final String name = "Day 4: Scratchcards";
    Map<Integer, Scratchcard> scratchcards;

    public Day04() {
        scratchcards = new HashMap<>();
        generateScratchcards(Parser.readFile("2023", "04"));

        Outputter.output(name, partOne(), partTwo());
    }

    private String partOne() {
        AtomicInteger points = new AtomicInteger();
        for (var entry : scratchcards.entrySet()) {
            AtomicInteger hits = new AtomicInteger();
            entry.getValue().scratchedNumbers
                    .forEach(number -> hits.getAndAdd(entry.getValue().winningNumbers.contains(number) ? 1 : 0));
            if (hits.get() >= 1) {
                points.getAndAdd((int) Math.pow(2, hits.addAndGet(-1)));
            } else {
                points.getAndAdd(0);
            }
        }
        return points.get() + "";
    }

    private String partTwo() {
        for (var entry : scratchcards.entrySet()) {
            AtomicInteger hits = new AtomicInteger();
            entry.getValue().scratchedNumbers
                    .forEach(number -> hits.getAndAdd(entry.getValue().winningNumbers.contains(number) ? 1 : 0));
            int id = entry.getKey();
            int maxId = Math.min(id + hits.get(), scratchcards.size());
            while (id <= maxId) {
                scratchcards.get(id).setAmount(scratchcards.get(id).getAmount() + entry.getValue().getAmount());
                id++;
            }
        }

        AtomicInteger totalCards = new AtomicInteger();
        for (var entry : scratchcards.entrySet()) {
            totalCards.addAndGet(entry.getValue().amount);
        }
        return totalCards.get() + "";
    }

    private void generateScratchcards(List<String> input) {
        input.forEach(line -> {
            String[] splits = line.replaceAll("Card ", "").replaceAll("\\s\\s+", " ").split(" \\| ");

            List<Integer> drawnNumbers = new ArrayList<>();
            for (String s : splits[1].split(" ")) {
                drawnNumbers.add(Integer.parseInt(s.strip()));
            }

            splits = splits[0].split(": ");
            List<Integer> winningNumbers = new ArrayList<>();
            for (String s : splits[1].split(" ")) {
                winningNumbers.add(Integer.parseInt(s.strip()));
            }

            scratchcards.put(Integer.parseInt(splits[0].strip()), new Scratchcard(winningNumbers, drawnNumbers, 1));
        });
    }

    public static void main(String[] args) {
        new Day04();
    }

}
