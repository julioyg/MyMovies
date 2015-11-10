package com.bestteamever.mymovies.ui.main.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bestteamever.mymovies.adapter.MyMoviesListAdapter;
import com.bestteamever.mymovies.repository.MyMoviesRepository;

import bestteamever.com.mymovies.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Bind ((R.id.list)) ListView mListView;
    private MyMoviesRepository mMyMoviesRepository;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_main, container, false);


        ButterKnife.bind(this, result);

        mMyMoviesRepository = new MyMoviesRepository();

        loadData();

        return result;
    }

    private void loadData() {
        mListView.setAdapter(new MyMoviesListAdapter(getContext(), mMyMoviesRepository.getList()));
    }
}
