package az.kapitalbank.e2e.stepDef.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class GenericGuiPage extends PageObject  {

	
	public void checkErrorMessage(String messageId) {
		WebElement messages = getDriver().findElement(By.id(messageId));
		
		WebDriverWait successMessage = new WebDriverWait(getDriver(), 10);
		successMessage.until(ExpectedConditions.visibilityOf(messages.findElement(By.xpath("//div[contains(@class, 'ui-messages-error')]"))));		
	}

	public void checkNotFoundPage() {
		WebDriverWait notFoundPageWait = new WebDriverWait(getDriver(), 10);
		notFoundPageWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("page_not_found")));
	}
	

}
