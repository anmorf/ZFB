/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.view;

import com.zuehlke.zfb.control.NavigationControl;
import com.zuehlke.zfb.model.RootModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rlo
 */
public class MainView extends Application {

    private final RootModel rootModel;
    private final NavigationControl navigationControl;

    public MainView(RootModel rootModel, NavigationControl navigationControl) {
        this.rootModel = rootModel;
        this.navigationControl = navigationControl;
    }

    @Override
    public void start(Stage primaryStage) {
        RootModel rootModel = new RootModel();
        NavigationControl navigationControl = new NavigationControl(rootModel);
        MainView mainView = new MainView(rootModel, navigationControl);

        mainView.show(primaryStage);
    }

    private void show(Stage primaryStage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
