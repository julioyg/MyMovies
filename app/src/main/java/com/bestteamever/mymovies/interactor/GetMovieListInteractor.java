package com.bestteamever.mymovies.interactor;

import android.os.AsyncTask;

import com.bestteamever.mymovies.model.Movie;
import com.bestteamever.mymovies.repository.movie.MovieRepository;

import java.util.List;

public class GetMovieListInteractor {

    public void get(Callback callback) {
        new GetMovieListInteractorAsyncTask(callback).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR);
    }

    public interface Callback {
        void onMoviesList(List<Movie> movies);
    }

    static class GetMovieListInteractorAsyncTask extends AsyncTask<Void, Void, List<Movie>> {
        private final MovieRepository mMovieRepository = new MovieRepository();
        private final Callback mCallback;

        public GetMovieListInteractorAsyncTask(Callback callback) {
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
