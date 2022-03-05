package az.kapitalbank.e2e.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class FormBasePage extends PageObject {
	private final int TIMEOUT = 10;
	

	public void enterField(String elementId, Object input) {
		WebElement newUserNameInput = getDriver().findElement(By.id(elementId));
		newUserNameInput.clear();
		newUserNameInput.sendKeys("3");
		newUserNameInput.sendKeys(Keys.BACK_SPACE);
		if (input != null) {
			newUserNameInput.sendKeys(input.toString());
		}
	}
	
	public void enterFieldWithName(String elementName, Object input) {
		WebElement newUserNameInput = getDriver().findElement(By.name(elementName));
		newUserNameInput.clear();
		newUserNameInput.sendKeys("3");
		newUserNameInput.sendKeys(Keys.BACK_SPACE);
		if (input != null) {
			newUserNameInput.sendKeys(input.toString());
		}
	}
	
	public void waitForSeconds(long seconds){
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			//ignore
		}
	}
	
	public void waitForAjaxEnd(){
		waitForSeconds(1l);
		
		WebDriverWait ajaxIndicatorWait = new WebDriverWait(getDriver(), TIMEOUT);
		ajaxIndicatorWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("app-loading-indicator")));
	}
	
	public void waitForProgressEnd(){
		waitForSeconds(1l);
		WebDriverWait ajaxIndicatorWait = new WebDriverWait(getDriver(), 60);
		ajaxIndicatorWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("progress")));
	}
	
	public boolean waitForVisibility(String id) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(),TIMEOUT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public void clickConfirmButton(){
		WebDriverWait wait = new WebDriverWait(getDriver(),TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm_dialog_confirm")));
		
		getDriver().findElement(By.id("confirm_dialog_confirm")).click();
	}
	
	public void applyInputFilter(String tableName, int columnNumber,String data) {
		WebElement filter = getDriver().findElement(By.xpath("id('"+tableName+"')//table/thead/tr/th["+columnNumber+"]/input"));
		filter.clear();
		filter.sendKeys(data);
		waitForSeconds(1);
	}
	
	public void clickButton(String id) {
		WebDriverWait wait = new WebDriverWait(getDriver(),TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		getDriver().findElement(By.id(id)).click();
	}
	
	public void scrollToElement(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		waitForSeconds(1);
	}
}
