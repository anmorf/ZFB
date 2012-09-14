/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.control.util.FileSearchTask;
import com.zuehlke.zfb.model.RootModel;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startTask();
        rootModel.getSearchText().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                startTask();
            }          
        });
        
        fileListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            String url=fileListView.getSelectionModel().getSelectedItem().toString();
            rootModel.setCurrentDirectory(new File(url));
        }
    });
    }
    
    public void startTask(){
        FileSearchTask task = new FileSearchTask(rootModel.getSearchText().getValue(), rootModel.getCurrentDirectory().toPath());
        fileListView.setItems(task.getPartialResults());
        progressIndicator.setVisible(true);
        new Thread(task).start();
        task.setOnFailed(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                progressIndicator.setVisible(false);
            }
        });
        task.setOnCancelled(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                progressIndicator.setVisible(false);
            }
        });
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent t) {
                progressIndicator.setVisible(false);
            }
        });
    }

    public void close() {
        rootModel.getCurrentView().setValue(RootModel.CHART_VIEW);
    }
}
