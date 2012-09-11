/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.view;

import com.zuehlke.zfb.control.NavigationControl;
import com.zuehlke.zfb.model.RootModel;
import java.io.IOException;


import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rlo
 */
public class MainView {

    private final RootModel rootModel;
    private final NavigationControl navigationControl;

    public MainView(RootModel rootModel, NavigationControl navigationControl) {
        this.rootModel = rootModel;
        this.navigationControl = navigationControl;
    }

    public void show(Stage primaryStage) throws IOException {
        AnchorPane page = (AnchorPane) FXMLLoader.load(MainView.class.getResource("ZFB.fxml"));
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
}
