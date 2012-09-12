/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.control.util.FileConverter;
import com.zuehlke.zfb.model.RootModel;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

/**
 *
 * @author rlo
 */
public class ContentControl implements Initializable {

    private RootModel rootModel = RootModel.getInstance();
    
    
    @FXML
    private AnchorPane content;
    

    @Override 
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
