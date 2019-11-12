package cz.cvut.fel.still.sqa.tests;

import cz.cvut.fel.still.sqa.page_objects.redmine.LoginPage;
import cz.cvut.fel.still.sqa.seleniumStarterPack.DriverBase;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class RedmineTestsWithPageObject extends DriverBase {

    @Test
    @Order(1)
    public void step1_loginTest() {
        LoginPage loginPage = LoginPage.goTo("http://demo.redmine.org", driver);

        loginPage
                .enterUserName("testuser1358")
                .enterPassword("testit135")
                .login();
    }

    @Order(2)
    public void step2_projectTest() {
        LoginPage loginPage = new LoginPage(driver);
        //ProjectsPage projectsPage = loginPage.goToProjects();
        //projectsPage.waitFor();

        // FIND TESTING PROJECT
        driver.findElement(By.linkText("TestingProjectTraining")).click();

        // CHECK NUMBER OF BUGS
        WebElement bugsLinkElement = driver.findElement(By.linkText("Bug"));
        WebElement bugsStatsElement = bugsLinkElement.findElement(By.xpath("parent::node()"));
        String bugsStatusString = bugsStatsElement.getText();
        String totalBugsCount = bugsStatusString.substring(bugsStatusString.indexOf("/") + 1).trim();
        int totalBugsCountNumber = Integer.valueOf(totalBugsCount);

        assertThat(totalBugsCountNumber).isGreaterThan(20);//"Log message: totalBugsCountNumber is less than 20");
    }

    @Order(3)
    public void step3_logoutTest() {
        driver.findElement(By.linkText("Sign out")).click();
    }
}
