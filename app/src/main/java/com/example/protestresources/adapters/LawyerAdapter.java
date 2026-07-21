package com.example.protestresources.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protestresources.R;
import com.example.protestresources.model.Lawyer;

import java.util.ArrayList;
import java.util.List;

public class LawyerAdapter extends RecyclerView.Adapter<LawyerAdapter.ViewHolder> {

    private final Context context;
    private final List<Lawyer> lawyers;
    private final List<Lawyer> filtered;

    public LawyerAdapter(Context context, List<Lawyer> lawyers) {
        this.context = context;
        this.lawyers = lawyers;
        this.filtered = new ArrayList<>(lawyers);
    }

    public void filter(String query) {

        filtered.clear();

        query = query.toLowerCase().trim();

        for (Lawyer lawyer : lawyers) {

            if (query.isEmpty()
                    || lawyer.getName().toLowerCase().contains(query)
                    || lawyer.getCity().toLowerCase().contains(query)
                    || lawyer.getPhone().contains(query)) {

                filtered.add(lawyer);

            }

        }

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.lawyer_card, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Lawyer lawyer = filtered.get(position);

        holder.name.setText(lawyer.getName());
        holder.city.setText("📍 " + lawyer.getCity());

        holder.call.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + lawyer.getPhone()));

            context.startActivity(intent);

        });
        holder.itemView.setOnLongClickListener(v -> {

            android.content.ClipboardManager clipboard =
                    (android.content.ClipboardManager)
                            context.getSystemService(Context.CLIPBOARD_SERVICE);

            android.content.ClipData clip =
                    android.content.ClipData.newPlainText(
                            "Phone Number",
                            lawyer.getPhone());

            clipboard.setPrimaryClip(clip);

            android.widget.Toast.makeText(
                    context,
                    "Phone number copied",
                    android.widget.Toast.LENGTH_SHORT
            ).show();

            return true;

        });

    }

    @Override
    public int getItemCount() {
        return filtered.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView city;
        Button call;

        ViewHolder(View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.lawyerName);
            city = itemView.findViewById(R.id.lawyerCity);
            call = itemView.findViewById(R.id.callButton);

        }

    }

}