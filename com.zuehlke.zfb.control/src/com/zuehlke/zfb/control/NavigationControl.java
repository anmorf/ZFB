/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control;

import com.zuehlke.zfb.model.RootModel;

/**
 *
 * @author rlo
 */
public class NavigationControl {
    
    private final RootModel rootModel;
    
    public NavigationControl(RootModel rootModel) {
        this.rootModel = rootModel;
    }
    
    public void changeDirectory(String gugus) {
        this.rootModel.setCurrentDirectory(gugus);
    }
}
