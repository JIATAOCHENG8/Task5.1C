package com.example.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder> {
    private List<Places> placesList;
    private Context context;
    private OnRowClickListener listener;


    public PlacesAdapter(List<Places> placesList, Context context, OnRowClickListener clickListener) {
        this.placesList = placesList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.places_row, parent, false);
        return new PlacesViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder holder, int position) {
        holder.placesImageView.setImageResource(placesList.get(position).getImage());
        holder.nameTextView.setText(placesList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }

    public class PlacesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView placesImageView;
        public TextView nameTextView;
        public OnRowClickListener onRowClickListener;

        public PlacesViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            placesImageView = itemView.findViewById(R.id.placesImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener{
        void onItemClick (int position);
    }
}
