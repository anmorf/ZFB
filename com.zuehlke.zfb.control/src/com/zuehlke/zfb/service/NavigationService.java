/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.service;

import com.zuehlke.zfb.model.RootModel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author rlo
 */
public class NavigationService {

    private static NavigationService instance = new NavigationService();

    public static NavigationService getInstance() {
        return instance;
    }

    private NavigationService() {
    }

    public void changeDirectory(File directory) {
        if (directory != null && directory.isFile()) {

            if (directory.isFile()) {
                try {
                    Desktop.getDesktop().open(directory);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


        }

        RootModel rootModel = RootModel.getInstance();
        rootModel.setCurrentDirectory(directory);

    }
}
