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
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;



public class LawyerDirectoryActivity extends AppCompatActivity {

    private void addPriorityContact(
            LinearLayout layout,
            String name,
            String phone) {

        Button button = new Button(this);

        button.setText(name + "\n📞 " + phone);

        button.setAllCaps(false);

        button.setOnClickListener(v -> {

            Intent intent =
                    new Intent(Intent.ACTION_DIAL);

            intent.setData(Uri.parse("tel:" + phone));

            startActivity(intent);

        });

        layout.addView(button);

    }

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
        android.widget.EditText editText =
                searchView.findViewById(
                        androidx.appcompat.R.id.search_src_text);

        editText.setTextColor(android.graphics.Color.BLACK);
        editText.setHintTextColor(android.graphics.Color.DKGRAY);
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
        LinearLayout priorityLayout =
                findViewById(R.id.priorityLayout);

        if (state.equalsIgnoreCase("NCR")) {

            priorityLayout.setVisibility(View.VISIBLE);

            addPriorityContact(
                    priorityLayout,
                    "PUCL (Vertika Tripathi)",
                    "8447673005");

            addPriorityContact(
                    priorityLayout,
                    "AILAJ (Manik)",
                    "9354231296");

        }

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