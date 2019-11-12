package cz.cvut.fel.still.sqa.page_objects;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public abstract class BasePage {

    protected RemoteWebDriver driver;

    public BasePage() throws MalformedURLException {
        //driver = DriverBase.getDriver();
    }
}