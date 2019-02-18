package org.selenium.test.WoWhead;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WowheadTest {
	
	private WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://fr.wowhead.com/");
	}
	
	@After
	public void fin() {
		driver.close();	
		driver.quit();
	}
	
	@Test
	public void wowheadRechercheTest() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://fr.wowhead.com/");
		
		waiting(driver);
		
		// se rendre sur fr.wowhead.com
		Home homePage = new Home(driver);
		
		homePage.cliqueCookies();
		
		// faire une recherche "lardeur"
		homePage.recherche();
		
		// Page resultat de recherche
		ResultatPage resultatPage = new ResultatPage(driver);
		
		waiting(driver);
		
		// fermer cookies "J'ai pigé"
		resultatPage.cliqueCookiesDeux();
		
		// cliquer sur PNJ
		resultatPage.cliquerSurPNJ();
		
		waiting(driver);
		
		// se rendre page (icon crane)lardeur
		LardeurPage lardeurPage = new LardeurPage(driver);
		
		// vérifier les 5 objets rares
		assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectOne.getCssValue("color"));
		assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectTwo.getCssValue("color"));
		assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectThree.getCssValue("color"));
		assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectFour.getCssValue("color"));
		assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectFive.getCssValue("color"));

		/////////////////////////////////////////////
		
		// cliquer sur 1er object
		lardeurPage.cliquerPremierObjet();
		
		waiting(driver);
		
		ObjectOnePage objectOnePage = new ObjectOnePage(driver);
		
		// verifier ses statistiques
		assertEquals("Chahuteurs de cadavre", objectOnePage.objet.getText());
		assertEquals("+5 Intelligence", objectOnePage.intelligence.getText());
		assertEquals("+8 Endurance", objectOnePage.endurance.getText());
		
		////////////////////////////////////////////
		
		// Retourner sur la page precedant
		driver.navigate().back();
		
		waiting(driver);
		
		LardeurPage lardeurPageB = new LardeurPage(driver);
		
		// cliquer sur 2eme object
		lardeurPageB.cliquerDeuxiemerObjet();
		
		waiting(driver);
		
		ObjectDeuxPage objectDeuxPage = new ObjectDeuxPage(driver);
		
		// verifier 2eme object statistiques
		assertEquals("Chausses de Lardeur", objectDeuxPage.objet.getText());
		assertEquals("+7 [Agilité or Intelligence]", objectDeuxPage.intelligence.getText());
		assertEquals("+10 Endurance", objectDeuxPage.endurance.getText());
		
				
	}

	public void waiting(WebDriver driver) {		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
}
