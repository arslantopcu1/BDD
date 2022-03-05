package az.kapitalbank.e2e.steps.base;

import static org.junit.Assert.assertTrue;

import java.io.Serializable;

import az.kapitalbank.e2e.AppConfiguration;
import az.kapitalbank.e2e.model.UserActor;
import az.kapitalbank.e2e.pages.KimlikVeGuvenlikAltyapisi.GuiLoginPage;
import az.kapitalbank.e2e.stepDef.dependency.ResultStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import net.thucydides.core.steps.ScenarioSteps;

public class GuiLoginSteps extends ScenarioSteps implements Serializable {

	private static final long serialVersionUID = 1L;

	private GuiLoginPage guiLoginPage;

	@Autowired
	private ResultStoreService resultStoreService;

	public void login(UserActor svuser) {

		guiLoginPage.open();
		guiLoginPage.login(svuser.getUsername(), svuser.getPassword());
		guiLoginPage.checkIsUserIn();
		resultStoreService.addResult("userActor", svuser);
	}

}
