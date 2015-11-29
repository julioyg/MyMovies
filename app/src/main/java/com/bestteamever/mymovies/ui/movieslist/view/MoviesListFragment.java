package com.bestteamever.mymovies.ui.movieslist.view;

import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.bestteamever.mymovies.R;
import com.bestteamever.mymovies.adapter.movie.MoviesListAdapter;
import com.bestteamever.mymovies.di.component.MainComponent;
import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.ui.fragment.BaseFragment;
import com.bestteamever.mymovies.ui.movieslist.presenter.MainPresenter;
import com.bestteamever.mymovies.ui.navigation.Navigator;
import com.bestteamever.mymovies.ui.recyclerview.listener.OnRecyclerItemClickListener;
import java.util.List;
import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class MoviesListFragment extends BaseFragment implements MoviesListView {
  @Inject MainPresenter mPresenter;
  @Inject Navigator mNavigator;

  @Bind((R.id.list)) RecyclerView mRecyclerView;

  public MoviesListFragment() {
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View result = inflater.inflate(R.layout.fragment_movies_list, container, false);

    ButterKnife.bind(this, result);

    // use this setting to improve performance if you know that changes
    // in content do not change the layout size of the RecyclerView
    mRecyclerView.setHasFixedSize(true);

    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mRecyclerView.addOnItemTouchListener(
        new OnRecyclerItemClickListener(getContext(), this::onItemClick));

    return result;
  }

  @Override public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.intialize();
  }

  private void intialize() {
    this.getComponent(MainComponent.class).inject(this);
    this.mPresenter.takeView(this);
  }

  @Override public void onDestroyView() {
    this.mPresenter.dropView();

    super.onDestroyView();
  }

  private void onItemClick(RecyclerView rv, View view, int position) {
    MovieModel item = ((MoviesListAdapter) this.mRecyclerView.getAdapter()).getItem(position);

    mNavigator.navigateToItemDetail(getContext(), item, getActivityAnimOptions(view));
  }

  @SuppressWarnings("unchecked") private ActivityOptionsCompat getActivityAnimOptions(View view) {
    Pair<View, String> titleTransition =
        Pair.create(view.findViewById(R.id.title), getString(R.string.transition_title));
    Pair<View, String> dateTransition =
        Pair.create(view.findViewById(R.id.date), getString(R.string.transition_date));
    Pair<View, String> overviewTransition =
        Pair.create(view.findViewById(R.id.overview), getString(R.string.transition_overview));
    Pair<View, String> imageTransition =
        Pair.create(view.findViewById(R.id.image), getString(R.string.transition_image));

    return ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), titleTransition,
        dateTransition, imageTransition, overviewTransition);
  }

  @Override public void showMovies(List<MovieModel> movies) {
    this.mRecyclerView.setAdapter(new MoviesListAdapter(getContext(), movies));
  }
}
