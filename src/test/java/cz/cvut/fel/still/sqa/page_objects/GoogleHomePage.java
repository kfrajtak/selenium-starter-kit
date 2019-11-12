package cz.cvut.fel.still.sqa.page_objects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class GoogleHomePage extends BasePage {

    private Query searchBar = new Query(By.name("q"), driver);
    private Query googleSearch = new Query(By.name("btnK"), driver);
    private Query imFeelingLucky = new Query(By.name("btnI"), driver);

    public GoogleHomePage() throws MalformedURLException {
    }

    public GoogleHomePage enterSearchTerm(String searchTerm) {
        searchBar.findWebElement().clear();
        searchBar.findWebElement().sendKeys(searchTerm);

        return this;
    }

    public GoogleHomePage submitSearch() {
        googleSearch.findWebElement().submit();

        return this;
    }

    public void getLucky() {
        imFeelingLucky.findWebElement().click();
    }

}