/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zuehlke.zfb.control.util;

import java.io.File;
import javafx.util.StringConverter;

/**
 *
 * @author rlo
 */
public class FileConverter extends StringConverter<File> {

    private static final FileConverter instance = new FileConverter();

    public static FileConverter getInstance() {
        return instance;
    }

    private FileConverter() {
    }

    @Override
    public String toString(File t) {
        return t.getAbsolutePath();
    }

    @Override
    public File fromString(String string) {
        return new File(string);
    }
}
