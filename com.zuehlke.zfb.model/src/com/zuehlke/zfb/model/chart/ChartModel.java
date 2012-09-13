/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.model.chart;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

/**
 *
 * @author rlo
 */
public class ChartModel implements ChangeListener<File> {
    private static final int MAX_NAME_LENGTH = 15;

    private final ObjectProperty<File> currentDirectory;
    private final ObjectProperty<ObservableList<Data>> chartData;
    private final Map<Data, File> mapModel = new HashMap<>();

    public ChartModel(final ObjectProperty<File> currentDirectory) {
        this.currentDirectory = currentDirectory;
        this.chartData = new SimpleObjectProperty<>();
        this.currentDirectory.addListener(this);
        this.changed(null, null, currentDirectory.get());
    }

    public ObservableList<Data> getChartData() {
        return chartData.get();
    }

    public void setChartData(ObservableList<Data> chartData) {
        this.chartData.set(chartData);
    }

    public ObjectProperty<ObservableList<Data>> chartDataProperty() {
        return chartData;
    }

    @Override
    public void changed(ObservableValue<? extends File> ov, File oldValue, File newValue) {
        if (newValue != null) {
            File[] listFiles = newValue.listFiles();
            this.mapModel.clear();
            ObservableList<PieChart.Data> chartDatas = FXCollections.observableArrayList();
            if (listFiles != null) {
                for (final File file : listFiles) {
                    Data data = new Data(getFileName(file), file.getName().length());
                    mapModel.put(data, file);
                    chartDatas.add(data);
                }
            }
            chartData.set(chartDatas);
        }
    }

    public Map<Data, File> getMapModel() {
        return mapModel;
    }

    private String getFileName(final File file) {
        String name = file.getName();
        if (name.length() > MAX_NAME_LENGTH) {
            return name.substring(0, MAX_NAME_LENGTH) + "...";
        }
        return name;
    }
}
