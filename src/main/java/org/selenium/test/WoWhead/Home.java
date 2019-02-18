package org.selenium.test.WoWhead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class Home extends WowheadPage {

	public Home(WebDriver driver) {
		super(driver);
	}

	private WebElement barRecherche = driver.findElement(By.xpath("//*[@id=\"layout\"]/div[1]/div[2]/div[1]/form/input"));
	private WebElement btnRecherche = driver.findElement(By.xpath("//*[@id=\"layout\"]/div[1]/div[2]/div[1]/a"));
	
	public ResultatPage recherche() {
		
		barRecherche.click();
		barRecherche.sendKeys("lardeur");
		btnRecherche.click();
		
		return PageFactory.initElements(driver, ResultatPage.class);
	}
	
	public void cliqueCookies() {

		
		Wait wait = new FluentWait(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		
		WebElement btnCoockies = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("//button[contains(text(), 'Continue Using Site')]"));
			}
		});
//				driver.findElement(By.xpath("//button[contains(text(), 'Continue Using Site')]"));

		if (btnCoockies.isDisplayed()) {
			btnCoockies.click();
		}
		
	}
	
	
	
}
