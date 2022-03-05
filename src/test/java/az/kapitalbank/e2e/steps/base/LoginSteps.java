package az.kapitalbank.e2e.steps.base;

import java.io.Serializable;

import az.kapitalbank.e2e.pages.KimlikVeGuvenlikAltyapisi.LoginPage;
import az.kapitalbank.e2e.stepDef.dependency.ResultStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.thucydides.core.steps.ScenarioSteps;

@Component
public class LoginSteps extends ScenarioSteps implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private ResultStoreService resultStoreService;

	public void login(String auth) {
		String token = loginPage.login(auth);
		resultStoreService.addResult("token", token);
	}

}
