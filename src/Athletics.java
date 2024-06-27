import java.util.Scanner;
import java.util.InputMismatchException;

enum AthleticsType {
    RUNNING, JUMPING, THROWING
}

public class Athletics extends Sports {
    private AthleticsType type;
    private Scanner scan = new Scanner(System.in);
    private static boolean[] isBookedRunning = new boolean[14];
    private static boolean[] isBookedJumping = new boolean[14];
    private static boolean[] isBookedThrowing = new boolean[14];
    private StringBuilder runningCalender;
    private StringBuilder jumpingCalender;
    private StringBuilder throwingCalender;
    private StringBuilder date;
    private static int counter;
    private static int runningCounter;
    private static int jumpingCounter;
    private static int throwingCounter;

    public Athletics() {
        runningCalender = jumpingCalender = throwingCalender = date = new StringBuilder("");
        book();
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    private void displayRunningCalender() {
        for (int i = 0; i < isBookedRunning.length; i++) {
            if (isBookedRunning[i]) {
                runningCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                runningCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(runningCalender.toString());
    }

    private void displayJumpingCalender() {
        for (int i = 0; i < isBookedJumping.length; i++) {
            if (isBookedJumping[i]) {
                jumpingCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                jumpingCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(jumpingCalender.toString());
    }

    private void displayThrowingCalender() {
        for (int i = 0; i < isBookedThrowing.length; i++) {
            if (isBookedThrowing[i]) {
                throwingCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                throwingCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(throwingCalender.toString());
    }

    private void bookRunning() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedRunning[timeSlot - 1]) {
                    isBookedRunning[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedRunning[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is already booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    private void bookJumping() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedJumping[timeSlot - 1]) {
                    isBookedJumping[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedJumping[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is already booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    private void bookThrowing() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedThrowing[timeSlot - 1]) {
                    isBookedThrowing[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedThrowing[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is already booked. Please select another time slot.");
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
                \nSelect the type of Athletics you want to play: 
                1. Running
                2. Jumping
                3. Throwing
                """);
        do {
            int choice = 0;
            try {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        type = AthleticsType.RUNNING;
                        runningCounter++;
                        break;
                    case 2:
                        type = AthleticsType.JUMPING;
                        jumpingCounter++;
                        break;
                    case 3:
                        type = AthleticsType.THROWING;
                        throwingCounter++;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scan.next();
            }
        } while (type == null);

        System.out.println("\nSelect the time slot you want to book: ");
        switch (type) {
            case RUNNING:
                displayRunningCalender();
                bookRunning();
                break;
            case JUMPING:
                displayJumpingCalender();
                bookJumping();
                break;
            case THROWING:
                displayThrowingCalender();
                bookThrowing();
                break;
        }
    }

    public static void display() {
        System.out.println("\n--- " + counter + " Athletics " + ((counter > 1 || counter == 0) ? "games" : "game") + " is booked ---");
        System.out.println("* " + runningCounter + " Running " + ((runningCounter > 1 || runningCounter == 0) ? "games" : "game") + " booked");
        System.out.println("* " + jumpingCounter + " Jumping " + ((jumpingCounter > 1 || jumpingCounter == 0) ? "games" : "game") + " booked");
        System.out.println("* " + throwingCounter + " Throwing " + ((throwingCounter > 1 || throwingCounter == 0) ? "games" : "game") + " booked");
        System.out.println("---------------------------------\n");
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
