package az.kapitalbank.e2e.pages.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class GUIDialogPage extends PageObject  {
	
	@FindBy(id = "confirm_dialog_confirm")
	private WebElementFacade confirmButtun;
	
	@FindBy(id = "confirm_dialog_reject")
	private WebElementFacade rejectButton;
	
	public void confirm() {
		confirmButtun.click();		
	}

	public void reject() {
		rejectButton.click();		
	}

	

}
