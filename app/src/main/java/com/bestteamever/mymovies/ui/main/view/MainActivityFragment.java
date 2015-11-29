package com.bestteamever.mymovies.ui.main.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.adapter.MyMoviesListAdapter;
import com.bestteamever.mymovies.di.component.MainComponent;
import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.ui.fragment.BaseFragment;
import com.bestteamever.mymovies.ui.main.presenter.MainPresenter;
import com.bestteamever.mymovies.ui.navigation.Navigator;
import com.bestteamever.mymovies.ui.recyclerview.listener.OnRecyclerItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment implements MainView {
    @Inject MainPresenter mPresenter;
    @Inject Navigator mNavigator;

    @Bind ((R.id.list)) RecyclerView mRecyclerView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, result);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(getContext(), this::onItemClick));

        return result;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.intialize();
    }

    private void intialize() {
        this.getComponent(MainComponent.class).inject(this);
        this.mPresenter.takeView(this);
    }

    @Override
    public void onDestroyView() {
        this.mPresenter.dropView();

        super.onDestroyView();
    }

    private void onItemClick(int position) {
        this.mPresenter.onItemClick(((MyMoviesListAdapter) this.mRecyclerView.getAdapter()).getItem(position));
    }

    @Override
    public void showMovies(List<MovieModel> movies) {
        this.mRecyclerView.setAdapter(new MyMoviesListAdapter(getContext(), movies));
    }

    @Override
    public void goToItemDetail(MovieModel movie) {
        mNavigator.navigateToItemDetail(getContext(), movie);
    }
}
