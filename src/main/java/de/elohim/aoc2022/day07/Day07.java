package de.elohim.aoc2022.day07;

import java.util.List;

import de.elohim.helpers.Outputter;
import de.elohim.helpers.Parser;

public class Day07 {

    private static final String name = "Day 7: No Space Left On Device";
    private static final String CHANGE_DIRECTORY = "$ cd ";
    private static final String LIST = "$ ls";

    private Directory root;

    public Day07() {
        List<String> input = Parser.readFile("2022", "07");
        buildTree(input);
        root.calculateSize();
        // root.printTree(0); // This line outputs the input as a tree
        Outputter.output(name, "" + root.getCombinedSizeUnder(100000), "" + root.getSmallestPossibleDirectory(30000000 - (70000000 - root.getSize())));
    }

    private void buildTree(List<String> input) {
        // root = new Directory(null, "/", input)
        int counter = 0;

        Directory lastDirectory = null;

        while (counter < input.size()) {
            String directoryName = "this string should never be left here";

            if (input.get(counter).startsWith(CHANGE_DIRECTORY + "..")) {
                // Go up one Directory
                lastDirectory = lastDirectory.getParent();
                counter++;
                continue;
            }
            if (input.get(counter).startsWith(CHANGE_DIRECTORY)) { 
                // First Line navigates to Directory
                directoryName = input.get(counter).replace(CHANGE_DIRECTORY, "");
            }
            if (input.get(counter + 1).startsWith(LIST)) {
                // Input follows count til next $ sign and create Directory
                int subcounter;
                for (subcounter = 0; subcounter < input.size(); subcounter++) {
                    if (counter + 2 + subcounter >= input.size() || input.get(counter + 2 + subcounter).startsWith("$")) {
                        break;
                    }
                }
                List<String> sublist = input.subList(counter + 2, counter + 2 + subcounter);
                Directory directory = new Directory(lastDirectory, directoryName, sublist);
                if (counter == 0) {
                    root = directory;
                }
                lastDirectory = directory;
                if (directory.getParent() != null) {
                    directory.getParent().getChildren().add(directory);
                }
                counter += subcounter + 2;
            }
        }
    }
}
