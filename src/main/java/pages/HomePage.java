package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    private By signup_signinButton = By.xpath("//a[@href='/login']");
    private By logoutButton = By.xpath("//a[@href='/logout']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupSignin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signupSigninElement = wait.until(ExpectedConditions.elementToBeClickable(signup_signinButton));
        signupSigninElement.click();
    }

    public void clicklogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signupSigninElement = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        signupSigninElement.click();
    }

}
