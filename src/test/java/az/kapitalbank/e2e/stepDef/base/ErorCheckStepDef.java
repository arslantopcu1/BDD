package az.kapitalbank.e2e.stepDef.base;

import az.kapitalbank.e2e.steps.base.ErorCheckSteps;

import io.cucumber.java.tr.Ozaman;
import net.thucydides.core.annotations.Steps;

public class ErorCheckStepDef {

	@Steps
	private ErorCheckSteps erorCheckSteps;

	@Ozaman("^sistem \"([^\"]*)\" hatası verir$")
	public void sistem_hatası_verir(String arg1) throws Throwable {
		erorCheckSteps.checkEror(arg1);
		
	}
	
}
