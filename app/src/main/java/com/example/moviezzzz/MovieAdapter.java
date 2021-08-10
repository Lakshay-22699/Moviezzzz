package com.example.moviezzzz;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.HeroViewHolder> {
    List<Datas> values;
    public MovieAdapter(Context context,List<Datas> values) {
        this.values=values;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new HeroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HeroViewHolder holder, final int position) {
            holder.title.setText(values.get(position).title);
            holder.rating.setText(values.get(position).rating);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {
        TextView rating,title;
        HeroViewHolder(View itemView) {
            super(itemView);
            rating = itemView.findViewById(R.id.rating);
            title = itemView.findViewById(R.id.mtitle);
        }
    }
}