package com.zuehlke.zfb.model;

import java.io.File;
import javafx.scene.control.TreeItem;

public class TreeModel {

    private final static int MAX_DEPTH = 2;
    private static TreeModel instance;
    private TreeItem<String> root = new TreeItem<>("root");

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

    private void addFileNode(File file, TreeItem<String> parentNode, int depth) {
        String name = file.getName();
        if (depth > MAX_DEPTH || name.equalsIgnoreCase("$Recycle.Bin")) {
            return;
        }
        if (name.length() <= 0) {
            name = file.getPath();
        }
        TreeItem<String> node = new TreeItem<>(name);
        parentNode.getChildren().add(node);

        File[] files = file.listFiles();
        if (files != null) {
            for (File subFile : files) {
                addFileNode(subFile, node, depth + 1);
            }
        }
    }

    public TreeItem<String> getRoot() {
        return root;
    }
}
