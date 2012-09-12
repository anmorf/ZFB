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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author rlo
 */
public class ContentControl implements Initializable {

    private RootModel rootModel = RootModel.getInstance();
    
    @FXML
    private BorderPane content;
    

    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL u1 = getClass().getResource("/com/zuehlke/zfb/view/chartview/chartView.fxml");
            Object obj = FXMLLoader.load(u1);
            Node node = (Node) obj;
            content.centerProperty().setValue(node);
        } catch (IOException ex) {
            Logger.getLogger(ContentControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
