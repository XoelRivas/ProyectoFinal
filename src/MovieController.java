import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Controls the management of movies, including adding movies and retrieving them.
 * Each movie is assigned a unique ID in a HashMap to maintain a collection of movies.
 */
public class MovieController implements Serializable {
    private Map<Integer, Movie> movies; //A map to store movies with unique IDs

    /**
     * Constructor to create a new MovieController with an empty collection of movies.
     */
    public MovieController() {
        this.movies = new HashMap<>(); // Initialize the movie collection
    }

    /**
     * Adds a movie to the controller. Each movie is assigned a unique ID based on the current size of the collection.
     * @param movie The movie to add to the collection.
     */
    public void addMovie(Movie movie) {
        //It generates a unique ID for each movie
        int movieId = this.movies.size() + 1;
        //Add movie to the map
        this.movies.put(movieId, movie);
    }

    /**
     * Retrieves the collection of movies with their unique IDs.
     * @return A map of movie IDs to movie objects.
     */
    public Map<Integer, Movie> getMovies() {
        return movies;
    }
}
