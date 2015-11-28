package com.bestteamever.mymovies.ui.moviedetail.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.model.Movie;
import com.bestteamever.mymovies.ui.moviedetail.MovieDetailActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailFragment extends Fragment {

    @Bind (R.id.poster) ImageView mPosterView;
    @Bind (R.id.original_title) TextView mOriginalTitleView;
    @Bind (R.id.release_date) TextView mReleaseDateView;
    @Bind (R.id.overview) TextView mOverview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        ButterKnife.bind(this, result);

        render((Movie) getActivity().getIntent().getSerializableExtra(MovieDetailActivity.MOVIE));

        return result;
    }

    private void render(Movie movie) {
        mOriginalTitleView.setText(movie.getTitle());
        mReleaseDateView.setText(movie.getDate());
        mOverview.setText(movie.getOverView());
    }
}
