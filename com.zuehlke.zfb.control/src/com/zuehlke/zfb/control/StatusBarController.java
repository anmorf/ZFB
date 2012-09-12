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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author bdo
 */
public class StatusBarController implements Initializable {

    private RootModel rootModel = RootModel.getInstance();
    @FXML
    Label imageUrl;
    @FXML
    ListView listView;
    @FXML
    ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populate(rootModel.getCurrentDirectory());
        rootModel.currentDirectoryProperty().addListener(new ChangeListener<File>() {
            @Override
            public void changed(ObservableValue<? extends File> ov, File t, File t1) {
                populate(t1);
            }
        });
    }

    private void populate(File file) {
        ObservableList<String> list = FXCollections.observableArrayList();

        if (file == null || !file.exists()) {
            imageView.setImage(null);
        } else {
            Date d = new Date(file.lastModified());
            list.add("last modified: " + d);

            if (file.isDirectory()) {
                imageView.setImage(new Image("com/zuehlke/zfb/view/folder.png"));
                list.add("contained files: " + (file.listFiles() != null ? +file.listFiles().length : 0));
            } else {
                imageView.setImage(new Image("com/zuehlke/zfb/view/file.png"));
                list.add("size: " + file.length() / 1000 + " KB");
            }
        }

        listView.setItems(list);
    }
}
