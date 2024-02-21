package de.elohim.aoc2023.day04;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Scratchcard {
    List<Integer> winningNumbers;
    List<Integer> scratchedNumbers;
    int amount;
}
