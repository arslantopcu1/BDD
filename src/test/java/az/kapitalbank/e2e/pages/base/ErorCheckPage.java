package az.kapitalbank.e2e.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class ErorCheckPage extends PageObject {

	public void checkEror(String erorMessage) {
		WebDriverWait erorMessageElement = new WebDriverWait(getDriver(), 10);
		erorMessageElement.until(ExpectedConditions.visibilityOf(getDriver().findElement(By
				.xpath("//div[contains(@class, 'ui-growl-message-error') or contains(@class, 'ui-messages-error')]"))));
	}

}
