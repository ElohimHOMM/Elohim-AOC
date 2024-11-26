package de.elohim.aoc2023.day05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day05 {
    private static final String name = "Day 5: If You Give A Seed A Fertilizer";
    
    private Almanach almanach;

    public Day05() {
        almanach = generateAlmanach(Parser.readFile("2023", "05"));

        Outputter.output(name, partOne(), partTwo());
    }

    private String partOne() {
        List<BigInteger> correlations = new ArrayList<>();
        for (BigInteger seed : almanach.getSeeds()) {
            BigInteger correlation = seed;
            for (AlmanachMap map : almanach.getAlmanachMaps()) {
                correlation = map.getDestinationByNumber(correlation);
            }
            correlations.add(correlation);
        }

        return "" + correlations.stream().min(BigInteger::compareTo).get();
    }

    private String partTwo() {
        return null;
    }

    private Almanach generateAlmanach(List<String> input) {
        Almanach almanach = new Almanach();
        // Line 1 always contains Seeds
        for(String seed : input.get(0).split(": ")[1].split(" ")) {
            almanach.addSeed(BigInteger.valueOf(Long.parseLong(seed)));
        }
        // remove two lines of input to get a clean almanach content input
        input.remove(0);
        input.remove(0);
        AlmanachMap map = new AlmanachMap("", "");
        for(String line : input) {
            if (line.isBlank()) {
                almanach.addMap(map);
                map = null;
            } else if (line.endsWith("map:")) {
                String[] splits = line.split(" ")[0].split("-");
                map = new AlmanachMap(splits[0], splits[2]);
            } else if (line.matches("\\d+ \\d+ \\d+")) {
                String[] splits = line.split(" ");
                map.addEntry(new AlmanachMapEntry(
                    BigInteger.valueOf(Long.parseLong(splits[0])), 
                    BigInteger.valueOf(Long.parseLong(splits[1])), 
                    BigInteger.valueOf(Long.parseLong(splits[2]))));
            } else {
                throw new RuntimeException("This should never happen");
            }
        }
        return almanach;
    }
}