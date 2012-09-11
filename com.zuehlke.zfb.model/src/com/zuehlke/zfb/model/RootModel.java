/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.model;

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
    private StringProperty currentDirectory = new SimpleStringProperty(System.getProperty("user.home"));

    public StringProperty currentDirectoryProperty() {
        return currentDirectory;
    }

    public final String getCurrentDirectory() {
        return currentDirectory.get();
    }

    public final void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory.set(currentDirectory);
    }
}
