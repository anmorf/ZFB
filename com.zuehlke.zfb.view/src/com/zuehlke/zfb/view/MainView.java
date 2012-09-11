/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.view;

import com.zuehlke.zfb.control.NavigationControl;
import com.zuehlke.zfb.model.RootModel;
import javafx.application.Application;
import javafx.scene.Scene;
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

   

    public void show(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
