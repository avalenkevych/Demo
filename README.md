
# Selenium Automated Tests for DHL European Road Freight Transit Time Calculator

This project demonstrates basic automated tests for the **DHL European Road Freight Transit Time Calculator** page. The classes provide methods for interacting with the page elements, and the test class uses **JUnit 5** to verify the behavior of the calculator for valid and invalid inputs.

## How to Run the Project

### Prerequisites

1. **Java 11+** should be installed on your machine.
2. **Gradle** should be installed or use the Gradle wrapper.
3. **ChromeDriver** is required for running tests on Chrome. It can be downloaded from [here](https://sites.google.com/a/chromium.org/chromedriver/).

### Steps

1. Clone the repository to your local machine.
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory and install the dependencies:
   ```bash
   gradle build
   ```

3. Run the tests using the following command:
   ```bash
   gradle test
   ```
