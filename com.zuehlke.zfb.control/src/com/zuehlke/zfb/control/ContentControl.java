/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.RootModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author rlo
 */
public class ContentControl implements Initializable,  ChangeListener<String>  {

    private RootModel rootModel = RootModel.getInstance();
    
    @FXML
    private BorderPane content;

    private void loadContent(String centerContent) {
        try {
            content.centerProperty().set(null);
            Node node = (Node) FXMLLoader.load(getClass().getResource(centerContent));
            content.centerProperty().setValue(node);
        } catch (IOException ex) {
            Logger.getLogger(ContentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void onload() {
        ProgressIndicator progress = new ProgressIndicator();
        Pane topPane = (Pane) content.topProperty().get();
        topPane.getChildren().add(progress);
        progress.setProgress(-1d);
    }
    
    private void stopload(){
        Pane topPane = (Pane) content.topProperty().get();
        topPane.getChildren().clear();
    }

    private void onloading() {
        Node oldNode = content.centerProperty().get();
        ProgressIndicator progress = new ProgressIndicator();
        content.centerProperty().set(progress);
        progress.setProgress(-1d);
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException ex) {
            Logger.getLogger(ContentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        progress.setProgress(1.1d);
        content.centerProperty().setValue(oldNode);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pane topPane = new Pane();
        content.topProperty().set(topPane);
        content.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        onload();
                    }
                });
        content.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        stopload();
                    }
                });
           loadContent(rootModel.getCurrentView().get());
           rootModel.getCurrentView().addListener(this);
    }

    @Override
    public void changed(ObservableValue<? extends String> ov, String t, String t1) {
        loadContent(t1);
    }
}
