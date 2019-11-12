package cz.cvut.fel.still.sqa.page_objects.redmine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(how = How.ID, using = "username")
    private WebElement userNameInputElement;

    @FindBy(id = "password")
    private WebElement passwordInputElement;

    @FindBy(name = "login")
    private WebElement loginButtonElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitFor()
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) driver1 -> driver1.findElement(By.id("username")).isDisplayed());
    }

    public static LoginPage goTo(String baseUrl, WebDriver driver) {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Sign in")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitFor();
        return loginPage;
    }

    public LoginPage enterUserName(String userName) {
        userNameInputElement.clear();
        userNameInputElement.sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInputElement.clear();
        passwordInputElement.sendKeys(password);
        return this;
    }

    public void login() {
        loginButtonElement.click();
    }

    public ProjectsPage goToProjects() {
        driver.findElement(By.linkText("Projects")).click();
        return new ProjectsPage(driver);
    }
}
