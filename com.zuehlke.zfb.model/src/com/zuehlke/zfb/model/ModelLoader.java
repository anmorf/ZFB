package com.zuehlke.zfb.model;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.zuehlke.zfb.model.RootModel;

/**
 *
 * @author amo
 */
public class ModelLoader {

    private RootModel rootModel;
    
    private static ModelLoader instance = null;

    public RootModel getRootModel() {
        return rootModel;
    }
    
    public static ModelLoader getInstance() {
        if (instance == null) {
            instance = new ModelLoader();
        }
        return instance;
    }
    
    protected ModelLoader() {
        RootModel rootModel = new RootModel();
    }
}