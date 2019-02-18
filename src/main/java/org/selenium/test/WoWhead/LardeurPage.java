package org.selenium.test.WoWhead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LardeurPage extends WowheadPage{

	public LardeurPage(WebDriver driver) {
		super(driver);
	}

	WebElement objectOne = driver.findElement(By.xpath("(//*[@id=\"tab-drops\"]//a[@class='q3 listview-cleartext'])[1]"));
	WebElement objectTwo = driver.findElement(By.xpath("(//*[@id=\"tab-drops\"]//a[@class='q3 listview-cleartext'])[2]"));
	WebElement objectThree = driver.findElement(By.xpath("(//*[@id=\"tab-drops\"]//a[@class='q3 listview-cleartext'])[3]"));
	WebElement objectFour = driver.findElement(By.xpath("(//*[@id=\"tab-drops\"]//a[@class='q3 listview-cleartext'])[4]"));
	WebElement objectFive = driver.findElement(By.xpath("(//*[@id=\"tab-drops\"]//a[@class='q3 listview-cleartext'])[5]"));
	
	public ObjectOnePage cliquerPremierObjet() {
		objectOne.click();
		
		return PageFactory.initElements(driver, ObjectOnePage.class);
		
	}
	
	public ObjectDeuxPage cliquerDeuxiemerObjet() {
		objectTwo.click();
		
		return PageFactory.initElements(driver, ObjectDeuxPage.class);
		
	}
	
}
