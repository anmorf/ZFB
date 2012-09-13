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
public class FileControl implements Initializable {

    private RootModel rootModel = RootModel.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    private void addMouseEvents(final PieChart.Data data) {
        final Node node = data.getNode();

        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                String name = data.getName();
                File currentDirectory = rootModel.getCurrentDirectory();
                String newFile = currentDirectory.getAbsolutePath() + File.separator + name;
                rootModel.setCurrentDirectory(new File(newFile));
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
