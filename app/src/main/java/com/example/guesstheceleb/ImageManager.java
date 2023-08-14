package com.example.guesstheceleb;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class ImageManager {
    private String assetPath;
    private String[] imageNames;
    private AssetManager assetManager;

    ImageManager(AssetManager assetManager, String assetPath) {
        this.assetPath = assetPath;
        this.assetManager = assetManager;
        try {
            imageNames = assetManager.list(assetPath);
        } catch (IOException e) {
            imageNames = null;
        }
    }

    Bitmap get(int i) {
        if (imageNames != null && i >= 0 && i < imageNames.length) {
            InputStream stream = null;
            try {
                String imagePath = assetPath + "/" + imageNames[i];
                stream = assetManager.open(imagePath);
                return BitmapFactory.decodeStream(stream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
