package com.glb.bootcamp.calculator.steps;

import com.glb.bootcamp.calculator.CalculatorPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

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
