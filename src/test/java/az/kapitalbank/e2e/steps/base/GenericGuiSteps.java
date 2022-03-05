package az.kapitalbank.e2e.steps.base;

import java.io.Serializable;

import az.kapitalbank.e2e.AppConfiguration;
import az.kapitalbank.e2e.stepDef.base.GenericGuiPage;
import org.springframework.test.context.ContextConfiguration;

import net.thucydides.core.steps.ScenarioSteps;

public class GenericGuiSteps extends ScenarioSteps implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private GenericGuiPage genericGuiPage;

	public void checkErrorMessage(String messageId){
		genericGuiPage.checkErrorMessage(messageId);
	}

	public void checkNotFoundPage() {
		genericGuiPage.checkNotFoundPage();
	}


}
