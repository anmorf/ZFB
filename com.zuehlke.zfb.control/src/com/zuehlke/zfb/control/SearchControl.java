/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.control.util.FileFinder;
import com.zuehlke.zfb.control.util.FileSearchTask;
import com.zuehlke.zfb.model.RootModel;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;

/**
 *
 * @author asw
 */
public class SearchControl implements Initializable {

    @FXML
    Label searchLabel;
    @FXML
    ListView fileListView;
    @FXML
    ProgressIndicator progressIndicator;
    private RootModel rootModel = RootModel.getInstance();
    private ObservableList<String> foundFiles = FXCollections.observableArrayList();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        //fileListView.setItems(foundFiles);
   
//        Task task = new Task<Void>() {
//            @Override
//            public Void call() {
//                try {
//                    FileFinder finder = new FileFinder(rootModel.getSearchText().getValue(), foundFiles);
//                    Files.walkFileTree(rootModel.getCurrentDirectory().toPath(), finder);
//                    //progressIndicator.setVisible(false);
//                    //fileListView.setItems(foundFiles);
//                    
//                } catch (Exception e) {
//                    System.out.println("Exception: "+e.getMessage()+"\n"+e.getStackTrace().toString());
//                }
//                return null;               
//            }
//        };
        FileSearchTask task=new FileSearchTask(rootModel.getSearchText().getValue(), rootModel.getCurrentDirectory().toPath());
        fileListView.setItems(task.getPartialResults());
        new Thread(task).start(); 
    }

    public void close() {
        rootModel.getCurrentView().setValue(RootModel.CHART_VIEW);
    }
    
    
 
}
