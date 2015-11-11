package com.bestteamever.mymovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.bestteamever.mymovies.model.Movie;
import com.bestteamever.mymovies.ui.main.view.movie.MovieViewItem;

import java.util.List;

public class MyMoviesListAdapter extends RecyclerView.Adapter<MyMoviesListAdapter.ViewHolder> {
    private final Context mContext;
    private List<Movie> mItems;

    public MyMoviesListAdapter(Context context, List<Movie> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public MyMoviesListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new MovieViewItem(mContext));
    }

    @Override
    public void onBindViewHolder(MyMoviesListAdapter.ViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems == null ?  0 : mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Movie movie) {
            ((MovieViewItem) super.itemView).bind(movie);
        }
    }
}
