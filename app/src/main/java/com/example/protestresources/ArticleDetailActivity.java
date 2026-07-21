package com.example.protestresources;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        TextView title = findViewById(R.id.titleText);
        TextView subtitle = findViewById(R.id.subtitleText);
        TextView content = findViewById(R.id.contentText);

        title.setText(getIntent().getStringExtra("title"));
        subtitle.setText(getIntent().getStringExtra("subtitle"));
        content.setText(getIntent().getStringExtra("content"));

    }

}