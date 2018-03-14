Feature: Login

Scenario: Successful login in Facebook
Given I navigate to "http://www.facebook.com"
When I type the username "" and the password ""
Then I'm successfully logged in into Facebook