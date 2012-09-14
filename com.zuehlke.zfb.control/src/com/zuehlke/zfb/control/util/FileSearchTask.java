package com.zuehlke.zfb.control.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.shape.Rectangle;

public class FileSearchTask extends Task<ObservableList<String>> {
    // Uses Java 7 diamond operator

    private ReadOnlyObjectWrapper<ObservableList<String>> partialResults = new ReadOnlyObjectWrapper<ObservableList<String>>(this, "partialResults", FXCollections.observableArrayList(new ArrayList()));
    private String searchText;
    private Path directory;

    public FileSearchTask(String searchText, Path directory) {
        this.searchText = searchText;
        this.directory = directory;
    }

    public final ObservableList getPartialResults() {
        return (ObservableList) partialResults.get();
    }

    public final ReadOnlyObjectProperty partialResultsProperty() {
        return partialResults.getReadOnlyProperty();
    }

    @Override
    protected ObservableList call() throws Exception {
        FileFinder finder = new FileFinder(searchText, partialResults);
        Files.walkFileTree(directory, finder);
        return (ObservableList) partialResults.get();
    }
}