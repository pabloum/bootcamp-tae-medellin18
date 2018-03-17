package com.glb.bootcamp.steps.calculator;

import com.glb.bootcamp.calculator.CalculatorPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;

/**
 * CalculatorSteps - Implemented in class by trainees.
 */
public class CalculatorSteps {

    private CalculatorPage calculatorPage;

    @Given("^I open the Android Calculator$")
    public void openCalculator() {
        calculatorPage = new CalculatorPage();
    }

    @When("^I add \"([^\"]*)\" and \"([^\"]*)\"$")
    public void addTwoNumbers(String number1, String number2) {
        calculatorPage.add(number1, number2);
    }

    @Then("^The result is \"([^\"]*)\"$")
    public void theResultIs(String result) {
        assertEquals(calculatorPage.getResult(), result, "");
    }


}
