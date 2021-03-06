package org.selenium.test.WoWhead;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WowheadTest {
	
	private WebDriver driver;
	private String browser = System.getProperty("browser");
	private String chrome = "chrome";
	private String opera = "opera";
	private String firefox = "firefox";
	
	
	@Before
	public void init() {
		
		if (browser.equals(chrome)) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\formation\\Desktop\\SUT\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (browser.equals(opera)){
			System.setProperty("webdriver.opera.driver", "C:\\Users\\formation\\Desktop\\SUT\\operadriver_win64\\operadriver.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			OperaOptions operaOptions = new OperaOptions();
			operaOptions.setBinary("C:\\Users\\formation\\AppData\\Local\\Programs\\Opera\\launcher.exe");
			cap.setCapability(OperaOptions.CAPABILITY, operaOptions);
			driver = new OperaDriver();	
		}else if (browser.equals(firefox)) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\Desktop\\SUT\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		driver.get("https://fr.wowhead.com/");
	}
	
	@After
	public void fin() {
		driver.close();	
		try {
			driver.quit();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void wowheadRechercheTest() throws InterruptedException {
		
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
		Thread.sleep(5000);
		resultatPage.cliqueCookiesDeux();
		
		// cliquer sur PNJ
		resultatPage.cliquerSurPNJ();
		
		waiting(driver);
		
		// se rendre page (icon crane)lardeur
		LardeurPage lardeurPage = new LardeurPage(driver);
		
		// vérifier les 5 objets rares
		if (browser.equals(chrome)) {
			assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectOne.getCssValue("color"));
			assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectTwo.getCssValue("color"));
			assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectThree.getCssValue("color"));
			assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectFour.getCssValue("color"));
			assertEquals("rgba(0, 112, 221, 1)", lardeurPage.objectFive.getCssValue("color"));
		} else {
			assertEquals("rgb(0, 112, 221)", lardeurPage.objectOne.getCssValue("color"));
			assertEquals("rgb(0, 112, 221)", lardeurPage.objectTwo.getCssValue("color"));
			assertEquals("rgb(0, 112, 221)", lardeurPage.objectThree.getCssValue("color"));
			assertEquals("rgb(0, 112, 221)", lardeurPage.objectFour.getCssValue("color"));
			assertEquals("rgb(0, 112, 221)", lardeurPage.objectFive.getCssValue("color"));
		}
		

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
