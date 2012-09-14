package com.zuehlke.zfb.control.util;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FileFinder
        extends SimpleFileVisitor<Path> {

    private ReadOnlyObjectWrapper<ObservableList<String>> files;
    private PathMatcher matcher = null;
    private int numMatches = 0;

    public FileFinder(String pattern, ReadOnlyObjectWrapper<ObservableList<String>> files) {
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        this.files=files;
    }

    // Compares the glob pattern against
    // the file or directory name.
    void find(Path file) {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            numMatches++;
            final String fname=name.toString();
            files.get().add(fname);
            System.out.println(file);
            Platform.runLater(new Runnable() {
                     @Override public void run() {
                         files.get().add(fname);
                     }
            });
        }
    }

    // Prints the total number of
    // matches to standard out.
    public void done() {
        System.out.println("Matched: "
                + numMatches);
    }

    // Invoke the pattern matching
    // method on each file.
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attrs) {
        find(file);
        return CONTINUE;
    }

    // Invoke the pattern matching
    // method on each directory.
    @Override
    public FileVisitResult preVisitDirectory(Path dir,
            BasicFileAttributes attrs) {
        find(dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file,
            IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }
}
