/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.TreeModel;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeView;

/**
 *
 * @author asw
 */
public class TreeControl implements Initializable {

    private TreeModel treeModel = TreeModel.getInstance();
    @FXML
    private TreeView<String> tree;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tree.setRoot(treeModel.getRoot());
    }

}