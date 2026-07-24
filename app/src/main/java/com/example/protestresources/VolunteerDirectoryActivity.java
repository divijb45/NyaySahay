package com.example.protestresources;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protestresources.adapters.VolunteerAdapter;
import com.example.protestresources.model.Volunteer;
import com.example.protestresources.utils.VolunteerCsvLoader;

import java.util.List;

public class VolunteerDirectoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private TextView stateTitle;

    private VolunteerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_directory);

        recyclerView = findViewById(R.id.volunteerRecycler);
        searchView = findViewById(R.id.searchView);
        android.widget.EditText editText =
                searchView.findViewById(
                        androidx.appcompat.R.id.search_src_text);

        editText.setTextColor(android.graphics.Color.BLACK);
        editText.setHintTextColor(android.graphics.Color.DKGRAY);
        stateTitle = findViewById(R.id.stateTitle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        stateTitle.setText("Legal Volunteers");

        List<Volunteer> volunteers =
                VolunteerCsvLoader.loadVolunteers(this);

        adapter = new VolunteerAdapter(this, volunteers);

        recyclerView.setAdapter(adapter);

        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                adapter.filter(query);
                return true;

            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.filter(newText);
                return true;

            }

        });

    }

}