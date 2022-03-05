package az.kapitalbank.e2e.steps.base;

import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import az.kapitalbank.e2e.AppConfiguration;
import az.kapitalbank.e2e.pages.base.GUIDialogPage;
import az.kapitalbank.e2e.stepDef.dependency.ResultStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import net.thucydides.core.steps.ScenarioSteps;

public class GUIDialogSteps extends ScenarioSteps implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private GUIDialogPage dialogPage;
	
	@Autowired
	private ResultStoreService resultStoreService;
	
	public void confirm() {
		dialogPage.confirm();
	}

	public void reject() {
		dialogPage.reject();
	}

}
