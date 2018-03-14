package com.glb.bootcamp.bdd.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber"},
        features = {"src/test/resources"},
        glue = "com.glb.bootcamp.bdd.steps"
)
public class Runner {
}
