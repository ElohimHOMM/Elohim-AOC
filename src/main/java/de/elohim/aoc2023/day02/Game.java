package de.elohim.aoc2023.day02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Game {
    private int gameId;
    private int redCubes;
    private int greenCubes;
    private int blueCubes;

    public int isPossible(Game game) {
        if (this.getRedCubes() >= game.getRedCubes() && 
        this.getGreenCubes() >= game.getGreenCubes() && 
        this.getBlueCubes() >= game.getBlueCubes()) {
            return game.gameId;
        }
        return 0;
    }

    public int getPower() {
        return this.getRedCubes() * this.getGreenCubes() * this.getBlueCubes();
    }
}
