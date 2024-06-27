import java.util.InputMismatchException;
import java.util.Scanner;


public class Sports {
    private Scanner scan = new Scanner(System.in);
    private int choice;
    private Sports sport;

    public Sports() {
        choice = 0;
    }

    public void selectGame() {
        System.out.print("""
                \nSelect the type of Sport you want to play: 
                1. Ball Sports
                2. Water Sports
                3. Athletics
                4. Gymnastics
                """);
        do {
            try {
                choice = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scan.next();
                continue;
            }
            switch (choice) {
                case 1:
                    sport = new BallSports();
                    break;
                case 2:
                    sport = new WaterSports();
                    break;
                case 3:
                    sport = new Athletics();
                    break;
                case 4:
                    sport = new Gymnastics();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (sport == null);
    }

    public static void display() {
        int totalCounter = BallSports.getCounter() + WaterSports.getCounter() + Athletics.getCounter() + Gymnastics.getCounter();
        System.out.println("\n\t*** " + totalCounter + ((totalCounter > 1 || totalCounter == 0) ? "games" : "game") + " is booked ***\n");
        BallSports.display();
        WaterSports.display();
        Athletics.display();
        Gymnastics.display();
    }

    public String getGameName() {
        return "Not specified";
    }

    public String getDate() {
        return "Not specified";
    }

    public void info() {
        System.out.println("\n--- Booking Information ---");
        System.out.println("Game type: " + sport.getClass().getSimpleName());
        System.out.println("Game name: " + sport.getGameName());
        System.out.println("Date: " + sport.getDate());
        System.out.println("----------------------------\n");
    }
}
