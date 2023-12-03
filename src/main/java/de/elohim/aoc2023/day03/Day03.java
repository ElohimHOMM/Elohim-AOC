package de.elohim.aoc2023.day03;

import java.util.ArrayList;
import java.util.List;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day03 {
    private static final String name = "Day 3: Gear Ratios";

    private final int lines;
    private final int lineLength;

    private static final String NUMBERS = "1234567890";
    private static final String SYMBOLS = "*#+&@-/$=%";
    private static final char GEAR = '*';

    public Day03() {
        char[][] input = makeTwoDCharArray(Parser.readFile("2023", "03"));
        lines = input.length;
        lineLength = input[0].length;
        Outputter.output(name, partOne(input), partTwo(input));
    }

    private String partOne(char[][] input) {
        int sum = 0;
        String number = "";

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lineLength; j++) {
                char c = input[i][j];
                if (c == '.' || SYMBOLS.indexOf(c) != -1) {
                    if (number == "") continue;
                    if (validateNumber(input, i, j - 1, SYMBOLS)) sum += Integer.parseInt(number);
                    number = "";
                }
                if (NUMBERS.indexOf(c) != -1) {
                    number += c;
                }
            }
            if (number != "") {
                if (validateNumber(input, i, lineLength - 1, SYMBOLS)) sum += Integer.parseInt(number);
                number = "";
            }
        }
        return sum + "";
    }

    private boolean validateNumber(char[][] input, int x, int y, String checkString) {
        if (y + 1 < lineLength) {
            if (x - 1 > -1) if (checkString.indexOf(input[x - 1][y + 1]) > -1) return true;
            if (checkString.indexOf(input[x][y + 1]) > - 1) return true;
            if (x + 1 < lines) if (checkString.indexOf(input[x + 1][y + 1]) > -1) return true;
        } 
        if (x - 1 > -1) if (checkString.indexOf(input[x - 1][y]) > -1) return true;
        if (x + 1 < lines) if (checkString.indexOf(input[x + 1][y]) > -1) return true;
        while (y - 1 > -1 && checkString.indexOf(input[x][y - 1]) > -1) {
            y -= 1;
            if (x - 1 > -1) if (checkString.indexOf(input[x - 1][y]) > -1) return true;
            if (x + 1 < lines) if (checkString.indexOf(input[x + 1][y]) > -1) return true;
        }
        if (y - 1 > -1) {
            if (x - 1 > -1) if (checkString.indexOf(input[x - 1][y - 1]) > -1) return true;
            if (checkString.indexOf(input[x][y - 1]) > - 1) return true;
            if (x + 1 < lines) if (checkString.indexOf(input[x + 1][y - 1]) > -1) return true;
        }
        return false;
    }

    private String partTwo(char[][] input) {
        int sum = 0;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < lineLength; j++) {
                if (input[i][j] == GEAR) {
                    sum += gearSum(input, i, j);
                }                
            }
        }
        return sum + "";
    }

    private int gearSum(char[][] input, int x, int y) {
        List<Coordinate> coordinates = new ArrayList<>();

        if (x - 1 > -1) {
            int xCo = x - 1;
            int x1 = -1, x2, x3 = -1;
            if (y - 1 > - 1) x1 = NUMBERS.indexOf(input[xCo][y - 1]);
            x2 = NUMBERS.indexOf(input[xCo][y]);
            if (y + 1 < lines) x3 = NUMBERS.indexOf(input[xCo][y + 1]);

            // binary table for number amount
            if (x1 == -1 && x2 == -1 && x3 == -1) {
                
            } else if (x1 > -1 && x2 > -1 && x3 > -1) {
                coordinates.add(new Coordinate(xCo, y - 1));
            } else if (x1 > -1 && x2 == -1 && x3 > -1) {
                coordinates.add(new Coordinate(xCo, y - 1));
                coordinates.add(new Coordinate(xCo, y + 1));
            } else if (x1 > -1 && x2 == -1 && x3 == -1) {
                coordinates.add(new Coordinate(xCo, y - 1));
            } else if (x1 == -1 && x2 == -1 && x3 > -1) {
                coordinates.add(new Coordinate(xCo, y + 1));
            } else if ((x1 == -1 && x2 > -1 && x3 > -1) || (x1 > -1 && x2 > -1 && x3 == -1) || (x1 == -1 && x2 > -1 && x3 == -1)) {
                coordinates.add(new Coordinate(xCo, y));
            } 
        }
        
        if (y - 1 > - 1 && NUMBERS.indexOf(input[x][y - 1]) > -1) coordinates.add(new Coordinate(x, y - 1));
        if (y + 1 < lines && NUMBERS.indexOf(input[x][y + 1]) > - 1) coordinates.add(new Coordinate(x, y + 1));
        
        if (x + 1 < lines) {
            int xCo = x + 1;
            int x1 = -1, x2, x3 = -1;
            if (y - 1 > - 1) x1 = NUMBERS.indexOf(input[x + 1][y - 1]);
            x2 = NUMBERS.indexOf(input[x + 1][y]);
            if (y + 1 < lines) x3 = NUMBERS.indexOf(input[x + 1][y + 1]);

            // binary table for number amount
            if (x1 == -1 && x2 == -1 && x3 == -1) {
                
            } else if (x1 > -1 && x2 > -1 && x3 > -1) {
                coordinates.add(new Coordinate(xCo, y - 1));
            } else if (x1 > -1 && x2 == -1 && x3 > -1) {
                coordinates.add(new Coordinate(xCo, y - 1));
                coordinates.add(new Coordinate(xCo, y + 1));
            } else if (x1 > -1 && x2 == -1 && x3 == -1) {
                coordinates.add(new Coordinate(xCo, y - 1));
            } else if (x1 == -1 && x2 == -1 && x3 > -1) {
                coordinates.add(new Coordinate(xCo, y + 1));
            } else if ((x1 == -1 && x2 > -1 && x3 > -1) || (x1 > -1 && x2 > -1 && x3 == -1) || (x1 == -1 && x2 > -1 && x3 == -1)) {
                coordinates.add(new Coordinate(xCo, y));
            }
        }

        if (coordinates.size() != 2) return 0;
        return gearProduct(input, coordinates);
    }

    public int gearProduct(char[][]input, List<Coordinate> numbers) {
        int x = numbers.get(0).getX();
        int y = numbers.get(0).getY();
        String number = input[x][y] + "";

        int yCopy = y;
        while (yCopy - 1 > -1 && NUMBERS.indexOf(input[x][yCopy - 1]) > - 1) {
            yCopy = yCopy - 1;
            number = input[x][yCopy] + number;
        }
        yCopy = y;
        while (yCopy + 1 < lineLength && NUMBERS.indexOf(input[x][yCopy + 1]) > - 1) {
            yCopy = yCopy + 1;
            number = number + input[x][yCopy];
        }

        int product = Integer.parseInt(number);

        x = numbers.get(1).getX();
        y = numbers.get(1).getY();
        number = input[x][y] + "";
        
        yCopy = y;
        while (yCopy - 1 > -1 && NUMBERS.indexOf(input[x][yCopy - 1]) > - 1) {
            yCopy = yCopy - 1;
            number = input[x][yCopy] + number;
        }
        yCopy = y;
        while (yCopy + 1 < lineLength && NUMBERS.indexOf(input[x][yCopy + 1]) > - 1) {
            yCopy = yCopy + 1;
            number = number + input[x][yCopy];
        }

        product *= Integer.parseInt(number);

        return product;
    }

    public char[][] makeTwoDCharArray(List<String> input) {
        char[][] ret = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            ret[i] = input.get(i).toCharArray();
        }
        return ret;
    }
    
}
