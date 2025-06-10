import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterfaceMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // read user input
        SeasonDeterminer seasonDeterminer = new SeasonDeterminer();
        // TimeConverter timeConverter = new TimeConverter();
        int choice = 0; // need a variable to store the user's menu selection

        do {
            System.out.println("\n----------------------------------------------------------------");
            System.out.println("|             Welcome to the World Time & Season App!          |");
            System.out.println("|                                                              |");
            System.out.println("|  You can convert time and check the current season for the   |");
            System.out.println("|  following supported countries:                              |");
            System.out.println("|                                                              |");
            System.out.println("|    Northern Hemisphere: USA, China, Germany                  |");
            System.out.println("|    Southern Hemisphere: Australia, New Zealand, Brazil       |");
            System.out.println("----------------------------------------------------------------\n");
            System.out.println("=== WorldTime & Weather App ===");
            System.out.println("1. Convert Time");
            System.out.println("2. Determine Current Season");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            /*
             * String input = sc.nextLine();
             * if (input.isEmpty())
             * {
             * System.out.println("Input cannot be blank. Please enter 1 , 2 or 3!");
             * continue;
             * }
             */

            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear newline character

                if (choice == 1) {
                    // Scanner scanner = new Scanner(System.in);

                    System.out.println("\nAvailable countries: USA, China, Germany, Australia, New Zealand, Brazil");

                    // Input source and target country
                    System.out.print("\nEnter source country: ");
                    String sourceCountry = sc.nextLine().trim();

                    System.out.print("\nEnter target country: ");
                    String targetCountry = sc.nextLine().trim();

                    // Input local date and time
                    System.out.print(
                            "\nEnter local date and time in source country (yyyy-MM-ddTHH:mm), e.g., 2025-06-04T18:00: ");
                    String dateTime = sc.nextLine();
                    TimeConverterCountry.timeConverter(sourceCountry, targetCountry, dateTime);

                } else if (choice == 2) {

                    // Scanner sc = new Scanner(System.in);

                    System.out.print("\nEnter country: ");
                    String country = sc.nextLine();

                    System.out.print("Current date (yyyy-MM-dd): ");
                    String dateStr = sc.nextLine();

                    SeasonDeterminer.seasonDeterminer(country, dateStr);

                } else if (choice == 3) {
                    System.out.println("Goodbye!");
                } else {
                    System.out.println("Please enter only choice 1 , 2 or 3");
                }
            } catch (InputMismatchException e) { // if the user enters something that isn't an integer
                System.out.println("Invalid input. Please enter only number 1 , 2 or 3");
                sc.nextLine(); // clear the invalid input
            }
        } while (choice != 3);

        sc.close(); // close the scanner to free up system resources

    }
}
