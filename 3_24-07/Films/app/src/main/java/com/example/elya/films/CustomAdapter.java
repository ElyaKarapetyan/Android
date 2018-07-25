package com.example.elya.films;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.FilmHolder> {
    private ArrayList<Film> films;
    private Context context;

    public CustomAdapter(ArrayList<Film> films, Context context) {
        this.films = films;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.film_holder, viewGroup, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder filmHolder, int i) {
        Film kino = films.get(i);
        filmHolder.title.setText(kino.getTitle());
        filmHolder.image.setImageResource(kino.getImageId());
        filmHolder.description.setText(kino.getDescription());
        filmHolder.rating.setRating(kino.getRating());
        if (kino.isLiked) {
            filmHolder.heart.setImageResource(R.drawable.ic_like);
        } else {
            filmHolder.heart.setImageResource(R.drawable.ic_unlike);
        }

    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class FilmHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView image;
        private TextView description;
        private RatingBar rating;
        private ImageButton heart;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            description = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
            heart = itemView.findViewById(R.id.heart);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(films.get(position).getWikiUrl()));
            context.startActivity(browserIntent);
        }
    }
}
