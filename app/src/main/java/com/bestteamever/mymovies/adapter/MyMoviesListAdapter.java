package com.bestteamever.mymovies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.model.Movie;

import java.util.List;


public class MyMoviesListAdapter extends BaseAdapter {
    private final Context mContext;
    private List<Movie> mItems;

    public MyMoviesListAdapter(Context context, List<Movie> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Movie getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(mContext).inflate(R.layout.view_movie_item, viewGroup,
                                                         false);
            holder.date = (TextView) view.findViewById(R.id.date);
            holder.title = (TextView) view.findViewById(R.id.title);

            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        Movie item = getItem(i);

        holder.title.setText(item.getTilte());
        holder.date.setText(item.getDate());

        return view;
    }

    static class Holder {
        TextView title;
        TextView date;
    }
}
