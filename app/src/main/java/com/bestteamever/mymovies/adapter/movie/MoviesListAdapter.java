package com.bestteamever.mymovies.adapter.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bestteamever.mymovies.adapter.AbstractRecyclerAdapter;
import com.bestteamever.mymovies.model.MovieModel;

import java.util.List;

public class MoviesListAdapter extends AbstractRecyclerAdapter<MovieModel, MoviesListAdapter.ViewHolder> {

    public MoviesListAdapter(Context context, List<MovieModel> items) {
        super(context, items);
    }

    @Override
    public MoviesListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new MovieViewItem(super.getContext()));
    }

    @Override
    public void onBindViewHolder(MoviesListAdapter.ViewHolder holder, int position) {
        holder.bind(super.getItem(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(MovieModel movie) {
            ((MovieViewItem) super.itemView).bind(movie);
        }
    }
}
