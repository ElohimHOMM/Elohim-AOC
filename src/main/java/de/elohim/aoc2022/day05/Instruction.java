package de.elohim.aoc2022.day05;

import lombok.Value;

@Value
public class Instruction {
    int amount;
    int stackFrom;
    int stackTo;
}
