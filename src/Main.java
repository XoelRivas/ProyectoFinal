import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
     * Method to show the movies that the user add
     */
    private static void userAddMovie() {
        MovieController mc = loadMovieController();
        if (mc == null) {
            mc = new MovieController();
        }
        Scanner s = new Scanner(System.in);
        boolean repeat = true;
        LocalDate watchDate = null;

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
        while (repeat) {
            System.out.print("Watch date (YYYY-MM-DD): ");
            String watchDateStr = s.nextLine();
            try {
                watchDate = LocalDate.parse(watchDateStr);
                repeat = false;
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect date format. Please try again.");
            }
        }
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

        //To save the movie
        saveMovieController(mc);

        System.out.println("\nMovies list:");
        for (Map.Entry<Integer, Movie> entry : mc.getMovies().entrySet()){
            System.out.println("Nº: " + entry.getKey() + " || " + entry.getValue());
        }
    }

    /**
     * Method to load the list of movies
     * @return MovieController
     */
    private static MovieController loadMovieController() {
        MovieController mc = null;
        try {
            FileInputStream fileIn = new FileInputStream("MoviesList");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            mc = (MovieController) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("The movie file can not be load");
        }
        return mc;
    }

    /**
     * Method to save the list of movies
     * @param mc MovieController
     */
    private static void saveMovieController(MovieController mc) {
        try {
            FileOutputStream fileOut = new FileOutputStream("MoviesList");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(mc);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("The movie file can not be save");
        }
    }
}