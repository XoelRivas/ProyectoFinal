import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Represents a Movie with various attributes like title, year, director, duration,
 * watch date, streaming platform, screen, audio, and rating.
 */
public class Movie implements Serializable {
    private String title;
    private int year;
    private String director;
    private int duration;
    private LocalDate watchDate;
    private String streaming;
    private String screen;
    private String audio;
    private int rating;

    /**
     * Constructor to create a new Movie with the given attributes.
     * @param title The title of the movie.
     * @param year The year the movie was released.
     * @param director The name of the director.
     * @param duration The duration of the movie in minutes.
     * @param watchDate The date when the movie was watched.
     * @param streaming The streaming platform where the movie was watched.
     * @param screen The type of screen used to watch the movie.
     * @param audio The type of audio used for the movie
     * @param rating The rating of the movie.
     */
    public Movie(String title, int year, String director, int duration, LocalDate watchDate, String streaming, String screen, String audio, int rating) {
        this.title = title;
        this.year = year;
        this.director = director;
        this.duration = duration;
        this.watchDate = watchDate;
        this.streaming = streaming;
        this.screen = screen;
        this.audio = audio;
        this.rating = rating;
    }

    /**
     * Gets the title of the movie.
     * @return The title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the movie.
     * @param title The new title of the movie.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the year the movie was released.
     * @return The year of release.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year the movie was released.
     * @param year The new year of release.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the name of the director of the movie.
     * @return The director's name.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the name of the director of the movie.
     * @param director The new director's name.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets the duration of the movie in minutes.
     * @return The duration in minutes.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the movie in minutes.
     * @param duration The new duration in minutes.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets the date when the movie was watched.
     * @return The watch date.
     */
    public LocalDate getWatchDate() {
        return watchDate;
    }

    /**
     * Sets the date when the movie was watched.
     * @param watchDate The new watch date.
     */
    public void setWatchDate(LocalDate watchDate) {
        this.watchDate = watchDate;
    }

    /**
     * Gets the streaming platform where the movie was watched.
     * @return The streaming platform.
     */
    public String getStreaming() {
        return streaming;
    }

    /**
     * Sets the streaming platform where the movie was watched.
     * @param streaming The new streaming platform.
     */
    public void setStreaming(String streaming) {
        this.streaming = streaming;
    }

    /**
     * Gets the type of screen used to watch the movie.
     * @return The type of screen.
     */
    public String getScreen() {
        return screen;
    }

    /**
     * Sets the type of screen used to watch the movie.
     * @param screen The new screen type.
     */
    public void setScreen(String screen) {
        this.screen = screen;
    }

    /**
     * Gets the type of audio used for the movie.
     * @return The type of audio.
     */
    public String getAudio() {
        return audio;
    }

    /**
     * Sets the type of audio used for the movie.
     * @param audio The new audio type.
     */
    public void setAudio(String audio) {
        this.audio = audio;
    }

    /**
     * Gets the movie's rating.
     * @return The rating.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the movie's rating.
     * @param rating The new rating.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Returns a string representation of the movie, summarizing its key attributes.
     * @return A string describing the movie.
     */
    @Override
    public String toString() {
        return "Movie: " + title + " || Year: " + year + " || Director: " + director + " || Duration: " +
                duration + " || Watch Date: " + watchDate + " || Streaming: " + streaming + " || Screen: " +
                screen + " || Audio: " + audio + " || Rating: " + rating;
    }
}
