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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 *
 * @author rlo
 */
public class NavigationControl implements Initializable {

    private RootModel rootModel = RootModel.getInstance();
    private File file;
    @FXML
    private Button browseButton;
    @FXML
    private TextField currentUrl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentUrl.textProperty().bindBidirectional(rootModel.currentDirectoryProperty(),
                FileConverter.getInstance());
    }

    public void fireButtonAction() {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        NavigationService.getInstance().changeDirectory(file);
        System.out.println(currentUrl.getText());
    }
}
