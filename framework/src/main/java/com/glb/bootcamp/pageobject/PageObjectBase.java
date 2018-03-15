package com.glb.bootcamp.pageobject;

import com.glb.bootcamp.driver.Driver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.glb.bootcamp.driver.Drivers.getDriver;
import static com.glb.bootcamp.waits.Waits.isClickable;
import static com.glb.bootcamp.waits.Waits.isVisible;
import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * PageObjectBase.
 */
public class PageObjectBase {

    /**
     * Default constructor for creating an instance of a PO class, using PageFactory.
     */
    public PageObjectBase() {
        Driver driver = getDriver();
        switch (driver.getPlatform()) {
            case WEB:
                initElements(driver.getWebDriver(), this);
                break;
            case MOBILE:
                initElements(new AppiumFieldDecorator(driver.getWebDriver()), this);
                break;
        }
    }

    /**
     * Navigates to the URL.
     *
     * @param url the URL
     */
    public void goTo(String url) {
        getDriver().getWebDriver().get(url);
    }

    /**
     * Refresh the page.
     */
    public void refresh() {
        getDriver().getWebDriver().navigate().refresh();
    }

    /**
     * Clicks on the element.
     *
     * @param webElement the {@link WebElement}
     */
    public void clickOn(WebElement webElement) {
        isClickable(webElement).click();
    }

    /**
     * Types on the element.
     *
     * @param webElement the {@link WebElement}
     * @param text       the text
     */
    public void typeOn(WebElement webElement, String text) {
        isVisible(webElement).sendKeys(text);
    }

    /**
     * Selects an option by text from an HTML Select.
     *
     * @param webElement the {@link WebElement}
     * @param text       the text to select
     */
    public void selectByText(WebElement webElement, String text) {
        getSelect(isVisible(isClickable(webElement))).selectByVisibleText(text);
    }

    private Select getSelect(WebElement webElement) {
        return new Select(webElement);
    }

}
