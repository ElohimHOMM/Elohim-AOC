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

    public boolean keys(BigInteger number) {
        return !(number.compareTo(sourceRangeStart) == -1) && 
        !(number.compareTo(sourceRangeStart.add(rangeLength).subtract(BigInteger.valueOf(1))) == 1);
    }

    public BigInteger revalue(BigInteger number) {
        return number.subtract(sourceRangeStart).add(destinationRangeStart);
    }
}
