package by.minsk.psfk.com.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.minsk.psfk.com.driver.DriverManager;



public class Page {
	
	private static final Logger LOGGER = Logger.getLogger(Page.class);
	
    protected WebDriver driver;

	@FindBy(xpath = "//button[@id = 'btnLeaveFullScreen']")
	private WebElement buttonLeaveFullScreen;
	@FindBy(xpath = "//button[@id = 'btnNext']")
	private WebElement buttonNext;
	
	private By xpathForListSlides = By.xpath("//div[@class = 'slide']");

    
    public Page(WebDriver driver ) {
    	LOGGER.info("Page Factory has been initialised" );
        DriverManager.getInstance().getWebDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        DriverManager.getInstance().getWebDriver().manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        DriverManager.getInstance().getWebDriver().manage().window().maximize();
	    this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }

    public WebElement waitForElement(By locator, long timeOutInSeconds, long sleepInMillis) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElement(WebElement waitButton){
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(waitButton));
    }
    
    public void openPage(String url){
    	LOGGER.info("Open page with url: " + url);
    	driver.get(url);
    }
    
	public void clickOnButtonNextSlide(){
		LOGGER.info("Click on button next slide");
		buttonNext.click();
	}

	public String getImageUrlFromCurrentSlide(int currentIndex){
		return driver.findElement(
				By.cssSelector(String.format("div[data-index = '%s'] img",Integer.toString(currentIndex)))).getAttribute("data-full");
	}
	
	public List<WebElement> getListSlides(){
		return driver.findElements(xpathForListSlides);
	}

}
