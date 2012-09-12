/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control.chart;

import com.zuehlke.zfb.model.RootModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 *
 * @author rlo
 */
public class ChartControl implements Initializable {

    private RootModel rootModel = RootModel.getInstance();
    
    @FXML
    private PieChart pieChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pieChart.dataProperty().bindBidirectional(rootModel.getChartModel().chartDataProperty());
        pieChart.setTitle("Monthly Record");
    }
}
