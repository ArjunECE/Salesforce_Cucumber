package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
@CucumberOptions(features="src/test/java/features/Salesforce_S07_30_CreateAccounts.feature", glue = "steps",monochrome = true, dryRun = true, snippets = SnippetType.CAMELCASE)
public class Salesforce_S07_30_CreateAccounts extends AbstractTestNGCucumberTests{

}
