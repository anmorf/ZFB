/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.RootModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;


public class MenuController implements Initializable {
    
    @FXML
    MenuItem help;
    
    private RootModel rootModel = RootModel.getInstance();
    
    public void showHelp(){
        rootModel.getCurrentView().setValue(RootModel.DEFAULT_VIEW);
    }
    public void showSandbox(){
        rootModel.getCurrentView().setValue(RootModel.SANDBOX_VIEW);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
