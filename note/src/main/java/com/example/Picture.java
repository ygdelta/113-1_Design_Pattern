package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Picture {
    private String path;
    private Map<String, String> metadata;

    public Picture(String path) throws FileNotFoundException {
        this.path = path;
        this.metadata = new HashMap<>();
        FileInputStream is = new FileInputStream(new File(this.path));
    }

    private void loadImageData() throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File(this.path));
        PngReader pngReader = new PngReader(is);
        ImageInfo imgInfo = pngReader.imgInfo;
        for (int r = 0; r < imgInfo.rows; r++) {
            for (int c = 0; c < imgInfo.columns; c++) {

            }
        }

    }
}
