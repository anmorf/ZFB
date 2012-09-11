/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.ModelLoader;
import com.zuehlke.zfb.model.RootModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author rlo
 */
public class NavigationControl implements Initializable {
    
    private RootModel rootModel;
    
    @FXML
    TextField urlTextField;
    
    public void changeDirectory(String gugus) {
        this.rootModel.setCurrentDirectory(gugus);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rootModel = ModelLoader.getInstance().getRootModel();
        urlTextField.setText("blabla");
    }
    
    

}
