package Steps;

import Data.LoginData;
import Data.RandomGenerator;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    RandomGenerator randomGenerator = new RandomGenerator();
    LoginData loginData = new LoginData();
    LoginPage loginPage;
    WebDriver driver;
    WebDriverWait wait;

    public LoginSteps(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginPage = new LoginPage(driver);
    }

    public LoginSteps clickLoginButton() {
        WebElement loginButton = loginPage.loginButton;
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return this;
    }

    public LoginSteps fillEmailInput() {
        WebElement emailInput = loginPage.emailInput;
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(randomGenerator.randomEmail);
        return this;
    }

    public LoginSteps fillPasswordInput() {
        WebElement passwordInput = loginPage.passwordInput;
        passwordInput.sendKeys(randomGenerator.randomPassword);
        return this;
    }

    public LoginSteps clickLoginInnerButton() {
        WebElement loginInnerButton = loginPage.loginInnerButton;
        wait.until(ExpectedConditions.elementToBeClickable(loginInnerButton));
        loginInnerButton.click();
        return this;
    }

    public LoginSteps checkLoginErrorMsg() {
        WebElement loginErrorMsgElement = loginPage.loginErrorMsgElement;
        wait.until(ExpectedConditions.visibilityOf(loginErrorMsgElement));
        if (!loginErrorMsgElement.getText().equals(loginData.loginErrorMsgText)) {
            throw new AssertionError("Login error message does not match expected");
        }
        return this;
    }

    public LoginSteps checkResetPasswordUsability() {
        WebElement resetPasswordElement = loginPage.resetPasswordElement;
        if (!resetPasswordElement.isEnabled()) {
            throw new AssertionError("Reset password element is not enabled");
        }
        return this;
    }
}
