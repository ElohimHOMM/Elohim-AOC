package de.elohim.aoc2023.day05;

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
}
