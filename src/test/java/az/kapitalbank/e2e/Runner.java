package az.kapitalbank.e2e;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.springframework.test.context.ContextConfiguration;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "classpath:features",
        plugin = { "pretty", "html:target/cucumber", "json:target/json/cucumber.json" })
public class Runner {
}
