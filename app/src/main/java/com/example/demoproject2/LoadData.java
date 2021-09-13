package com.example.demoproject2;

import android.app.Activity;

import java.io.IOException;
import java.io.InputStream;

public class LoadData {

    public String loadJsonFromAssets(String file, Activity activity){
        String json = null;
        try {
            InputStream is = activity.getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
