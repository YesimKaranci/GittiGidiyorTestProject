package com.yesim.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Test.feature"
        , glue = "com.yesim.test.tests")
public class CucumberRunner {

}

