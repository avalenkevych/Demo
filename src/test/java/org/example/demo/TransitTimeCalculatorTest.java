package org.example.demo;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.TransitTimeCalculatorPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransitTimeCalculatorTest {

    private WebDriver driver;
    private TransitTimeCalculatorPage calculatorPage;

    private static final String CALCULATOR_URL = "https://www.dhl.com/se-en/home/freight/tools/european-road-freight-transit-time-calculator.html";

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        calculatorPage = new TransitTimeCalculatorPage(driver);
        calculatorPage.openPage(CALCULATOR_URL);
        calculatorPage.acceptCookies();
    }


    @Test
    @DisplayName("Verify Transit Times for Valid Inputs")
    void testValidInputs() {
        // Enter valid origin and destination details
        calculatorPage.enterOriginAndDestination("SE", "SE", "98499", "98499");
        calculatorPage.clickCalculate();

        String expectedMessage = "Choose a pick-up or delivery date from the calendar below to find our time table on road freight transport.";
        assertEquals(expectedMessage, calculatorPage.getSuccessMessage(), "The success message did not match.");
    }

    @Test
    @DisplayName("Verify Error for Missing Origin and Destination")
    void testMissingOriginAndDestination() {
        calculatorPage.enterOriginAndDestination("SE", "SE", "", "");
        calculatorPage.clickCalculate();

        String expectedErrorMessage = "Correct postal code (e.g. no post box)*";
        assertAll("Error Messages",
                () -> assertEquals(expectedErrorMessage, calculatorPage.getOriginError(), "Origin error message did not match."),
                () -> assertEquals(expectedErrorMessage, calculatorPage.getDestinationError(), "Destination error message did not match.")
        );
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}