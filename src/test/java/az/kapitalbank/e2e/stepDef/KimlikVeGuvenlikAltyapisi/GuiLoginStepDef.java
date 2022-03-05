package az.kapitalbank.e2e.stepDef.KimlikVeGuvenlikAltyapisi;

import az.kapitalbank.e2e.model.UserActor;
import az.kapitalbank.e2e.steps.base.GuiLoginSteps;


import az.kapitalbank.e2e.steps.base.LoginSteps;
import az.kapitalbank.e2e.utils.JsonToEntityUtils;
import io.cucumber.java.tr.*;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuiLoginStepDef {

	private final Logger logger = LoggerFactory.getLogger(GuiLoginStepDef.class);

	@Steps
	private GuiLoginSteps guiLoginSteps;

	@Diyelimki("{string} GUI üzerinden sisteme giriş yaptı")
	public void guiÜzerindenSistemeGirişYaptı(String user) {
		UserActor svuser = JsonToEntityUtils.getEntityFromJsonFile(user, UserActor.class);
		guiLoginSteps.login(svuser);
	}

	@Ve("{string} kullanıcısının düzenleme sayfasına girdi")
	public void kullanıcısınınDüzenlemeSayfasınaGirdi(String arg0) {
	}


	@Eğerki("{string} kullanıcı bilgilerini güncellerse")
	public void kullanıcıBilgileriniGüncellerse(String arg0) {
		
	}

	@Ama("kullanıcı bilgilerinin bir ksımı eksikse")
	public void kullanıcıBilgilerininBirKsımıEksikse() {
		
	}

	@Ozaman("sistem ekle tuşunu kapatır")
	public void sistemEkleTuşunuKapatır() {
	}
}
