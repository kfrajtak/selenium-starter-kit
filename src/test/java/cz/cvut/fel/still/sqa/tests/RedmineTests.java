package cz.cvut.fel.still.sqa.tests;

import cz.cvut.fel.still.sqa.seleniumStarterPack.DriverBase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RedmineTests extends DriverBase {

    @Test
    @Order(1)
    public void step1_loginTest() {
        driver.get("http://demo.redmine.org");
        driver.findElement(By.linkText("Sign in")).click();

        waitForElement(driver, By.id("username"));

        driver.findElement(By.id("username"))
                .sendKeys("testuser1358");
        driver.findElement(By.id("password"))
                .sendKeys("testit135");
        driver.findElement(By.name("login")).click();
    }


    @Test
    @Order(2)
    public void step2_projectTest() {
        // FIND TESTING PROJECT
        driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.linkText("TestingProjectTraining")).click();

        // CHECK NUMBER OF BUGS
        WebElement bugsLinkElement = driver.findElement(By.linkText("Bug"));
        WebElement bugsStatsElement = bugsLinkElement.findElement(By.xpath("parent::node()"));
        String bugsStatusString = bugsStatsElement.getText();
        String totalBugsCount = bugsStatusString.substring(bugsStatusString.indexOf("/") + 1).trim();
        int totalBugsCountNumber = Integer.valueOf(totalBugsCount);

        assertThat(totalBugsCountNumber).isGreaterThan(20);//"Log message: totalBugsCountNumber is less than 20");
    }

    @Test
    @Order(3)
    public void step3_logoutTest() {
        driver.findElement(By.linkText("Sign out")).click();
    }
}
