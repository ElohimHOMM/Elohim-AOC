package de.elohim.aoc2023.day05;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AlmanachMapEntry {
    private BigInteger destinationRangeStart;
    private BigInteger sourceRangeStart;
    private BigInteger rangeLength;
}
