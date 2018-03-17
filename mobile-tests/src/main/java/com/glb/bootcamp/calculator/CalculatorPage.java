package com.glb.bootcamp.calculator;

import com.glb.bootcamp.pageobject.PageObjectBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static com.glb.bootcamp.driver.Drivers.getDriver;
import static org.openqa.selenium.By.xpath;

/**
 * CalculatorPage - Implemented in class by trainees.
 */
public class CalculatorPage extends PageObjectBase {

    @AndroidFindBy(id = "op_add")
    private WebElement addButton;

    @AndroidFindBy(id = "eq")
    private WebElement equalsButton;

    @AndroidFindBy(id = "formula")
    private WebElement formulaEditText;

    /**
     * This method execute the add for two numbers.
     *
     * @param number1 the number1 as {@link String}
     * @param number2 the number1 as {@link String}
     * @return the {@link CalculatorPage}
     */
    public CalculatorPage add(String number1, String number2) {
        clickNumber(number1);
        clickOn(addButton);
        clickNumber(number2);
        clickOn(equalsButton);
        return this;
    }

    public String getResult() {
        return formulaEditText.getText();
    }

    private void clickNumber(String number) {
        for (char d : number.toCharArray()) {
            WebElement webElement = getDriver().getWebDriver().findElement(xpath("//*[contains(@resource-id, 'digit_" + d + "')]"));
            clickOn(webElement);
        }
    }
}
