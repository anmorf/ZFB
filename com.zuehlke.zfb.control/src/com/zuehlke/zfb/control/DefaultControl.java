package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.RootModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author hem
 */
public class DefaultControl implements Initializable {
    
    private RootModel rootModel = RootModel.getInstance();
    
     public void close(){
        rootModel.getCurrentView().setValue(RootModel.CHART_VIEW);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
