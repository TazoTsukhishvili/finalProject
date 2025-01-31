package Pages;

import Data.RegistrationData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    WebDriver driver;
    RegistrationData registrationData = new RegistrationData();


    public WebElement loginButton;
    public WebElement createButton;
    public WebElement registrationTitle;
    public WebElement emailInput;
    public WebElement passwordInput;
    public WebElement repeatPasswordInput;
    public WebElement maleRadio;
    public WebElement femaleRadio;
    public WebElement nameInput;
    public WebElement surnameInput;
    public WebElement birthYearDropdown;
    public WebElement registrationButton;
    public WebElement phoneErrorMsg;
    public WebElement smsCodeErrorMsg;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.loginButton = driver.findElement(By.xpath("//*[text()='შესვლა']"));
        this.createButton = driver.findElement(By.xpath("//*[text()='შექმენი']"));
        this.registrationTitle = driver.findElement(By.xpath("//*[text()='" + registrationData.registrationExpectedTitle + "']"));
        this.emailInput = driver.findElement(By.id("email"));
        this.passwordInput = driver.findElement(By.id("password"));
        this.repeatPasswordInput = driver.findElement(By.id("PasswordRetype"));
        this.maleRadio = driver.findElement(By.xpath("//*[text()='მამრობითი']"));
        this.femaleRadio = driver.findElement(By.xpath("//*[text()='მდედრობითი']"));
        this.nameInput = driver.findElement(By.id("name"));
        this.surnameInput = driver.findElement(By.id("surname"));
        this.birthYearDropdown = driver.findElement(By.name("birth_year"));
        this.registrationButton = driver.findElement(By.id("registrationBtn"));
        this.phoneErrorMsg = driver.findElement(By.id("input-error-phone"));
        this.smsCodeErrorMsg = driver.findElement(By.id("input-error-sms_code"));
    }


    public void selectBirthYear(int yearIndex) {
        Select select = new Select(birthYearDropdown);
        select.selectByIndex(yearIndex);
    }
}
