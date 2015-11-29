package com.bestteamever.mymovies.ui.movieslist.presenter;

import android.text.TextUtils;
import com.bestteamever.mymovies.domain.interactor.DefaultSubscriber;
import com.bestteamever.mymovies.domain.interactor.movie.GetMovieListInteractor;
import com.bestteamever.mymovies.domain.model.Movie;
import com.bestteamever.mymovies.model.MovieModel;
import com.bestteamever.mymovies.model.mapper.MovieModelMapper;
import com.bestteamever.mymovies.ui.movieslist.view.MoviesListView;
import java.util.List;
import javax.inject.Inject;

public class MoviesListPresenter {
  private final GetMovieListInteractor mGetMovieListInteractor;
  private MoviesListView mView;

  @Inject public MoviesListPresenter(GetMovieListInteractor getMovieListInteractor) {
    mGetMovieListInteractor = getMovieListInteractor;
  }

  public void takeView(MoviesListView view) {
    this.mView = view;
  }

  public void dropView() {
    this.mGetMovieListInteractor.unsubscribe();
    this.mView = null;
  }

  private void showMovies(List<MovieModel> movies) {
    if (movies.isEmpty()) {
      this.mView.showNoResults();
      return;
    }

    this.mView.showMovies(movies);
  }

  public void onClickFloatingActionButton() {
    this.mView.showInputTitleDialog();
  }

  public void getMoviesForTitle(String text) {
    if (TextUtils.isEmpty(text)) {
      this.mView.showEmptySearchError();
      return;
    }

    this.mView.showLoading();
    this.mGetMovieListInteractor.execute(text, new UserDetailsSubscriber());
  }

  private final class UserDetailsSubscriber extends DefaultSubscriber<List<Movie>> {

    @Override public void onNext(List<Movie> movies) {
      MoviesListPresenter.this.showMovies(MovieModelMapper.transform(movies));
    }

    @Override public void onCompleted() {
      MoviesListPresenter.this.mView.dismissLoading();
    }
  }
}
