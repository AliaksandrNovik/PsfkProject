package by.minsk.psfk.com.test;
import org.testng.annotations.Test;

import by.minsk.psfk.com.driver.DriverManager;
import by.minsk.psfk.com.page.FutureMobilePage;
import by.minsk.psfk.com.page.FutureTravelPage;
import by.minsk.psfk.com.page.PowerChatPage;
import by.minsk.psfk.com.utils.ImageUtil;
import by.minsk.psfk.com.utils.ImageUtil.TypeOfWebSite;

public class TestFirst {

	private final String URL_FUTURE_MOBILE = "http://www.psfk.com/report/future-of-mobile-tagging";
	
	private final String URL_FUTURE_TRAVEL = "http://www.psfk.com/report/future-of-travel-trends-in-transportation-booking-industry-research";

	private final String URL_POWER_CHAT = "http://www.psfk.com/report/power-of-chat-debrief";
	
	private FutureMobilePage mobilePage;
	private FutureTravelPage travelPage;
	private PowerChatPage powerPage;
	
	@Test(priority = 2)
	public void testMobile() {
		mobilePage = new FutureMobilePage(DriverManager.getInstance().getWebDriver());
		mobilePage.openPage(URL_FUTURE_MOBILE);
		mobilePage.navigateToSlideShare();
		for(int i = 1; i <= mobilePage.getListSlides().size()+1; i++){
			mobilePage.clickOnButtonNextSlide();
			ImageUtil.saveListOfImages(mobilePage.getImageUrlFromCurrentSlide(i), i, TypeOfWebSite.MOBILE);
		}
	}
	
	@Test(priority = 1)
	public void testTravel() {
		travelPage = new FutureTravelPage(DriverManager.getInstance().getWebDriver());
		travelPage.openPage(URL_FUTURE_TRAVEL);
		travelPage.navigateToSlideShare();
		for(int i = 1; i <= travelPage.getListSlides().size()+1; i++){
			travelPage.clickOnButtonNextSlide();
			ImageUtil.saveListOfImages(travelPage.getImageUrlFromCurrentSlide(i), i, TypeOfWebSite.TRAVEL);
		}
	}
		
	@Test(priority = 3)
	public void testPowerChat() {
		powerPage = new PowerChatPage(DriverManager.getInstance().getWebDriver());
		powerPage.openPage(URL_POWER_CHAT);
		powerPage.navigateToSlideShare();
		for(int i = 1; i <= powerPage.getListSlides().size()+1; i++){
			powerPage.clickOnButtonNextSlide();
			ImageUtil.saveListOfImages(powerPage.getImageUrlFromCurrentSlide(i), i, TypeOfWebSite.POWER);
		}
	}
}


