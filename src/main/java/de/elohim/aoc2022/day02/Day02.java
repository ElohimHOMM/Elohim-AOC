package de.elohim.aoc2022.day02;

import java.util.List;

import de.elohim.helpers.Parser;

public class Day02 {
    
    private static void partOne(List<String> input) {
        int myScore = 0;
        for (String line : input) {
            int me = getNumber(line.strip().toCharArray()[2]);
            int en = getNumber(line.strip().toCharArray()[0]);
            myScore += computePoints(me, en);
        }
        System.out.println("My score using XYZ as Rock, Paper, Scissors: " + myScore);
    }

    private static void partTwo(List<String> input) {
        int myScore = 0;
        for (String line : input) {
            line = line.strip();
            int en = getNumber(line.toCharArray()[0]);
            int me = getCorrespondingNumber(en, line.toCharArray()[2]);
            myScore += computePoints(me, en);
        }
        System.out.println("My score using XYZ as Lose, Draw, Win: " + myScore);
    }

    private static int getNumber(char letter) {
        if (letter == 'A' || letter == 'X') {
            return 1;
        } else if (letter == 'B' || letter == 'Y') {
            return 2;
        } else {
            return 3;
        }
    }

    private static int getCorrespondingNumber(int en, char lMe) {
        if (lMe == 'Y') {
            return en;
        } else if (lMe == 'X') {
            return ((((en + 1) % 3) + 3) % 3) + 1;
        } else {
            return (((en % 3) + 3) % 3) + 1;
        }
    }

    private static int computePoints(int me, int en) {
        int computation = (((en - me) % 3) + 3) % 3;
        switch (computation) {
            case 0:
                return 3 + me;
            case 1:
                return 0 + me;
            case 2:
                return 6 + me;
            default:
                throw new RuntimeException("This should never be able to happen");
        }
    }

    public static void main(String[] args) {
        List<String> input = Parser.readFile("2022", "02");
        partOne(input);
        partTwo(input);
    }

}
