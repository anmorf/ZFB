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
public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) {
        RootModel rootModel = new RootModel();
        NavigationControl navigationControl = new NavigationControl(rootModel);
        MainView mainView = new MainView(rootModel, navigationControl);

        mainView.show(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
