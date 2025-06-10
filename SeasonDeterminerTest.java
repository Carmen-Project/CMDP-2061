import java.time.LocalDate;

public class SeasonDeterminerTest {
    public static void main(String[] args) {
        testSeasonDeterminer();
    }

    public static void testSeasonDeterminer() {
        String[] countries = {
            "USA", "Australia", "Germany", "Brazil", "Japan", "Argentina", "UnknownLand", null
        };

        String[] dates = {
            "2025-01-15", // Winter in Northern
            "2025-01-15", // Summer in Southern
            "2025-04-10", // Spring in Northern
            "2025-07-20", // Winter in Southern
            "2025-09-05", // Autumn in Northern
            "2025-11-25", // Spring in Southern
            "2025-06-30", // Unknown country
            "2025-03-10"  // null country
        };

        String[] expected = {
            "Winter ❄️❄️",
            "Summer ☀️☀️",
            "Spring 🌸🌸",
            "Winter ❄️❄️",
            "Autumn 🍂🍂",
            "Spring 🌸🌸",
            "Invalid country or hemisphere",
            "Invalid country or hemisphere"
        };

        SeasonDeterminerGet sd = new SeasonDeterminerGet();

        for (int i = 0; i < countries.length; i++) {
            String hemisphere = sd.getHemisphere(countries[i]);
            LocalDate date = LocalDate.parse(dates[i]);
            String season = sd.getSeason(date, hemisphere);
            if (season.equals(expected[i])) {
                System.out.println("Test " + (i + 1) + " passed ");
            } else {
                System.out.println("Test " + (i + 1) + " failed ");
                System.out.println("Country: " + countries[i]);
                System.out.println("Date: " + dates[i]);
                System.out.println("Expected: " + expected[i]);
                System.out.println("Got: " + season);
            }
        }
    }
}
