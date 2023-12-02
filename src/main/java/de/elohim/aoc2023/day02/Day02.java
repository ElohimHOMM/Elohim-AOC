package de.elohim.aoc2023.day02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day02 {
    private static final String name = "Day 2: Cube Conundrum";

    private final Game possibleGame = new Game(0, 12, 13, 14);
    private static final String RED = "red";
    private static final String GREEN = "green";
    private static final String BLUE = "blue";
    
    public Day02() {
        List<Game> input = generateGames(Parser.readFile("2023", "02"));
        Outputter.output(name, partOne(input), partTwo(input));        
    }

    private String partOne(List<Game> input) {
        AtomicInteger ret = new AtomicInteger();
        input.forEach(game -> {
            ret.getAndAdd(possibleGame.isPossible(game));
        });

        return ret.get() + "";
    }

    private String partTwo(List<Game> input) {
        AtomicInteger ret = new AtomicInteger();
        input.forEach(game -> {
            ret.getAndAdd(game.getPower());
        });
        return ret.get() + "";
    } 

    private List<Game> generateGames(List<String> input) {
        List<Game> ret = new ArrayList<>();

        input.forEach(line -> {
            String[] split = line.split(":");
            int gameId = Integer.parseInt(split[0].strip().split(" ")[1]);

            int redCubes = 0;
            int greenCubes = 0;
            int blueCubes = 0;

            for (String game : split[1].split(";")) {
                for (String draw : game.split(",")) {
                    String[] drawDetails = draw.strip().split(" ");
                    String color = drawDetails[1].strip();
                    int amount = Integer.parseInt(drawDetails[0].strip());

                    if (Objects.equals(color, RED) && amount > redCubes) {
                        redCubes = amount;
                    } else if (Objects.equals(color, GREEN) && amount > greenCubes) {
                        greenCubes = amount;
                    } else if (Objects.equals(color, BLUE) && amount > blueCubes) {
                        blueCubes = amount;
                    }
                }
            }

            ret.add(new Game(gameId, redCubes, greenCubes, blueCubes));
        });

        return ret;
    }

}
