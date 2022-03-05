package az.kapitalbank.e2e.stepDef.base;


import az.kapitalbank.e2e.steps.base.GUIDialogSteps;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Eğerki;
import net.thucydides.core.annotations.Steps;

public class GUIDialogStepDef {

	@Steps
	private GUIDialogSteps userDialogSteps;

	@Eğerki("^açılan onay diyaloğunu onaylamazsa$")
	public void açılan_onay_diyaloğunu_onaylamazsa() throws Throwable {
		userDialogSteps.reject();
	}
	
	@Eğerki("^açılan onay diyaloğunu onaylarsa$")
	public void açılan_onay_diyaloğunu_onaylarsa() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		userDialogSteps.confirm();
	}


}
