package com.example.protestresources;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protestresources.adapters.StateAdapter;

import java.util.ArrayList;
import java.util.List;

public class StateSelectionActivity extends AppCompatActivity {

    private StateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_selection);

        RecyclerView recycler = findViewById(R.id.stateRecycler);
        SearchView search = findViewById(R.id.searchView);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        List<String> states = new ArrayList<>();
        List<String> files = new ArrayList<>();

        states.add("Chandigarh");
        files.add("chandigarh.csv");

        states.add("NCR");
        files.add("ncr.csv");

        states.add("Jharkhand");
        files.add("jharkhand.csv");

        states.add("Karnataka");
        files.add("karnataka.csv");

        states.add("Maharashtra");
        files.add("maharashtra.csv");

        states.add("Uttar Pradesh");
        files.add("uttar_pradesh.csv");

        adapter = new StateAdapter(this, states, files);
        recycler.setAdapter(adapter);

        search.clearFocus();

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

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