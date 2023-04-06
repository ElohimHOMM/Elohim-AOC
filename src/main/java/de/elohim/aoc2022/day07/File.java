package de.elohim.aoc2022.day07;

import lombok.Value;

@Value
public class File {
    private String name;
    private int size;

    public File(String definition) {
        String[] values = definition.split(" ");
        this.name = values[1];
        this.size = Integer.parseInt(values[0]);
    }

    public void printTree(int depth) {
        System.out.println(" ".repeat(depth) + "- " + name + " (file, size=" + size + ")");
    }
}
