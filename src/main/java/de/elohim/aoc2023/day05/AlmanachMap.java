package de.elohim.aoc2023.day05;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AlmanachMap {
    List<AlmanachMapEntry> mapEntries = new ArrayList<>();

    private final String source;
    private final String destination;

    public void addEntry(AlmanachMapEntry mapEntry) {
        mapEntries.add(mapEntry);
    }

    public BigInteger getDestinationByNumber(BigInteger number) {
        for(AlmanachMapEntry entry : mapEntries) {
            if (entry.keys(number)) {
                return entry.revalue(number);
            }
        }
        return number;
    }
}
