import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TimeConverterGet {

    private static final Map<String, Integer> gmt = new HashMap<>();

    static {
        gmt.put("USA", -4);
        gmt.put("China", 8);
        gmt.put("Germany", 2);
        gmt.put("Australia", 10);
        gmt.put("New Zealand", 12);
        gmt.put("Brazil", -3);
    }

    public static String getTargetLocalTime(String sourceCountry, String targetCountry, String dateTime) {
        try {
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
            int timeDiff = gmt.get(targetCountry) - gmt.get(sourceCountry);
            int sourceTime = localDateTime.getHour();
            LocalDate targetDate = localDateTime.toLocalDate();
            
            int targetTime = sourceTime + timeDiff;

            if (targetTime >= 24) {
                targetTime %= 24;
                targetDate = targetDate.plusDays(1);
            } else if (targetTime < 0) {
                targetTime = (24 + targetTime) % 24;
                targetDate = targetDate.minusDays(1);
            }

            return String.format("Target Local Time: %02d:00", targetTime);
        } catch (Exception e) {
            return "Invalid input";
        }
    }

}

