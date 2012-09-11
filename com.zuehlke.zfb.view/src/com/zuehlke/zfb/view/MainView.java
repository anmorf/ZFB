/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.view;

import com.zuehlke.zfb.control.NavigationControl;
import com.zuehlke.zfb.model.RootModel;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
        Label label = new Label(null);
        label.textProperty().bindBidirectional(rootModel.currentDirectoryProperty());
        
        label.addEventHandler(MouseEvent.MOUSE_PRESSED,  new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
               navigationControl.changeDirectory("gugus");
             }
        });
        
        
        StackPane root = new StackPane();
        root.getChildren().add(label);
        
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
