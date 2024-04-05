import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("""
                \tMENU
                ------------
                1. Add movie
                2. Movie data
                3. Statistics
                4. Create lists
                5. Add to lists
                6. Visualize lists
                7. Fields
                8. Exit\n""");

        System.out.print("Choose an option: ");
        int option = s.nextInt();

        switch (option) {
            case 1 -> userAddMovie();
        }
    }

    /**
     * It shows the movies that the user add
     */
    private static void userAddMovie() {
        Scanner s = new Scanner(System.in);
        MovieController mc = new MovieController();

        System.out.println("Add movie data: ");
        System.out.print("Title: ");
        String title = s.nextLine();
        System.out.print("Year: ");
        int year = s.nextInt();
        s.nextLine(); //To clean Scanner buffer
        System.out.print("Director: ");
        String director = s.nextLine();
        System.out.print("Duration (in minutes): ");
        int duration = s.nextInt();
        s.nextLine(); //To clean Scanner buffer
        System.out.print("Watch date (YYYY-MM-DD): ");
        String watchDateStr = s.nextLine();
        LocalDate watchDate = LocalDate.parse(watchDateStr);
        System.out.print("Streaming: ");
        String streaming = s.nextLine();
        System.out.print("Screen: ");
        String screen = s.nextLine();
        System.out.print("Audio: ");
        String audio = s.nextLine();
        System.out.print("Rating: ");
        int rating = s.nextInt();

        //It creates a movie object with the data that the user added
        Movie movie = new Movie(title, year, director, duration, watchDate, streaming, screen, audio, rating);

        //To add the movie using the controller
        mc.addMovie(movie);

        System.out.println("\nMovies list:");
        for (Map.Entry<Integer, Movie> entry : mc.getMovies().entrySet()){
            System.out.println("Nº: " + entry.getKey() + " || " + entry.getValue());
        }
    }
}