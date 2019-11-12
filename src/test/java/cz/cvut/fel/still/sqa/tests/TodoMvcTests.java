package cz.cvut.fel.still.sqa.tests;

import cz.cvut.fel.still.sqa.page_objects.todo.TodoPage;
import cz.cvut.fel.still.sqa.seleniumStarterPack.DriverBase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TodoMvcTests extends DriverBase {
    @Test
    @Order(1)
    public void createTodo() {
        TodoPage todoPage = new TodoPage(driver);
        todoPage.goTo();
        todoPage.waitFor();
        todoPage.createTodo("My first todo");

        assertThat(driver.findElement(By.cssSelector("ul.todo-list li:first-child")).getText())
                .isEqualToIgnoringCase("My first todo");
    }

    @Test
    @Order(2)
    public void editTodo() {
        TodoPage todoPage = new TodoPage(driver);
        todoPage.editTodo(0," (edited)");

        assertThat(driver.findElement(By.cssSelector("ul.todo-list li:first-child")).getText())
                .isEqualToIgnoringCase("My first todo (edited)");
    }

    @Test
    @Order(3)
    public void deleteTodo() {
        TodoPage todoPage = new TodoPage(driver);
        todoPage.deleteTodo(0);

        assertThat(driver.findElements(By.cssSelector("ul.todo-list li:first-child")))
                .isEmpty();
    }

}
