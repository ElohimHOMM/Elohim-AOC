package de.elohim.aoc2022.day07;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Directory {
    private boolean isRoot;
    private Directory parent;
    private String name;
    private List<Directory> children;
    private List<File> files;
    
    public Directory(Directory parent, String name, List<String> content) {
        isRoot = parent == null;
        this.parent = parent;
        this.name = name;
        files = determineFiles(content);
    }

    private List<File> determineFiles(List<String> content) {
        List<File> ret = new ArrayList<>();
        for (String s : content) {
            if (s.startsWith("dir", 0)) continue;
            ret.add(new File(s));
        }
        return ret;
    }
}
