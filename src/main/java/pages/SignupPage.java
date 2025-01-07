package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignupPage {

    WebDriver driver;
    private By nameField = By.name("name");
    private By emailField = By.xpath("(//input[@type='email'])[2]");
    private By signupButton = By.xpath("//button[text()='Signup']");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSignup() {
        driver.findElement(signupButton).click();
    }

    public boolean isRedirectedToRegistrationPage() {
        return driver.getCurrentUrl().contains("register");
    }
}
