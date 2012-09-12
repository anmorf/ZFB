/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.sun.javafx.scene.control.skin.ListViewSkin;
import com.zuehlke.zfb.model.RootModel;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 *
 * @author bdo
 */
public class StatusBarController implements Initializable {
    private RootModel rootModel = RootModel.getInstance();
    @FXML
    Label label;
    @FXML
    ListView listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populate();
        
        rootModel.currentDirectoryProperty().addListener(new ChangeListener<File>() {
            @Override
            public void changed(ObservableValue<? extends File> ov, File t, File t1) {           
                populate();
            }
        });
    }

    private void populate() {
        File file=rootModel.getCurrentDirectory();
        ObservableList<String> list=FXCollections.observableArrayList();
        
        if (!file.exists()) {
            label.setText(rootModel.getCurrentDirectory().getAbsolutePath() + " is not a valid path");
        } else {
            Date d=new Date(file.lastModified());
            list.add("last modified: "+d);
        
            if (file.isDirectory()) {
                label.setText(rootModel.getCurrentDirectory().getAbsolutePath() + " is a directory");
                list.add("contained files: "+file.listFiles().length);
            } else {
                label.setText(rootModel.getCurrentDirectory().getAbsolutePath() + " is a file");
                list.add("size: "+file.length()/1000+" KB");
            }
        }
        
        listView.setItems(list);
    }
}
