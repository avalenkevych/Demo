package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class TransitTimeCalculatorPage extends BasePage {

    @FindBy(id = "origin-postcode")
    private WebElement originPostCode;

    @FindBy(id = "destination-postcode")
    private WebElement destinationPostCode;

    @FindBy(id = "origin-country")
    private WebElement originCountryDropdown;

    @FindBy(id = "destination-country")
    private WebElement destinationCountryDropdown;

    @FindBy(className = "js--freightcalc-se--input-submit")
    private WebElement calculateButton;

    @FindBy(xpath = "//*[contains(text(),'Choose a pick-up or delivery date from the calendar below to find our time table on road freight transport.')]")
    private WebElement successMessage;

    @FindBy(className = "js--origin-zip-error")
    private WebElement originError ;

    @FindBy(className = "js--destination-zip-error")
    private WebElement destinationError;


    public TransitTimeCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private void selectDropdownValue(WebElement dropdownElement, String value) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    public void enterOriginAndDestination(String originCountry, String destinationCountry, String postCodeOrigin, String postCodeDestination) {
        selectDropdownValue(originCountryDropdown, originCountry);
        selectDropdownValue(destinationCountryDropdown, destinationCountry);

        originPostCode.clear();
        originPostCode.sendKeys(postCodeOrigin);

        destinationPostCode.clear();
        destinationPostCode.sendKeys(postCodeDestination);
    }

    public void clickCalculate() {
        calculateButton.click();
    }

    public String getSuccessMessage() {
        WebElement loadedComponent = wait.until(
                ExpectedConditions.visibilityOf(successMessage));
        return loadedComponent.getText();
    }

    public String getOriginError() {
       return originError.getText();
    }
    public String getDestinationError() {
        return destinationError.getText();
    }
}