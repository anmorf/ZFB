package com.zuehlke.zfb.model;

import java.io.File;
import javafx.scene.control.TreeItem;

public class TreeModel {

    private final static int MAX_DEPTH = 2;
    private static TreeModel instance;
    private TreeItem<String> root = new TreeItem<>("FileSystems");

    public static TreeModel getInstance() {
        if (instance == null) {
            instance = new TreeModel();
            instance.initialize();
        }
        return instance;
    }

    public void initialize() {
        root.setExpanded(true);
        for (File file : File.listRoots()) {
            addFileNode(file, root, 0);
        }
    }

    private void addFileNode(File parentFile, TreeItem<String> parentNode, int depth) {
        if (depth > MAX_DEPTH || parentFile.getName().equalsIgnoreCase("$Recycle.Bin")) {
            return;
        }
        String name = parentFile.getName();
        if (name.length() <= 0) {
            name = parentFile.toString();
        }
        TreeItem<String> node = new TreeItem<>(name);
        parentNode.getChildren().add(node);

        File[] files = parentFile.listFiles();
        if (files != null) {
            for (File file : files) {
                addFileNode(file, node, depth + 1);
            }
        }
    }

    public TreeItem<String> getRoot() {
        return root;
    }
}
