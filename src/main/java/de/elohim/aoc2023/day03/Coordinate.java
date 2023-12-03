package de.elohim.aoc2023.day03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Coordinate {
    int x;
    int y;

    /**
     * + 1 for now to have rows and columns start at 1 for debugging
     */
    @Override
    public String toString() {
        return "x: " + (this.getX() + 1) + 
               " y: " + (this.getY() + 1);
    }
}
