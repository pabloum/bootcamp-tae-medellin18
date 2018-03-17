package com.glb.bootcamp.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.glb.bootcamp.steps", tags = {"addNewContact"})
public class Runner {
}
