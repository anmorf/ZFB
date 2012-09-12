/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.RootModel;
import com.zuehlke.zfb.model.TreeModel;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author asw
 */
public class TreeControl implements Initializable {

    @FXML
    private TreeView<String> tree;

    private TreeModel treeModel = TreeModel.getInstance();
    private RootModel rootModel = RootModel.getInstance();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tree.setRoot(treeModel.getRoot());
        tree.setShowRoot(false);
        tree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                rootModel.setCurrentDirectory(new File(getFullPath(tree.getSelectionModel().getSelectedItem())));
            }
        });
    }

    private String getFullPath(TreeItem<String> selectedItem) {
        if (selectedItem.getParent().getValue().equals("root")) {
            return selectedItem.getValue();
        }
        String path = getFullPath(selectedItem.getParent());
        return  path + (path.endsWith(File.separator) ? "" : File.separator) + selectedItem.getValue();
    }
}