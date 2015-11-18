package com.bestteamever.mymovies.ui.main.view.movie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.model.Movie;
import com.bestteamever.mymovies.ui.moviedetail.MovieDetailActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieViewItem extends FrameLayout {
    @Bind (R.id.title) TextView mTitleView;
    @Bind (R.id.date) TextView mDateView;

    private Movie mMovie;

    public MovieViewItem(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_movie_item, this, true);
        ButterKnife.bind(this);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.MOVIE, mMovie);
                getContext().startActivity(intent);
            }
        });
    }

    public void bind(Movie movie) {
        mMovie = movie;
        mTitleView.setText(movie.getTitle());
        mDateView.setText(movie.getDate());
    }
}
