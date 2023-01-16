package de.elohim.aoc2022.day04;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CleanupElf {

    private String descriptor;

    private int start;
    private int end;

    public CleanupElf(String descriptor) {
        this.descriptor = descriptor;
        findStartAndEnd();
    }

    private void findStartAndEnd() {
        start = Integer.parseInt(descriptor.split("-")[0]);
        end = Integer.parseInt(descriptor.split("-")[1]);
    }
}