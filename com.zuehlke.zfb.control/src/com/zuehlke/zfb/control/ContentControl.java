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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
           loadContent(rootModel.getCurrentView().get());
           rootModel.getCurrentView().addListener(this);
    }

    @Override
    public void changed(ObservableValue<? extends String> ov, String t, String t1) {
        loadContent(t1);
    }
}
