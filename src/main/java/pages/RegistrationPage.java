package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    WebDriver driver;


    By titleMr = By.id("id_gender1");
    By titleMiss = By.id("id_gender2");
    By passwordField = By.name("password");
    By dayDropdown = By.name("days");
    By monthDropdown = By.name("months");
    By yearDropdown = By.name("years");
    By firstNameField = By.name("first_name");
    By lastNameField = By.name("last_name");
    By companyField = By.name("company");
    By addressField = By.name("address1");
    By countryDropdown = By.name("country");
    By stateField = By.name("state");
    By cityField = By.name("city");
    By zipcodeField = By.name("zipcode");
    By mobileNumberField = By.name("mobile_number");
    By createAccountButton = By.xpath("//button[contains(text(), 'Create Account')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            driver.findElement(titleMr).click();
        } else {
            driver.findElement(titleMiss).click();
        }
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
    }

    public void enterAddressInformation(String firstName, String lastName, String company, String address,
                                        String country, String state, String city, String zipcode, String mobile) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(companyField).sendKeys(company);
        driver.findElement(addressField).sendKeys(address);
        new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipcodeField).sendKeys(zipcode);
        driver.findElement(mobileNumberField).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

}
