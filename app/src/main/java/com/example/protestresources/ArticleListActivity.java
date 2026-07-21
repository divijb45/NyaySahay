package com.example.protestresources;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protestresources.adapters.ArticleAdapter;
import com.example.protestresources.model.Article;
import com.example.protestresources.utils.JsonLoader;

import java.util.List;

public class ArticleListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        // Get values passed from MainActivity
        String pageTitle = getIntent().getStringExtra("title");
        String jsonFile = getIntent().getStringExtra("json");

        if (pageTitle == null)
            pageTitle = "Articles";

        if (jsonFile == null)
            jsonFile = "rights.json";

        // Set page title
        TextView title = findViewById(R.id.pageTitle);
        title.setText(pageTitle);

        // Setup RecyclerView
        recyclerView = findViewById(R.id.articleRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load data
        articles = JsonLoader.loadArticles(this, jsonFile);

        // Display articles
        recyclerView.setAdapter(new ArticleAdapter(this, articles));
    }
}