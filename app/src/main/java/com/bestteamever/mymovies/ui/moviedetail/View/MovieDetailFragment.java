package com.bestteamever.mymovies.ui.moviedetail.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bestteamever.mymovies.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailFragment extends Fragment {

    @Bind(R.id.poster) ImageView mPosterView;
    @Bind(R.id.original_title) ImageView mOriginalTitleView;
    @Bind()



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_movie_detail, container, false);

        ButterKnife.bind(this, result);

        return result;
    }
}
