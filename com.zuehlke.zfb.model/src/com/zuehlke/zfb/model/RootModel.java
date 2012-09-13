/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.model;

import com.zuehlke.zfb.model.chart.ChartModel;
import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author rlo
 */
public class RootModel {
    
    
    public static final String CHART_VIEW = "/com/zuehlke/zfb/view/chartview/chartView.fxml";
    public static final String DEFAUL_VIEW = "/com/zuehlke/zfb/view/content/default.fxml";
    public static final String SANDBOX_VIEW = "/com/zuehlke/zfb/view/content/sandbox.fxml";
    
    private static RootModel instance;

    public static RootModel getInstance() {
        if (instance == null) {
            instance = new RootModel();
        }
        return instance;
    }
    
    private ObjectProperty<File> currentDirectory;
    private StringProperty currentView;
    
    private ChartModel chartModel;

    public RootModel() {
        currentDirectory = new SimpleObjectProperty<>(new File("C:\\Users"));
        chartModel = new ChartModel(currentDirectory);
        currentView = new SimpleStringProperty(CHART_VIEW);
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

    public StringProperty getCurrentView() {
        return currentView;
    }

    public void setCurrentView(StringProperty currentView) {
        this.currentView = currentView;
    }
}
