package com.zuehlke.zfb.model;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

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
        loadFileSystemRoots();
    }

    private void loadFileSystemRoots() {
        for (File file : File.listRoots()) {
            addFileNode(file, root);
        }
    }

    private void addFileNode(File file, TreeItem<String> parentNode) {
        String name = getName(file);
        if (name == null) {
            return;
        }
        TreeItem<String> node = new TreeItem<>(name);
        parentNode.getChildren().add(node);
    }

    public int update(String absolutePath) {
        File file = new File(absolutePath);
        Deque<File> files = new ArrayDeque<>();
        while (file != null) {
            files.push(file);
            file = file.getParentFile();
        }
        root.getChildren().clear();
        System.out.println();
        return updateTree(root, files, 0);

    }

    private int updateTree(TreeItem<String> node, Deque<File> files, int index) {
        // TODO: loadRoots(); and make sure no root is represented twice
        System.out.println(node.getValue() + ": " + index);
        if (files.isEmpty()) {
            return index;
        }
        File file = files.pop();
        String name = getName(file);
        if (name == null) {
            return index;
        }
        TreeItem<String> childNode = new TreeItem<>(name);
        node.getChildren().add(childNode);
        node.setExpanded(true);
        index++;
        if (file.listFiles() == null) {
            return index;
        }
        for (File subFile : file.listFiles()) {
            if (!files.contains(subFile)) {
                name = getName(subFile);
                if (name == null) {
                    continue;
                }
                childNode.getChildren().add(new TreeItem<>(name));
                if (!files.isEmpty()) {
                    index++;
                }
            } else {
                index = updateTree(childNode, files, index);
            }
        }
        return index;
    }

    private String getName(File file) {
        String name = file.getName();
        if (name.equalsIgnoreCase("$Recycle.Bin")) {
            return null;
        }
        if (name.length() <= 0) {
            name = file.getPath();
        }
        return name;
    }

    public TreeItem<String> getRoot() {
        return root;
    }
}
