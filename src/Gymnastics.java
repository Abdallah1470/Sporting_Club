import java.util.Scanner;
import java.util.InputMismatchException;

enum GymnasticsType {
    RHYTHMIC, TRAMPOLINE, ARTISTIC
}

public class Gymnastics extends Sports {
    private GymnasticsType type;
    private Scanner scan = new Scanner(System.in);
    private static boolean[] isBookedRhythmic = new boolean[14];
    private static boolean[] isBookedTrampoline = new boolean[14];
    private static boolean[] isBookedArtistic = new boolean[14];
    private StringBuilder rhythmicCalender;
    private StringBuilder trampolineCalender;
    private StringBuilder artisticCalender;
    private StringBuilder date;
    private static int counter;
    private static int rhythmicCounter;
    private static int trampolineCounter;
    private static int artisticCounter;

    public Gymnastics() {
        rhythmicCalender = trampolineCalender = artisticCalender = date = new StringBuilder("");
        book();
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    private void displayRhythmicCalender() {
        for (int i = 0; i < isBookedRhythmic.length; i++) {
            if (isBookedRhythmic[i]) {
                rhythmicCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                rhythmicCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(rhythmicCalender.toString());
    }

    private void displayTrampolineCalender() {
        for (int i = 0; i < isBookedTrampoline.length; i++) {
            if (isBookedTrampoline[i]) {
                trampolineCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                trampolineCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(trampolineCalender.toString());
    }

    private void displayArtisticCalender() {
        for (int i = 0; i < isBookedArtistic.length; i++) {
            if (isBookedArtistic[i]) {
                artisticCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Booked)");
            } else {
                artisticCalender.append("\n").append(i + 1).append(". From ").append(i + 8).append(":00 to ").append(i + 9).append(":00 (Available)");
            }
        }
        System.out.println(artisticCalender.toString());
    }

    private void bookRhythmic() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedRhythmic[timeSlot - 1]) {
                    isBookedRhythmic[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedRhythmic[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    private void bookTrampoline() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedTrampoline[timeSlot - 1]) {
                    isBookedTrampoline[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedTrampoline[timeSlot - 1]) {
                    System.out.println("Time slot " + timeSlot + " is booked. Please select another time slot.");
                } else {
                    System.out.println("Invalid time slot. Please select a valid time slot.");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid time slot. Please select a valid time slot.");
            }
        } while (true);
    }

    private void bookArtistic() {
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
                if (timeSlot >= 1 && timeSlot <= 14 && !isBookedArtistic[timeSlot - 1]) {
                    isBookedArtistic[timeSlot - 1] = true;
                    System.out.println("Time slot " + timeSlot + " is successfully booked");
                    setDate(timeSlot);
                    break;
                } else if (isBookedArtistic[timeSlot - 1]) {
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
                \nSelect the type of Gymnastics you want to play: 
                1. Rhythmic
                2. Trampoline
                3. Artistic
                """);
        do {
            int choice = 0;
            try {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        type = GymnasticsType.RHYTHMIC;
                        rhythmicCounter++;
                        break;
                    case 2:
                        type = GymnasticsType.TRAMPOLINE;
                        trampolineCounter++;
                        break;
                    case 3:
                        type = GymnasticsType.ARTISTIC;
                        artisticCounter++;
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
            case RHYTHMIC:
                displayRhythmicCalender();
                bookRhythmic();
                break;
            case TRAMPOLINE:
                displayTrampolineCalender();
                bookTrampoline();
                break;
            case ARTISTIC:
                displayArtisticCalender();
                bookArtistic();
                break;
        }
    }

    public static void display() {
        System.out.println("\n--- " + counter + " Gymnastics " + ((counter > 1 || counter == 0) ? "games" : "game") + " is booked ---");
        System.out.println("* " + rhythmicCounter + " Rhythmic " + ((rhythmicCounter > 1 || rhythmicCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("* " + trampolineCounter + " Trampoline " + ((trampolineCounter > 1 || trampolineCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("* " + artisticCounter + " Artistic " + ((artisticCounter > 1 || artisticCounter == 0) ? "games" : "game") + " is booked");
        System.out.println("------------------------------------\n");

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
