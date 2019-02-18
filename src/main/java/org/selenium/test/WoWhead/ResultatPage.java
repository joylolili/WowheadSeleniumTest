package org.selenium.test.WoWhead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultatPage extends WowheadPage{

	public ResultatPage(WebDriver driver) {
		super(driver);
	}

	public LardeurPage cliquerSurPNJ() {
		
		WebElement ongletPnj = driver.findElement(By.xpath("//*[@id=\"search-tabs\"]//a/div[contains(.,'PNJ')]"));
		ongletPnj.click();
		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    WebElement lardeur = driver.findElement(By.xpath("//td[@class='icon-boss-padded']/a"));
	    lardeur.click();
	    
	    return PageFactory.initElements(driver, LardeurPage.class);

		
	}
	
	public void cliqueCookiesDeux() {

		WebElement btnCoockies = driver.findElement(By.xpath("//*[@id=\"cookie-settings\"]/div/button[2]"));
		
		if (btnCoockies.isDisplayed()) {
			btnCoockies.click();
		}
		
	}
	
}
