import java.util.Scanner;
import java.util.InputMismatchException;

enum BallSportType {
    FOOTBALL, BASKETBALL, VOLLEYBALL
}

public class BallSports extends Sports {
    private BallSportType type;
    private Scanner scan = new Scanner(System.in);
    private static boolean[] isBookedFootball = new boolean[14];
    private static boolean[] isBookedBasketball = new boolean[14];
    private static boolean[] isBookedVolleyball = new boolean[14];
    private StringBuilder footballCalender;
    private StringBuilder basketballCalender;
    private StringBuilder volleyballCalender;
    private StringBuilder date;
    private static int counter;
    private static int footballCounter;
    private static int basketballCounter;
    private static int volleyballCounter;

    public BallSports() {
        footballCalender = basketballCalender = volleyballCalender = date = new StringBuilder("");
        book();
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    private void displayFootballCalender() {
        for (int i = 0; i < isBookedFootball.length; i++) {
            if (isBookedFootball[i]) {
                footballCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                footballCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(footballCalender.toString());
    }

    private void displayBasketballCalender() {
        for (int i = 0; i < isBookedBasketball.length; i++) {
            if (isBookedBasketball[i]) {
                basketballCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                basketballCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(basketballCalender);
    }

    private void displayVolleyballCalender() {
        for (int i = 0; i < isBookedVolleyball.length; i++) {
            if (isBookedVolleyball[i]) {
                volleyballCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                volleyballCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(volleyballCalender);
    }

    private void bookFootball() {
        do {
            int timeSlot;
            try {
                timeSlot = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scan.next();
                continue;
            }
            try {
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedFootball[timeSlot - 1]) {
                    isBookedFootball[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedFootball[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    private void bookBasketball() {
        do {
            int timeSlot;
            try {
                timeSlot = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scan.next();
                continue;
            }
            try {
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedBasketball[timeSlot - 1]) {
                    isBookedBasketball[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedBasketball[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    private void bookVolleyball() {
        do {
            int timeSlot;
            try {
                timeSlot = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scan.next();
                continue;
            }
            try {
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedVolleyball[timeSlot - 1]) {
                    isBookedVolleyball[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedVolleyball[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    public void book() {
        System.out.print("""
                \nSelect the type of ball game you want to play: ");
                1. Football
                2. Basketball
                3. Volleyball
                """);
        do {
            int choice = 0;
            try {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        type = BallSportType.FOOTBALL;
                        footballCounter++;
                        break;
                    case 2:
                        type = BallSportType.BASKETBALL;
                        basketballCounter++;
                        break;
                    case 3:
                        type = BallSportType.VOLLEYBALL;
                        volleyballCounter++;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scan.next();
                continue;
            }
        } while (type == null);

        System.out.println("\nSelect the time slot you want to book: ");
        switch (type) {
            case FOOTBALL:
                displayFootballCalender();
                bookFootball();
                break;
            case BASKETBALL:
                displayBasketballCalender();
                bookBasketball();
                break;
            case VOLLEYBALL:
                displayVolleyballCalender();
                bookVolleyball();
                break;
        }
    }

    public static void display() {
        System.out.println("\n--- " + counter + " Ball " + ((counter > 1 || counter == 0) ? "games" : "game") + " is booked ---");
        System.out.println("* " + footballCounter + " Football " + ((footballCounter > 1 || footballCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("* " + basketballCounter + " Basketball " + ((basketballCounter > 1 || basketballCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("* " + volleyballCounter + " Volleyball " + ((volleyballCounter > 1 || volleyballCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("------------------------------\n");
    }

    @Override
    public String getGameName() {
        return type.toString();
    }

    private void setDate(int time) {
        date.setLength(0);
        date.append("From ").append(time + 7).append(":00 to ").append(time + 8).append(":00");
    }

    @Override
    public String getDate() {
        return date.toString();
    }
}
