package com.example.guesstheceleb.game;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

public class CelebrityManager {
    private String assetPath;
    private String[] imageNames;
    private AssetManager assetManager;


    public CelebrityManager(AssetManager assetManager, String assetPath) {
        this.assetPath = assetPath;
        this.assetManager = assetManager;
        try {
            imageNames = assetManager.list(assetPath);
        } catch (IOException e) {
            imageNames = null;
        }
    }

    public Bitmap get(int i) {
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

    public String getName(int i) {
        if (imageNames != null && i >= 0 && i < imageNames.length) {
            String imageName = imageNames[i];
            int dotIndex = imageName.lastIndexOf('.');
            if (dotIndex >= 0) {
                return imageName.substring(0, dotIndex);
            }
        }
        return null;
    }

    public int count() {
        if (imageNames != null) {
            return imageNames.length;
        }
        return 0;
    }

    public String[] getAllNames() {
        return imageNames; // Assuming imageNames are the celebrity names without extensions
    }

    public Bitmap getByName(String name) {
        String imagePath = assetPath + "/" + name + ".jpg"; // Assuming images are named as "name.jpg"
        InputStream stream = null;
        try {
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
        return null;
    }
}
