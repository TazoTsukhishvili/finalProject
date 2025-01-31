package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class LoginPage {

    WebDriver driver;

    public WebElement loginButton;
    public WebElement emailInput;
    public WebElement passwordInput;
    public WebElement loginInnerButton;
    public WebElement loginErrorMsgElement;
    public WebElement resetPasswordElement;

    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.loginButton = driver.findElement(By.xpath("//*[text()='შესვლა']"));
        this.emailInput = driver.findElement(By.id("Email"));
        this.passwordInput = driver.findElement(By.xpath("//div[@id='login-container']//input[@name='Password']"));
        this.loginInnerButton = driver.findElement(By.xpath("//*[text()='შესვლა']"));
        this.loginErrorMsgElement = driver.findElement(By.id("input-error-Password"));
        this.resetPasswordElement = driver.findElement(By.xpath("//*[text()='პაროლის აღდგენა']"));
    }
}
