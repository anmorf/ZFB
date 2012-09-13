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
import javafx.scene.control.Label;

/**
 *
 * @author asw
 */
public class SearchControl implements Initializable {

    @FXML
    Label searchLabel;
    private RootModel rootModel = RootModel.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        searchLabel.setText(rootModel.getSearchText().getValue());
    }

    public void close() {
        rootModel.getCurrentView().setValue(RootModel.CHART_VIEW);
    }
}