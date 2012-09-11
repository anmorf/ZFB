/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.view;

import com.sun.javaws.Main;
import com.zuehlke.zfb.control.NavigationControl;
import com.zuehlke.zfb.model.ModelLoader;
import com.zuehlke.zfb.model.RootModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rlo
 */
public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        new MainView().show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
