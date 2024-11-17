package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final By ACCEPT_COOKIES_BUTTON = By.id("onetrust-accept-btn-handler");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void acceptCookies() {
        WebElement acceptCookiesButton = wait.until(
                ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BUTTON)
        );
        acceptCookiesButton.click();
    }
}