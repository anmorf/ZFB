/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.model;

import com.zuehlke.zfb.model.chart.ChartModel;
import java.io.File;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

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
    
    private ObjectProperty<File> currentDirectory;
    
    private ChartModel chartModel;

    public RootModel() {
        currentDirectory = new SimpleObjectProperty<>(new File(System.getProperty("user.home")));
        chartModel = new ChartModel(currentDirectory);
    }

    public ObjectProperty<File> currentDirectoryProperty() {
        return currentDirectory;
    }

    public final File getCurrentDirectory() {
        return currentDirectory.get();
    }

    public final void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory.set(currentDirectory);
    }

    public ChartModel getChartModel() {
        return chartModel;
    }

    public void setChartModel(ChartModel chartModel) {
        this.chartModel = chartModel;
    }
}
