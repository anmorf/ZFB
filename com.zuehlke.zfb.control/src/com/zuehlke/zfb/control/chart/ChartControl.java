/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control.chart;

import com.zuehlke.zfb.model.RootModel;
import java.io.File;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.input.MouseEvent;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author rlo
 */
public class ChartControl implements Initializable, ChangeListener<ObservableList<Data>>{

    private RootModel rootModel = RootModel.getInstance();
    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pieChart.setTitle("Chart Title");
        pieChart.setLegendVisible(true);
        pieChart.dataProperty().bindBidirectional(rootModel.getChartModel().chartDataProperty());

        pieChart.dataProperty().addListener(this);
    }

    @Override
    public void changed(ObservableValue<? extends ObservableList<Data>> ov, ObservableList<Data> t, ObservableList<Data> newData) {
        for (final Data data : newData) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    String name = data.getName();
                    File currentDirectory = rootModel.getCurrentDirectory();
                    String newFile = currentDirectory.getAbsolutePath() + File.separator + name;
                    rootModel.setCurrentDirectory(new File(newFile));
                }
            });
        }
    }

}
