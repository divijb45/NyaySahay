package com.example.protestresources.adapters;
import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protestresources.LawyerDirectoryActivity;
import com.example.protestresources.R;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    private final Context context;
    private final List<String> states;
    private final List<String> files;

    private final List<String> filteredStates;
    private final List<String> filteredFiles;

    public StateAdapter(Context context, List<String> states, List<String> files) {
        this.context = context;

        this.states = states;
        this.files = files;

        filteredStates = new ArrayList<>(states);
        filteredFiles = new ArrayList<>(files);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.state_card, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(filteredStates.get(position));

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, LawyerDirectoryActivity.class);

            intent.putExtra("state", filteredStates.get(position));
            intent.putExtra("file", filteredFiles.get(position));

            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return filteredStates.size();
    }
    public void filter(String query) {

        filteredStates.clear();
        filteredFiles.clear();

        query = query.toLowerCase().trim();

        for (int i = 0; i < states.size(); i++) {

            if (query.isEmpty() ||
                    states.get(i).toLowerCase().contains(query)) {

                filteredStates.add(states.get(i));
                filteredFiles.add(files.get(i));

            }

        }

        notifyDataSetChanged();

    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.stateName);
        }

    }

}