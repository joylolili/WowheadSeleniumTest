package org.selenium.test.WoWhead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WowheadPage {

	public WebDriver driver;

	public WowheadPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
}
