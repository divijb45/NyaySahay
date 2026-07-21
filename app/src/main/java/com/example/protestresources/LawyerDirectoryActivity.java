package com.example.protestresources;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protestresources.adapters.LawyerAdapter;
import com.example.protestresources.model.Lawyer;
import com.example.protestresources.utils.CsvLoader;

import java.util.List;

public class LawyerDirectoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private TextView stateTitle;

    private LawyerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_directory);

        recyclerView = findViewById(R.id.lawyerRecycler);
        searchView = findViewById(R.id.searchView);
        stateTitle = findViewById(R.id.stateTitle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String state = getIntent().getStringExtra("state");
        String file = getIntent().getStringExtra("file");

        android.util.Log.d("LAWYERS", "Opening file: " + file);

        if (state == null)
            state = "Legal Aid Directory";

        if (file == null)
            file = "maharashtra.csv";

        stateTitle.setText(state);

        List<Lawyer> lawyers = CsvLoader.loadLawyers(this, file);
        android.util.Log.d("LAWYERS", "Loaded " + lawyers.size() + " lawyers");

        adapter = new LawyerAdapter(this, lawyers);

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