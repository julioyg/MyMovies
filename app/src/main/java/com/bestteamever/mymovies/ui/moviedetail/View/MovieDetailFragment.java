package com.bestteamever.mymovies.ui.moviedetail.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.ui.moviedetail.MovieDetailActivity;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailFragment extends Fragment {

    @Bind (R.id.title) TextView mOriginalTitleView;
    @Bind (R.id.overview) TextView mOverview;
    @Bind (R.id.date) TextView mReleaseDateView;
    @Bind (R.id.poster) ImageView mPosterView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        ButterKnife.bind(this, result);

        render((MovieModel) getActivity().getIntent().getSerializableExtra(MovieDetailActivity.INTENT_EXTRA_MOVIE));

        return result;
    }

    private void render(MovieModel movie) {
        mOriginalTitleView.setText(movie.getTitle());
        mReleaseDateView.setText(movie.getDate());
        mOverview.setText(movie.getOverView());

        Glide.with(getContext()).load(movie.getPoster()).into(mPosterView);
    }
}
