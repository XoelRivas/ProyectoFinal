import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getWatchDate() {
        return watchDate;
    }

    public void setWatchDate(LocalDate watchDate) {
        this.watchDate = watchDate;
    }

    public String getStreaming() {
        return streaming;
    }

    public void setStreaming(String streaming) {
        this.streaming = streaming;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie: " + title + " || Year: " + year + " || Director: " + director + " || Duration: " +
                duration + " || Watch Date: " + watchDate + " || Streaming: " + streaming + " || Screen: " +
                screen + " || Audio: " + audio + " || Rating: " + rating;
    }
}
