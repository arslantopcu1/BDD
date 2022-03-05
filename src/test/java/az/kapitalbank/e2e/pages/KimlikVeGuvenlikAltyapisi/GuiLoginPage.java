package az.kapitalbank.e2e.pages.KimlikVeGuvenlikAltyapisi;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://cb.kapitalbank.az/login")
public class GuiLoginPage extends PageObject {

	@FindBy(id = "login")
	private WebElementFacade loginUserField;

	@FindBy(id = "password")
	private WebElementFacade loginPasswordField;

	@FindBy(id = "loginWithGoogleForm")
	private WebElementFacade loginSubmitButton;

	public void login(String email, String password) {
		loginUserField.clear();
		loginPasswordField.clear();
		loginUserField.sendKeys(email);
		loginPasswordField.sendKeys(password);
		loginSubmitButton.submit();
	}

	public void checkIsUserIn() {
		WebDriverWait roleAddSubMenuWait = new WebDriverWait(getDriver(), 10);
		roleAddSubMenuWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_profile_div")));
	}

	public void checkIsUserOut() {
		WebDriverWait roleAddSubMenuWait = new WebDriverWait(getDriver(), 10);
		roleAddSubMenuWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("user_profile_div")));
	}

}
