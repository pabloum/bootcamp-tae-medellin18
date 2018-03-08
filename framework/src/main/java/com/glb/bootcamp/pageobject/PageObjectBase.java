package com.glb.bootcamp.pageobject;

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
        initElements(getDriver().getWebDriver(), this);
    }

    /**
     * @param url
     */
    public void goTo(String url) {
        getDriver().getWebDriver().get(url);
    }

    /**
     *
     */
    public void refresh() {
        getDriver().getWebDriver().navigate().refresh();
    }

    /**
     * @param webElement
     */
    public void clickOn(WebElement webElement) {
        isClickable(webElement).click();
    }

    /**
     * @param webElement
     * @param text
     */
    public void typeOn(WebElement webElement, String text) {
        isVisible(webElement).sendKeys(text);
    }

    /**
     * @param webElement
     * @param text
     */
    public void selectByText(WebElement webElement, String text) {
        getSelect(isVisible(isClickable(webElement))).selectByVisibleText(text);
    }

    /**
     * @param webElement
     * @return
     */
    private Select getSelect(WebElement webElement) {
        return new Select(webElement);
    }

}
