package com.example.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DestinationsAdapter extends RecyclerView.Adapter<DestinationsAdapter.DestinationsViewHolder> {
    private List<Destinations> destinationsList;
    private Context context;

    public DestinationsAdapter(List<Destinations> destinationsList, Context context) {
        this.destinationsList = destinationsList;
        this.context = context;
    }

    @NonNull
    @Override
    public DestinationsAdapter.DestinationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.destinations_row, parent, false);
        return new DestinationsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationsAdapter.DestinationsViewHolder holder, int position) {
        holder.destinationsImageView.setImageResource(destinationsList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return destinationsList.size();
    }


    public class DestinationsViewHolder extends RecyclerView.ViewHolder {
        public ImageView destinationsImageView;

        public DestinationsViewHolder(@NonNull View itemView) {
            super(itemView);
            destinationsImageView = itemView.findViewById(R.id.destinationsImageView);
        }
    }
}
