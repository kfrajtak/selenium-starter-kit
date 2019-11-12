package cz.cvut.fel.still.sqa.page_objects.redmine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsPage extends BasePage {

    @FindAll(@FindBy(css = "ul.projects li"))
    public List<WebElement> projectWebElements;

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitFor() {

    }

    public ProjectDetail getProjectDetail(String projectName)
    {
        // TODO
        return null;
    }
}
