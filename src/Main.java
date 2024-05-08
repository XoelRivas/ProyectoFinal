import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class of the program that allows users to add movies, visualize movie data,
 * visualize statistics, create different lists, and add movies to those lists.
 * It also allows creating fields.
 * @author Xoel Rivas
 */
public class Main {
    /**
     * Main method where the program starts. Provides a menu for different actions
     * related to movie management.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //Display the menu to the user
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
        int option = s.nextInt(); // Read user's choice

        switch (option) {
            case 1 -> userAddMovie(); // Calls the method to add a movie
            default -> System.out.println("Invalid option.");
        }
    }

    /**
     * Method to add a movie. The user enters different details about the movie,
     * and the movie object is created and stored using the MovieController.
     */
    private static void userAddMovie() {
        MovieController mc = loadMovieController(); // Load the movie controller from a file
        if (mc == null) {
            mc = new MovieController(); // Create a new MovieController if not found
        }
        Scanner s = new Scanner(System.in);
        boolean repeat = true;
        LocalDate watchDate = null;
        int year = 0;
        int currentyear = LocalDate.now().getYear();
        int rating = 0;
        int duration = 0;

        System.out.println("Add movie data: ");
        System.out.print("Title: ");
        String title = s.nextLine(); // Get the title of the movie

        // Loop for entering the year with validation checks
        while (repeat) {
            try {
                System.out.print("Year: ");
                year = s.nextInt();
                if (year < 1895) {
                    System.out.println("Year must be superior to 1894. Please, try again.");
                } else if (year > currentyear) {
                    System.out.println("The year inserted is superior to the current year (" + currentyear + "). Please, try again.");
                } else {
                    repeat = false; // Valid year
                }
            } catch (InputMismatchException e) {
                System.out.println("The year to input must be superior to 1894 and inferior to " + currentyear + ". Please, try again.");
                s.next(); // Clear the invalid input
            }
        }
        s.nextLine(); //To clean scanner buffer
        repeat = true; // Reset repeat flag for the next loop

        System.out.print("Director: ");
        String director = s.nextLine(); // Get the director's name

        // Loop for entering the duration with validation checks
        while (repeat) {
            try {
                System.out.print("Duration (in minutes): ");
                duration = s.nextInt();
                if (duration < 0 || duration > 51500) {
                    System.out.println("This value must be between 0 and 51500. Please, try again.");
                } else {
                    repeat = false; // Valid duration
                }
            } catch (InputMismatchException e) {
                System.out.println("This value must be between 0 and 51500. Please, try again.");
                s.next(); // Clear the invalid input
            }
        }
        s.nextLine(); //To clean Scanner buffer
        repeat = true; // Reset repeat flag for the next loop

        // Loop for entering the watch date with validation checks
        while (repeat) {
            System.out.print("Watch date (YYYY-MM-DD): ");
            String watchDateStr = s.nextLine(); // Get the watch date
            try {
                watchDate = LocalDate.parse(watchDateStr); // Parse the date
                repeat = false; // Valid date
            } catch (DateTimeParseException e) {
                System.out.println("Incorrect date format. Please, try again.");
            }
        }
        repeat = true;
        System.out.print("Streaming: ");
        String streaming = s.nextLine(); // Get the streaming platform
        System.out.print("Screen: ");
        String screen = s.nextLine(); // Get the type of screen
        System.out.print("Audio: ");
        String audio = s.nextLine(); // Get the type of audio

        // Loop for entering the rating with validation checks
        while (repeat) {
            try {
                System.out.print("Rating: ");
                rating = s.nextInt(); // Get the movie rating
                if (rating < 0 || rating > 10) {
                    System.out.println("This value must be between 0 and 10. Please, try again.");
                } else {
                    repeat = false; // Valid rating
                }
            } catch (InputMismatchException e) {
                System.out.println("This value must be between 0 and 10 and must not have decimals. Please, try again.");
                s.next(); // Clear the invalid input
            }
        }

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
     * Loads the MovieController from a file to access the existing movie list.
     * @return The loaded MovieController, or null if the file does not exist or an error occurs.
     */
    private static MovieController loadMovieController() {
        MovieController mc = null;
        try {
            FileInputStream fileIn = new FileInputStream("MoviesList");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            mc = (MovieController) objectIn.readObject(); // Deserialize the object
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace(); // Print the stack trace for debugging
            System.out.println("The movie file can not be load");
        }
        return mc;
    }

    /**
     * Saves the MovieController to a file to persist the movie list.
     * @param mc The MovieController to save
     */
    private static void saveMovieController(MovieController mc) {
        try {
            FileOutputStream fileOut = new FileOutputStream("MoviesList");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(mc); // Serialize and save the MovieController
            objectOut.close();
            fileOut.close(); // Close the streams
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            System.out.println("The movie file can not be save");
        }
    }
}