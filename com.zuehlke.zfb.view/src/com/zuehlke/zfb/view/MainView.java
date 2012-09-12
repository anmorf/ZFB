/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.view;

import com.zuehlke.zfb.control.util.FileConverter;
import com.zuehlke.zfb.model.RootModel;
import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author rlo
 */
public class MainView {

    private RootModel rootModel = RootModel.getInstance();

    public void show(Stage primaryStage) throws IOException {
        AnchorPane page = (AnchorPane) FXMLLoader.load(MainView.class.getResource("ZFB.fxml"));
        Scene scene = new Scene(page);
        primaryStage.setScene(scene);
        primaryStage.titleProperty().bindBidirectional(rootModel.currentDirectoryProperty(), FileConverter.getInstance());
        primaryStage.show();
    }
}
