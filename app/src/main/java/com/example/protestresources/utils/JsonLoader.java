package com.example.protestresources.utils;

import android.content.Context;

import com.example.protestresources.model.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class JsonLoader {

    public static List<Article> loadArticles(Context context, String filename) {

        try {

            InputStream is = context.getAssets().open(filename);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            String json = new String(buffer);

            Type listType = new TypeToken<List<Article>>(){}.getType();

            return new Gson().fromJson(json, listType);

        }

        catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }

}