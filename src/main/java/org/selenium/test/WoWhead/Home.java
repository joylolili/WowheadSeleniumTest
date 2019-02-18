package org.selenium.test.WoWhead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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

		WebElement btnCoockies = driver.findElement(By.xpath("//button[contains(text(), 'Continue Using Site')]"));
		
		if (btnCoockies.isDisplayed()) {
			btnCoockies.click();
		}
		
	}
	
	
	
}
