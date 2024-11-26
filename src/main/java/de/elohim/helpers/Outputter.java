package de.elohim.helpers;

public class Outputter {
    private static final int LINE_LENGTH = 55;
    
    public static void startingLines(String year) {
        System.out.println("┌─────────────────────────────────────────────────────┐");
        System.out.println("|                 ADVENT OF CODE 2022                 |");
        System.out.println("|                      BY ELOHIM                      |");
    }

    public static void output(String day, String partOne, String partTwo) {
        System.out.println("├─────────────────────────────────────────────────────┤");
        System.out.println(padStringRight("| " + day));
        System.out.println(padStringRight("| Part One: " + partOne));
        System.out.println(padStringRight("| Part Two: " + partTwo));
        System.out.println(padStringRight("|"));
    }

    public static void endingLines(String time) {
        System.out.println("├─────────────────────────────────────────────────────┤");
        System.out.println("|                     THANKS FOR CHECKING OUT MY CODE |");
        System.out.println(padStringLeft("Performance: " + time + "ms |"));
        System.out.println("└─────────────────────────────────────────────────────┘");
    }

    private static String padStringRight(String line) {
        while (line.length() < LINE_LENGTH - 2) {
            line += " ";
        }
        line += " |";
        return line;
    }

    private static String padStringLeft(String line) {
        while (line.length() < LINE_LENGTH - 2) {
            line = " " + line;
        }
        line = "| " + line;
        return line;
    }
}
