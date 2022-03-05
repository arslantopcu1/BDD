package az.kapitalbank.e2e.steps.base;

import java.io.Serializable;

import az.kapitalbank.e2e.AppConfiguration;
import az.kapitalbank.e2e.pages.base.ErorCheckPage;
import az.kapitalbank.e2e.stepDef.dependency.ResultStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import net.thucydides.core.steps.ScenarioSteps;

public class ErorCheckSteps extends ScenarioSteps implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ErorCheckPage erorCheckPage;
	
	@Autowired
	private ResultStoreService resultStoreService;

	public void checkEror(String erorMessage) {
		erorCheckPage.checkEror(erorMessage);
	}

}
