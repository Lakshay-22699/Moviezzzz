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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.HeroViewHolder> {


//    private List<Contact> contactList;
    private Context context;

    private static int currentPosition = 0;

//    public MovieAdapter(List<Contact> cl, Context context) {
//        this.contactList = cl;
//        this.context = context;
//    }

    public MovieAdapter(Context applicationContext) {
        this.context=applicationContext;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new HeroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HeroViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {
        TextView rating,title;
        ImageView imageView;
        LinearLayout linearLayout;

        HeroViewHolder(View itemView) {
            super(itemView);

            rating = itemView.findViewById(R.id.rating);
            title = itemView.findViewById(R.id.mtitle);
            imageView = itemView.findViewById(R.id.posterr);

//            linearLayout = itemView.findViewById(R.id.fulldetals);
        }
    }
}