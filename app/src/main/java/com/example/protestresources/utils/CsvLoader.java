package com.example.protestresources.utils;

import android.content.Context;

import com.example.protestresources.model.Lawyer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {

    public static List<Lawyer> loadLawyers(Context context, String fileName) {

        List<Lawyer> lawyers = new ArrayList<>();

        try {

            InputStream inputStream =
                    context.getAssets().open("Lawyers/" + fileName);

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(inputStream));

            // Skip header row
            String line;

// Skip everything until we find the real CSV header
            while ((line = reader.readLine()) != null) {

                if (line.toLowerCase().startsWith("name")) {
                    break;
                }

            }

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",", -1);

                if (parts.length >= 3) {

                    lawyers.add(new Lawyer(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim()
                    ));

                }

            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return lawyers;
    }

}