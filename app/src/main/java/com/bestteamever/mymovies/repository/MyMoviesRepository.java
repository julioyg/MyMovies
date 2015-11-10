package bestteamever.com.mymovies.repository;

import java.util.ArrayList;
import java.util.List;

import bestteamever.com.mymovies.model.Movie;

public class MyMoviesRepository {
    public List<Movie> getList() {
        List<Movie> result = new ArrayList<>();
        result.add(Movie.newBuilder().withMDate("11/11/2015").withMTilte(
                "Sorteo extra Once del Once").build());
        return result;
    }
}
