package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.RootModel;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author hem
 */
public class DefaultControl implements Initializable {

    private RootModel rootModel = RootModel.getInstance();
    @FXML
    private BorderPane defaultContent;

    public void close() {
        rootModel.getCurrentView().setValue(RootModel.CHART_VIEW);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final ProgressIndicator pi = new ProgressIndicator(0);
        final Node old = defaultContent.centerProperty().get();
        defaultContent.centerProperty().setValue(pi);

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(new Random().nextInt(500));
                    } catch (InterruptedException ex) {
                    }
                    final double progress = i * 0.05;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            pi.setProgress(progress);
                        }
                    });
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        defaultContent.centerProperty().set(old);
                    }
                });
            }
        }.start();
    }
}
