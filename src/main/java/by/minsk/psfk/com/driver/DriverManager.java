package by.minsk.psfk.com.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class DriverManager {
	
	private WebDriver driver;

	private static DriverManager instance;
	
	private static final Logger LOGGER = Logger.getLogger(DriverManager.class);
	
	private DriverManager()  {
		LOGGER.info("Starting Firefox Driver for " + System.getProperty("os.name") + "...");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en" ); 
		driver = new FirefoxDriver(profile);
	}

	public static DriverManager getInstance() {
		if (instance == null) {
			instance = new DriverManager();
		}
		return instance;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

}
