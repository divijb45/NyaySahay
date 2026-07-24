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
import com.example.protestresources.model.Volunteer;
import com.example.protestresources.model.Volunteer;

import java.util.ArrayList;
import java.util.List;

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.ViewHolder> {

    private final Context context;
    private final List<Volunteer> volunteers;
    private final List<Volunteer> filtered;

    public VolunteerAdapter(Context context, List<Volunteer> volunteers) {
        this.context = context;
        this.volunteers = volunteers;
        this.filtered = new ArrayList<>(volunteers);
    }

    public void filter(String query) {

        filtered.clear();

        query = query.toLowerCase().trim();

        for (Volunteer volunteer : volunteers) {

            if (query.isEmpty()
                    || volunteer.getName().toLowerCase().contains(query)
                    || volunteer.getLocation().toLowerCase().contains(query)
                    || volunteer.getPhone().contains(query)) {

                filtered.add(volunteer);

            }

        }

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.volunteer_card, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Volunteer volunteer = filtered.get(position);

        holder.name.setText(volunteer.getName());

        holder.location.setText(volunteer.getLocation());

        holder.email.setText(volunteer.getEmail());

        holder.call.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + volunteer.getPhone()));

            context.startActivity(intent);

        });
        holder.itemView.setOnLongClickListener(v -> {

            android.content.ClipboardManager clipboard =
                    (android.content.ClipboardManager)
                            context.getSystemService(Context.CLIPBOARD_SERVICE);

            android.content.ClipData clip =
                    android.content.ClipData.newPlainText(
                            "Phone Number",
                            volunteer.getPhone());

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
        TextView location;

        TextView email;
        Button call;

        ViewHolder(View itemView) {

            super(itemView);

            name = itemView.findViewById(R.id.volunteerName);
            location = itemView.findViewById(R.id.volunteerLocation);
            email = itemView.findViewById(R.id.volunteerEmail);
            call = itemView.findViewById(R.id.callButton);

        }

    }

}
