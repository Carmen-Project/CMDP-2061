public class TimeConverterTest {
    public static void main(String[] args) {
        testTimeConverter();
    }
    
    public static void testTimeConverter() {
        String [] sourceCountry = {"USA", "China", "Germany", "Australia"};
        String [] targetCountry = {"Australia", "New Zealand", "Brazil", "USA"};
        String [] dateTime = {"2025-06-04T18:00", "2025-06-04T10:00", "2025-12-25T12:00", null};
        String [] expected = {"Target Local Time: 08:00", "Target Local Time: 14:00", "Target Local Time: 07:00", "Invalid input"};
        
        for (int i = 0; i < sourceCountry.length; i++) {
            String actual = TimeConverterGet.getTargetLocalTime(sourceCountry[i], targetCountry[i], dateTime[i]);
            if (actual.equals(expected[i])) {
                    System.out.println("Test " + (i + 1) + " passed: " + actual);
                } else {
                    System.out.println("Test " + (i + 1) + " FAILED");
                    System.out.println("  Expected: " + expected[i]);
                    System.out.println("  Actual:   " + actual);
                }
        }
    }    
}
