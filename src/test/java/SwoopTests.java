

import Steps.LoginSteps;
import Steps.RegistrationSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SwoopTests {

    WebDriver driver;

    @BeforeMethod
    public void openChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.swoop.ge/");
    }

    @Test(description = "test1 - validate loginPage while using the random creds", testName = "Login Page Validation")
    public void LoginAttemptTest() throws InterruptedException {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps
                .clickLoginButton()
                .fillEmailInput()
                .fillPasswordInput()
                .clickLoginInnerButton()
                .checkLoginErrorMsg()
                .checkResetPasswordUsability();
    }

    @Test(description = "test2 - validate phoneNumber while creating a new account", dependsOnMethods = "LoginAttemptTest", testName = "Phone Number Validation")
    public void CreateAccountTest() {
        RegistrationSteps registrationSteps = new RegistrationSteps(driver);
        registrationSteps
                .clickLoginButton()
                .clickCreateButton()
                .checkRegistrationTitle()
                .fillEmailInput()
                .fillPasswordInput()
                .fillRepeatPasswordInput()
                .selectGender("male")
                .fillNameInput()
                .fillSurnameInput()
                .setBirthYear(27)
                .scrollDown()
                .confirmConditions()
                .clickRegistrationButton()
                .checkPhoneErrorMsgText()
                .checkSmsCodeErrorMsgText();
    }

    @AfterMethod
    public void closeChrome() {
        if (driver != null) {
            driver.quit();
        }
    }
}
