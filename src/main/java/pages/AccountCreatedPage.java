package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {

    WebDriver driver;

    private By contiuebtn = By.xpath("//a[text()='Continue']");


    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContinue() {
        driver.findElement(contiuebtn).click();
    }
}
