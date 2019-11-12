package cz.cvut.fel.still.sqa.page_objects.todo;

import cz.cvut.fel.still.sqa.page_objects.redmine.BasePage;
import cz.cvut.fel.still.sqa.seleniumStarterPack.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TodoPage extends BasePage {
    private final By newTodoBy = By.id("new-todo");

    @FindBy(id = "new-todo")
    private WebElement newTodoElement;

    public TodoPage(WebDriver driver) {
        super(driver);
    }

    public void goTo() {
        driver.get("http://todomvc.com/examples/polymer/index.html");
    }

    public List<WebElement> getTodos() {
        return driver.findElements(By.cssSelector("ul.todo-list li"));
    }

    public void createTodo(String todo) {
        int before = getTodos().size();

        newTodoElement.sendKeys(todo);
        newTodoElement.sendKeys(Keys.RETURN);

        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<Boolean>) d -> getTodos().size() == before + 1);
    }

    public void editTodo(int index, String newValue) {
        // find all todos
        List<WebElement> todos = getTodos();
        // get todo at index
        WebElement todo = todos.get(index);
        // double click it to edit
        WebElement label = todo.findElement(By.cssSelector("label.td-item"));
        Actions action = new Actions(driver);
        action.doubleClick(label).build().perform();
        WebElement edit = todo.findElement(By.id("edit"));
        edit.sendKeys(newValue);
        edit.sendKeys(Keys.RETURN);
    }

    public void deleteTodo(int index) {
        // find all todos
        List<WebElement> todos = getTodos();
        // get todo at index
        WebElement todo = todos.get(index);
        // double click it to edit
        WebElement button = todo.findElement(By.cssSelector("button.destroy"));
        button.click();
        /*Actions actions = new Actions(driver);
        actions.moveToElement(button);
        actions.click().build().perform();*/
    }

    @Override
    public void waitFor() {
         DriverBase.waitForElement(driver, newTodoBy);
    }

    public void markAsCompleted(int index) {

    }
}
