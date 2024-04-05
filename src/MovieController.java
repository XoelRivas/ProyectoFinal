import java.util.HashMap;
import java.util.Map;

public class MovieController {
    private Map<Integer, Movie> movies;

    public MovieController() {
        this.movies = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        //It generates a unique ID for each movie
        int movieId = this.movies.size() + 1;
        //Add movie to the map
        this.movies.put(movieId, movie);
    }

    public Map<Integer, Movie> getMovies() {
        return movies;
    }
}
