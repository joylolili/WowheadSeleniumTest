package org.selenium.test.WoWhead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectDeuxPage extends WowheadPage{

	public ObjectDeuxPage(WebDriver driver) {
		super(driver);
	}

	WebElement objet = driver.findElement(By.xpath("//*[@id=\"main-contents\"]/div[2]/h1"));
	WebElement endurance = driver.findElement(By.xpath("//span[contains(text(),'Endurance')]"));
	WebElement intelligence = driver.findElement(By.xpath("//span[contains(text(),'Intelligence')]"));
}
