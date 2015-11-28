package com.bestteamever.mymovies.interactor;

import android.os.AsyncTask;

import com.bestteamever.mymovies.model.Movie;
import com.bestteamever.mymovies.repository.movie.MovieRepository;

import java.util.List;

public class GetMovieListInteractorImpl implements GetMovieListInteractor {

    private final MovieRepository mRepository;

    public GetMovieListInteractorImpl(MovieRepository repository) {
        mRepository = repository;
    }

    @Override
    public void get(Callback callback) {
        new GetMovieListInteractorAsyncTask(mRepository, callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }

    static class GetMovieListInteractorAsyncTask extends AsyncTask<Void, Void, List<Movie>> {
        private final MovieRepository mMovieRepository;
        private final Callback mCallback;

        public GetMovieListInteractorAsyncTask(MovieRepository movieRepository, Callback callback) {
            mMovieRepository = movieRepository;
            this.mCallback = callback;
        }

        @Override
        protected List<Movie> doInBackground(Void... voids) {
            return mMovieRepository.getList();
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            this.mCallback.onMoviesList(movies);
        }
    }
}
