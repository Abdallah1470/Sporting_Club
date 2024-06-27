import java.util.Scanner;
import java.util.InputMismatchException;

enum WaterSportType {
    SWIMMING, DIVING, WATER_VOLLEYBALL
}

public class WaterSports extends Sports {
    private WaterSportType type;
    private Scanner scan = new Scanner(System.in);
    private boolean[] isBookedSwimming = new boolean[14];
    private boolean[] isBookedDiving = new boolean[14];
    private boolean[] isBookedWaterVolleyball = new boolean[14];
    private StringBuilder swimmingCalender;
    private StringBuilder divingCalender;
    private StringBuilder waterVolleyballCalender;
    private StringBuilder date;
    private static int counter;
    private static int swimmingCounter;
    private static int divingCounter;
    private static int waterVolleyballCounter;

    public WaterSports() {
        swimmingCalender = divingCalender = waterVolleyballCalender = date = new StringBuilder("");
        book();
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    private void displaySwimmingCalender() {
        for (int i = 0; i < isBookedSwimming.length; i++) {
            if (isBookedSwimming[i]) {
                swimmingCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                swimmingCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(swimmingCalender.toString());
    }

    private void displayDivingCalender() {
        for (int i = 0; i < isBookedDiving.length; i++) {
            if (isBookedDiving[i]) {
                divingCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                divingCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(divingCalender.toString());
    }

    private void displayWaterVolleyballCalender() {
        for (int i = 0; i < isBookedWaterVolleyball.length; i++) {
            if (isBookedWaterVolleyball[i]) {
                waterVolleyballCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                waterVolleyballCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(waterVolleyballCalender.toString());

    }

    private void bookSwimming() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedSwimming[timeSlot - 1]) {
                    isBookedSwimming[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " booked successfully.");
                    setDate(timeSlot);
                    break;
                } else if (isBookedSwimming[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    private void bookDiving() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedDiving[timeSlot - 1]) {
                    isBookedDiving[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " booked successfully.");
                    setDate(timeSlot);
                    break;
                } else if (isBookedSwimming[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    private void bookWaterVolleyball() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedWaterVolleyball[timeSlot - 1]) {
                    isBookedWaterVolleyball[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " booked successfully.");
                    setDate(timeSlot);
                    break;
                } else if (isBookedWaterVolleyball[timeSlot - 1]) {
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
                \nSelect the type of Water Sport you want to play:
                1. Swimming
                2. Diving
                3. Water Volleyball
                """);
        do {
            int choice = 0;
            try {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        type = WaterSportType.SWIMMING;
                        swimmingCounter++;
                        break;
                    case 2:
                        type = WaterSportType.DIVING;
                        divingCounter++;
                        break;
                    case 3:
                        type = WaterSportType.WATER_VOLLEYBALL;
                        waterVolleyballCounter++;
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
            case SWIMMING:
                displaySwimmingCalender();
                bookSwimming();
                break;
            case DIVING:
                displayDivingCalender();
                bookDiving();
                break;
            case WATER_VOLLEYBALL:
                displayWaterVolleyballCalender();
                bookWaterVolleyball();
                break;
        }
    }

    public static void display() {
        System.out.println("\n--- " + counter + " Water " + ((counter > 1 || counter == 0) ? "games" : "game") + " is booked ---");
        System.out.println("* " + swimmingCounter + " Swimming " + ((swimmingCounter > 1 || swimmingCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("* " + divingCounter + " Diving " + ((divingCounter > 1 || divingCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("* " + waterVolleyballCounter + " Water Volleyball " + ((waterVolleyballCounter > 1 || waterVolleyballCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("-------------------------------\n");
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
