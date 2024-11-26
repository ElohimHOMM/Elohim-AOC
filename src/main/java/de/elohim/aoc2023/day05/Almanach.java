package de.elohim.aoc2023.day05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Almanach {
    List<AlmanachMap> almanachMaps = new ArrayList<>();
    List<BigInteger> seeds = new ArrayList<>();

    public void addMap(AlmanachMap almanachMap) {
        almanachMaps.add(almanachMap);
    }

    public void addSeed(BigInteger seed) {
        seeds.add(seed);
    }
}
