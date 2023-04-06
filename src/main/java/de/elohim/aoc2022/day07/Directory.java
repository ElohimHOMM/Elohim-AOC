package de.elohim.aoc2022.day07;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import lombok.Data;

@Data
public class Directory {
    private boolean isRoot;
    private Directory parent;
    private String name;
    private List<Directory> children;
    private List<File> files;

    private long size = 0;
    
    public Directory(Directory parent, String name, List<String> content) {
        isRoot = parent == null;
        this.parent = parent;
        this.name = name;
        this.children = new ArrayList<>();
        this.files = determineFiles(content);
    }

    private List<File> determineFiles(List<String> content) {
        List<File> ret = new ArrayList<>();
        for (String s : content) {
            if (s.startsWith("dir", 0)) continue;
            ret.add(new File(s));
        }
        return ret;
    }

    public void printTree(int depth) {
        System.out.println(" ".repeat(depth) + "- " + name + " (dir + size=" + size + ")");
        files.forEach(file -> file.printTree(depth + 1));;
        children.forEach(child -> child.printTree(depth + 1));
    }

    public long calculateSize() {
        files.forEach(file -> size += file.getSize());
        children.forEach(child -> size += child.calculateSize());
        return size;
    }

    public long getCombinedSizeUnder(long size) {
        AtomicLong combinedSize = new AtomicLong(this.size <= size ? this.size : 0);
        children.forEach(child -> combinedSize.addAndGet(child.getCombinedSizeUnder(size)));
        return combinedSize.get();
    }

    public long getSmallestPossibleDirectory(long requiredSpace) {
        AtomicLong spd = new AtomicLong(0);
        if(this.size >= requiredSpace) {
            spd.set(this.size);
        } else {
            return 0;
        }
        children.forEach(child -> {
            long val = child.getSmallestPossibleDirectory(requiredSpace);
            if (val < spd.get() && val >= requiredSpace) {
                spd.set(val);
            }
        });
        return spd.get();
    }
}
