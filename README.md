# UserRegistrationAutomation
"Automation script for testing user registration flow using Selenium WebDriver, TestNG, and Page Object Model with data-driven testing and detailed test report."

##Technologies Used:
-Selenium WebDriver
-TestNG
-Page Object Model (POM)
-Data-driven testing
-Extent Reports


##Prerequisites:
-Java Development Kit (JDK) 8 or higher
-IntelliJ IDEA or any Java IDE
-Selenium WebDriver
-TestNG framework
-ChromeDriver
-Data-Driven Testing:
The project uses TestNG's @DataProvider to implement data-driven testing. Dynamic test data is generated for each test run, ensuring unique values for:
-Username
-Email
-Password
-Address details


##Extent Reports:
After running the tests, an Extent Report is generated in the target/reports/extent-report directory.

##Run the Test with TestNG:
You can run the tests in two ways:

Open the RegistrationFlowTest class in your IDE and right-click on the test class RegistrationFlowTest > Run 'RegistrationFlowTest'.
Alternatively, you can run the tests from the testng.xml file by right-clicking on it and selecting Run 'testng.xml'.
