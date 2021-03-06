package com.bestteamever.mymovies.ui.main.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.adapter.MyMoviesListAdapter;
import com.bestteamever.mymovies.model.Movie;
import com.bestteamever.mymovies.ui.main.presenter.MainPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainView {
    private final MainPresenter mPresenter = new MainPresenter();
    @Bind ((R.id.list)) RecyclerView mRecyclerView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, result);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return result;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPresenter.takeView(this);
    }

    @Override
    public void onDestroyView() {
        mPresenter.dropView();

        super.onDestroyView();
    }

    @Override
    public void showMovies(List<Movie> movies) {
        mRecyclerView.setAdapter(new MyMoviesListAdapter(getContext(), movies));
    }
}
