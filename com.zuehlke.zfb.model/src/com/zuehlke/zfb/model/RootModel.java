/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.model;

import java.io.File;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author rlo
 */
public class RootModel {

    private static RootModel instance;

    public static RootModel getInstance() {
        if (instance == null) {
            instance = new RootModel();
        }
        return instance;
    }
    private ObjectProperty<File> currentDirectory = new SimpleObjectProperty<File>(new File(System.getProperty("user.home")));

    public ObjectProperty<File> currentDirectoryProperty() {
        return currentDirectory;
    }

    public final File getCurrentDirectory() {
        return currentDirectory.get();
    }

    public final void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory.set(currentDirectory);
    }
}
