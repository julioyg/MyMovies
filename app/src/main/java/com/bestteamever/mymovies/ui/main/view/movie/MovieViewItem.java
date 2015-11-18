package com.bestteamever.mymovies.ui.main.view.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.model.Movie;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieViewItem extends FrameLayout {
    @Bind (R.id.title) TextView mTitleView;
    @Bind (R.id.date) TextView mDateView;

    public MovieViewItem(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_movie_item, this, true);
        ButterKnife.bind(this);
    }

    public void bind(Movie movie) {
        mTitleView.setText(movie.getTitle());
        mDateView.setText(movie.getDate());
    }
}
