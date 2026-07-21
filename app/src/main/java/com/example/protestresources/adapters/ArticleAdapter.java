package com.example.protestresources.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protestresources.ArticleDetailActivity;
import com.example.protestresources.R;
import com.example.protestresources.model.Article;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private final Context context;
    private final List<Article> articles;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.article_card, parent, false);

        return new ArticleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {

        Article article = articles.get(position);

        holder.title.setText(article.getTitle());
        holder.subtitle.setText(article.getSubtitle());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, ArticleDetailActivity.class);

            intent.putExtra("title", article.getTitle());
            intent.putExtra("subtitle", article.getSubtitle());
            intent.putExtra("content", article.getContent());

            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subtitle;

        public ArticleViewHolder(@NonNull View itemView) {

            super(itemView);

            title = itemView.findViewById(R.id.cardTitle);
            subtitle = itemView.findViewById(R.id.cardSubtitle);

        }

    }

}