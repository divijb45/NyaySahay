
package com.example.protestresources.utils;

import android.content.Context;

import com.example.protestresources.model.Volunteer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VolunteerCsvLoader {

    public static List<Volunteer> loadVolunteers(Context context) {

        List<Volunteer> volunteers
                = new ArrayList<>();

        try {

            InputStream inputStream =
                    context.getAssets().open("volunteers/volunteers.csv");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(inputStream));

            // Skip header row
            reader.readLine();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",", -1);

                if (parts.length >= 4) {

                    volunteers.add(new Volunteer(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim()
                    ));

                }

            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return volunteers;
    }

}