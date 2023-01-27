package de.elohim.helpers;

public class Outputter {
    private static final int LINE_LENGTH = 55;
    
    public static void startingLines(String year) {
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.println("|                 ADVENT OF CODE 2022                 |");
        System.out.println("|                      BY ELOHIM                      |");
    }

    public static void endingLines() {
        System.out.println("├─────────────────────────────────────────────────────┤");
        System.out.println("|                     THANKS FOR CHECKING OUT MY CODE |");
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    public static void output(String day, String partOne, String partTwo) {
        System.out.println("├─────────────────────────────────────────────────────┤");
        System.out.println(padString("| " + day));
        System.out.println(padString("| Part One: " + partOne));
        System.out.println(padString("| Part Two: " + partTwo));
        System.out.println(padString("|"));
    }

    private static String padString(String line) {
        while (line.length() < LINE_LENGTH - 2) {
            line += " ";
        }
        line += " |";
        return line;
    }
}
