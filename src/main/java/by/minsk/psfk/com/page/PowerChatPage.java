package by.minsk.psfk.com.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import by.minsk.psfk.com.utils.Sleeper;

public class PowerChatPage extends Page{

	private static final Logger LOGGER = Logger.getLogger(FutureMobilePage.class);

	@FindBy(xpath = "//button[@id = 'btnFullScreen']")
	private WebElement buttonFullSize;

	private final By xpathLocatorToPlayer = 
			By.xpath("//iframe[@src = 'https://www.slideshare.net/slideshow/embed_code/51147509']");

	public PowerChatPage(WebDriver driver) {
		super(driver);
	}
	
	public void navigateToSlideShare(){
		LOGGER.info("Open player in full size " );
		driver.switchTo().frame(driver.findElement(xpathLocatorToPlayer));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonFullSize);
		Sleeper.sleep(1);

	}

}
