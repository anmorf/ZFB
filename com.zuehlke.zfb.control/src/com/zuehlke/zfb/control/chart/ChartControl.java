/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control.chart;

import com.zuehlke.zfb.model.RootModel;
import com.zuehlke.zfb.service.NavigationService;
import java.io.File;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author rlo
 */
public class ChartControl implements Initializable, ChangeListener<ObservableList<Data>> {

    private RootModel rootModel = RootModel.getInstance();
    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pieChart.dataProperty().addListener(this);
        pieChart.dataProperty().bindBidirectional(rootModel.getChartModel().chartDataProperty());
        pieChart.setTitle("Chart Title");
    }

    @Override
    public void changed(ObservableValue<? extends ObservableList<Data>> ov, ObservableList<Data> t, ObservableList<Data> newData) {
        for (PieChart.Data data : newData) {
            addMouseEvents(data);
        }
    }

    private void addMouseEvents(final PieChart.Data data) {
        final Node node = data.getNode();

        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Map<Data, File> mapModel = rootModel.getChartModel().getMapModel();
                File file = mapModel.get(data);
                String newFile = rootModel.getCurrentDirectory().getAbsolutePath() + File.separator + file.getName();
                NavigationService.getInstance().changeDirectory(new File(newFile));
            }
        });

        node.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                node.setEffect(new Glow());
            }
        });
        node.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                node.setEffect(null);
            }
        });
    }
}
