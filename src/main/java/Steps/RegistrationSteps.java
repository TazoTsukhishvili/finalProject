package Steps;

import Data.RandomGenerator;
import Data.RegistrationData;
import Pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class RegistrationSteps {

    RandomGenerator randomGenerator = new RandomGenerator();
    RegistrationData registrationData = new RegistrationData();
    RegistrationPage registrationPage;
    WebDriver driver;

    // Constructor to initialize WebDriver and RegistrationPage
    public RegistrationSteps(WebDriver driver) {
        this.driver = driver;
        this.registrationPage = new RegistrationPage(driver);
    }

    // Click the login button
    public RegistrationSteps clickLoginButton() {
        registrationPage.loginButton.click();
        return this;
    }

    // Click the "Create" button to start registration
    public RegistrationSteps clickCreateButton() {
        registrationPage.createButton.click();
        return this;
    }

    // Check if the registration title is displayed
    public RegistrationSteps checkRegistrationTitle() {
        WebElement title = registrationPage.registrationTitle;
        if (!title.isDisplayed()) {
            throw new AssertionError("Registration title is not displayed");
        }
        return this;
    }

    // Fill the email input
    public RegistrationSteps fillEmailInput() {
        registrationPage.emailInput.sendKeys(randomGenerator.randomEmail);
        return this;
    }

    // Fill the password input
    public RegistrationSteps fillPasswordInput() {
        registrationPage.passwordInput.sendKeys(randomGenerator.randomPassword);
        return this;
    }

    // Fill the repeat password input
    public RegistrationSteps fillRepeatPasswordInput() {
        registrationPage.repeatPasswordInput.sendKeys(randomGenerator.randomPassword);
        return this;
    }

    // Select gender (male/female)
    public RegistrationSteps selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            registrationPage.maleRadio.click();
        } else {
            registrationPage.femaleRadio.click();
        }
        return this;
    }

    // Fill name input
    public RegistrationSteps fillNameInput() {
        registrationPage.nameInput.sendKeys(randomGenerator.randomName);
        return this;
    }

    // Fill surname input
    public RegistrationSteps fillSurnameInput() {
        registrationPage.surnameInput.sendKeys(randomGenerator.randomSurname);
        return this;
    }

    // Set the birth year dropdown value
    public RegistrationSteps setBirthYear(int yearIndex) {
        registrationPage.selectBirthYear(yearIndex);
        return this;
    }

    // Scroll the page down
    public RegistrationSteps scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");
        return this;
    }

    // Confirm conditions (checkboxes)
    public RegistrationSteps confirmConditions() {
        WebElement condition1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement condition2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        condition1.click();
        condition2.click();
        return this;
    }

    // Click the registration button
    public RegistrationSteps clickRegistrationButton() {
        registrationPage.registrationButton.click();
        return this;
    }

    // Check if the phone error message is displayed and matches expected text
    public RegistrationSteps checkPhoneErrorMsgText() {
        WebElement phoneError = registrationPage.phoneErrorMsg;
        if (!phoneError.getText().equals(registrationData.phoneErrorMsgText)) {
            throw new AssertionError("Phone error message doesn't match");
        }
        return this;
    }

    // Check if the SMS code error message is displayed and matches expected text
    public RegistrationSteps checkSmsCodeErrorMsgText() {
        WebElement smsError = registrationPage.smsCodeErrorMsg;
        if (!smsError.getText().equals(registrationData.smsCodeErrorMsgText)) {
            throw new AssertionError("SMS code error message doesn't match");
        }
        return this;
    }
}
