package de.elohim.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    public static List<String> readFile(String year, String day) {
        List<String> ret = new ArrayList<>();
        try {
            File file = new File("src/main/resources/input/aoc" + year + "/" + day + ".txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                ret.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Uh oh, hier ist etwas schief gelaufen");
            fnfe.printStackTrace();
        }
        return ret;
    }

}
