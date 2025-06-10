import java.time.LocalDate;

public class SeasonDeterminerGet {

    public String getHemisphere(String country) {
        if (country == null) {
            return "Unknown";
        }

        country = country.trim().toLowerCase();

        if (country.equals("usa") || country.equals("china") || country.equals("japan") ||
            country.equals("canada") || country.equals("uk") || country.equals("germany")) {
            return "Northern";
        } else if (country.equals("australia") || country.equals("new zealand") ||
                country.equals("brazil") || country.equals("argentina") || country.equals("south africa")) {
            return "Southern";
        } else {
            return "Unknown";
        }
    }

    public String getSeason(LocalDate date, String hemisphere) {
        if (date == null || hemisphere == null || hemisphere.equals("Unknown")) {
            return "Invalid country or hemisphere";
        }

        int month = date.getMonthValue();

        if (hemisphere.equals("Northern")) {
            if (month == 12 || month == 1 || month == 2) {
                return "Winter ❄️❄️";
            } else if (month >= 3 && month <= 5) {
                return "Spring 🌸🌸";
            } else if (month >= 6 && month <= 8) {
                return "Summer ☀️☀️";
            } else {
                return "Autumn 🍂🍂";
            }
        } else if (hemisphere.equals("Southern")) {
            if (month == 12 || month == 1 || month == 2) {
                return "Summer ☀️☀️";
            } else if (month >= 3 && month <= 5) {
                return "Autumn 🍂🍂";
            } else if (month >= 6 && month <= 8) {
                return "Winter ❄️❄️";
            } else {
                return "Spring 🌸🌸";
            }
        }

        return "Invalid country or hemisphere";
    }
}
