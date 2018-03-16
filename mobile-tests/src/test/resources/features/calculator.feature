Feature: Android Calculator

Scenario: Add two number in the Android Calculator

Given I open the Android Calculator
When I add "10000" and "5000"
Then The result is "15000"