package com.bestteamever.mymovies.ui.movieslist.view;

import com.bestteamever.mymovies.model.MovieModel;
import java.util.List;

public interface MoviesListView {
  void showMovies(List<MovieModel> movies);

  void showInputTitleDialog();

  void showLoading();

  void dismissLoading();

  void showNoResults();

  void showEmptySearchError();
}
