/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.control.util.FileConverter;
import com.zuehlke.zfb.model.RootModel;
import com.zuehlke.zfb.service.NavigationService;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;

/**
 *
 * @author rlo
 */
public class NavigationControl implements Initializable {

    private RootModel rootModel = RootModel.getInstance();
    private File file;
    @FXML
    private TextField currentUrl;
    @FXML private TextField searchField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUrl.textProperty().bindBidirectional(rootModel.currentDirectoryProperty(),
                FileConverter.getInstance());
        
        // add the drag-drop functionality
        currentUrl.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != currentUrl
                        && event.getDragboard().hasString()) {
                    Reflection r = new Reflection();
                    r.setFraction(0.9);

                    currentUrl.setEffect(r);
                }

                event.consume();
            }
        });
        currentUrl.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                 if (event.getGestureSource() != currentUrl &&
                         event.getDragboard().hasString()) { 
                    Reflection r = new Reflection();
                    r.setFraction(0);

                    currentUrl.setEffect(r);
                 }

                 event.consume();
            }
        });
        currentUrl.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != currentUrl
                        && event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });
        currentUrl.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println("dragdropped");
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    currentUrl.setText(db.getString());
                    file = new File(db.getString());
                    NavigationService.getInstance().changeDirectory(file);
                    success = true;
                }
                event.setDropCompleted(success);

                event.consume();
            }
        });
    }

    public void fireButtonAction() {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        NavigationService.getInstance().changeDirectory(file);
    }
    
    public void searchButtonAction() {
        rootModel.getSearchText().set(searchField.getText());
        rootModel.getCurrentView().setValue(RootModel.SEARCH_VIEW);
    }
}
