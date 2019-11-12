package cz.cvut.fel.still.sqa.tests;

import cz.cvut.fel.still.sqa.seleniumStarterPack.DriverBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestGoogle extends DriverBase {

    private void googleExampleThatSearchesFor(final String searchString) {
        driver.get("http://www.google.com");

        WebElement searchField = driver.findElement(By.id("lst-ib"));

        searchField.clear();
        searchField.sendKeys(searchString);

        System.out.println("Page title is: " + driver.getTitle());

        searchField.submit();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                (ExpectedCondition<Boolean>) d -> d.getTitle()
                        .toLowerCase()
                        .startsWith(searchString.toLowerCase()));

        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void googleCheeseExample() throws Exception {
        googleExampleThatSearchesFor("Cheese!");
    }

    @Test
    public void googleMilkExample() throws Exception {
        googleExampleThatSearchesFor("Milk!");
    }
}
