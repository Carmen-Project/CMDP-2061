import org.junit.*; // unit test import
import org.junit.runner.RunWith; // unit test import
import org.junit.runners.JUnit4; // unit test import

import static org.junit.Assert.*; // unit test import

import java.io.*;

@RunWith(JUnit4.class) // unit test import

public class UserInterfaceMenuTest_JUnit {

    @Test
    public void testTimeConverterCountry() {

        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        /*
         * Attempt for input data test
         * 1
         * USA
         * Brazil
         * 2025-06-04T18:00
         * 
         */

        System.setIn(new ByteArrayInputStream("1\nUSA\nBrazil\n2025-06-04T18:00\3".getBytes()));

        UserInterfaceMenu.main(new String[] {}); // Production code

        String output = capOut.toString();

        assertTrue("Test for TimeConverter", output.contains("Target Zoned Time: 2025-06-04 19:00:00 BRT"));

    }

    @Test
    public void testSeasonDeterminer() {

        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        /*
         * Attempt for input data test
         * 2
         * USA
         * 2-25-06-04
         * 
         * 
         */

        System.setIn(new ByteArrayInputStream("2\nUSA\n2025-06-04\3".getBytes()));

        UserInterfaceMenu.main(new String[] {}); // Production code

        String output = capOut.toString();

        assertTrue("Test for SeasonDeterminer", output.contains("Current season in USA: Spring"));

    }

    @Test
    public void testExitChoice() {

        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("3\n".getBytes()));

        UserInterfaceMenu.main(new String[] {}); // Production code

        String output = capOut.toString();

        assertTrue("Exit Program", output.contains("Goodbye!"));
    }

    @Test
    public void testOutofRange() {

        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("5\n\3".getBytes()));

        UserInterfaceMenu.main(new String[] {}); // Production code

        String output = capOut.toString();

        assertTrue("Test for OutofRange", output.contains("Please enter only choice 1 , 2 or 3"));

    }

    @Test
    public void testNegativeInput() {

        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("-1\n\3".getBytes()));

        UserInterfaceMenu.main(new String[] {}); // Production code

        String output = capOut.toString();

        assertTrue("Test for Negative Input", output.contains("Please enter only choice 1 , 2 or 3"));

    }

    @Test
    public void testNonNumericInput() {

        ByteArrayOutputStream capOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capOut));

        System.setIn(new ByteArrayInputStream("a@\n\3".getBytes()));

        UserInterfaceMenu.main(new String[] {}); // Production code

        String output = capOut.toString();

        assertTrue("Test for NonNumericInput", output.contains("Invalid input. Please enter only number 1 , 2 or 3"));

    }

}
