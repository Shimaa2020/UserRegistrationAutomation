import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignupPage;

import java.util.Random;

public class RegistrationFlowTest extends BaseTest {

    private SignupPage signupPage;
    private RegistrationPage registrationPage;
    private HomePage homePage;
    private AccountCreatedPage accountCreatedPage;

    @Test(dataProvider = "userData")
    public void verifyUserRegistrationFlow(String name, String email, String password, String day, String month, String year,
                                           String firstName, String lastName, String company, String address,
                                           String country, String state, String city, String zipcode, String mobile) {

        test = extent.createTest("testRegistration");

        signupPage = new SignupPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);

        homePage.clickSignupSignin();
        signupPage.enterName(name);
        test.info("Entered name: " + name);
        signupPage.enterEmail(email);
        test.info("Entered email: " + email);

        signupPage.clickSignup();
        test.info("Clicked on Signup button.");

        registrationPage.selectTitle("MR");
        registrationPage.enterPassword(password);
        registrationPage.selectDateOfBirth(day, month, year);
        registrationPage.enterAddressInformation(firstName, lastName, company, address, country, state, city, zipcode, mobile);
        registrationPage.clickCreateAccount();
        test.info("Account creation form submitted.");

        Assert.assertTrue(driver.getCurrentUrl().contains("account_created"), "Account creation failed, URL mismatch.");
        test.pass("Account created successfully.");

        accountCreatedPage.clickContinue();
        test.info("Clicked on Continue after account creation.");

        homePage.clicklogout();
        test.info("Clicked on Logout.");
    }

    @DataProvider(name = "userData")
    public Object[][] getData() {
        Random random = new Random();

        String randomName = "testuser" + random.nextInt(1000);
        String randomEmail = "testemail" + random.nextInt(1000) + "@AFAQY.com";
        String randomPassword = "Pass" + random.nextInt(1000);
        String randomDay = String.valueOf(random.nextInt(31) + 1);
        String randomMonth = String.valueOf(random.nextInt(12) + 1);
        String randomYear = String.valueOf(random.nextInt(122) + 1900);
        String firstName = "First" + random.nextInt(1000);
        String lastName = "Last" + random.nextInt(1000);
        String company = "Company" + random.nextInt(1000);
        String address = "Address " + random.nextInt(1000);
        String country = "India";
        String state = "State" + random.nextInt(100);
        String city = "City" + random.nextInt(100);
        String zipcode = String.valueOf(random.nextInt(90000) + 10000);
        String mobile = "987654" + random.nextInt(10000);

        return new Object[][]{
                {
                        randomName, randomEmail, randomPassword, randomDay, randomMonth, randomYear,
                        firstName, lastName, company, address, country, state, city, zipcode, mobile
                }
        };
    }


}
