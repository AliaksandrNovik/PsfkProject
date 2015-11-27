package by.minsk.psfk.com.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ImageUtil {

	public enum TypeOfWebSite{
		MOBILE, TRAVEL, POWER;
	}

	private static final Logger LOGGER = Logger.getLogger(ImageUtil.class);

	private static final String PATH_TO_MOBILE_FOLDER = "resources\\mobile\\file%s.png";

	private static final String PATH_TO_TRAVEL_FOLDER = "resources\\travel\\file%s.png";
	
	private static final String PATH_TO_POWER_CHAT_FOLDER = "resources\\power\\file%s.png";

	private static final String PATH_TO_APP_FOLDER = "D:\\workspace_for_LUNA\\psfk.com\\";

	public static void saveListOfImages( String urlImage , int currentSlide, TypeOfWebSite type)
	{
		BufferedImage image = null;
		try {

			URL url = new URL(urlImage);
			image = ImageIO.read(url);
			switch(type){
			case MOBILE:
				ImageIO.write(image, "png", new File(PATH_TO_APP_FOLDER + String.format(PATH_TO_MOBILE_FOLDER, currentSlide)));
				break;
			case TRAVEL:
				ImageIO.write(image, "png", new File(PATH_TO_APP_FOLDER + String.format(PATH_TO_TRAVEL_FOLDER, currentSlide)));
				break;
			case POWER:
				ImageIO.write(image, "png", new File(PATH_TO_APP_FOLDER + String.format(PATH_TO_POWER_CHAT_FOLDER, currentSlide)));
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("SAVE image with index:  " + currentSlide);
	}

}
