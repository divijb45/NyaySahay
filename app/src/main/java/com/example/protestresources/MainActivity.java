package com.example.protestresources;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    Button rightsButton;
    Button emergencyButton;
    Button legalButton;
    Button firstAidButton;
    Button checklistButton;
    Button sosButton;

    private void openSection(String title, String jsonFile) {

        Intent intent = new Intent(MainActivity.this, ArticleListActivity.class);

        intent.putExtra("title", title);
        intent.putExtra("json", jsonFile);

        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rightsButton = findViewById(R.id.rightsButton);
        emergencyButton = findViewById(R.id.emergencyButton);
        legalButton = findViewById(R.id.legalButton);
        firstAidButton = findViewById(R.id.firstAidButton);
        checklistButton = findViewById(R.id.checklistButton);
        sosButton = findViewById(R.id.sosButton);
        rightsButton.setOnClickListener(v ->
                openSection("Know Your Rights", "rights.json"));
        firstAidButton.setOnClickListener(v ->
                openSection("First Aid", "firstaid.json"));

        checklistButton.setOnClickListener(v ->
                openSection("Protest Checklist", "checklist.json"));

        emergencyButton.setOnClickListener(v ->
                openSection("Emergency Contacts", "contacts.json"));
        legalButton.setOnClickListener(v -> {

            Intent intent =
                    new Intent(MainActivity.this,
                            StateSelectionActivity.class);

            startActivity(intent);

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sosButton = findViewById(R.id.sosButton);

        sosButton.setOnClickListener(v -> {

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Emergency")
                    .setMessage("Open the emergency dialer (112)?")
                    .setPositiveButton("Call", (dialog, which) -> {

                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:112"));
                        startActivity(intent);

                    })
                    .setNegativeButton("Cancel", null)
                    .show();

        });


    }
}