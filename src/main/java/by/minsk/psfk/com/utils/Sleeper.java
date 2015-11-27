package by.minsk.psfk.com.utils;

import org.apache.log4j.Logger;


public class Sleeper {
	
	private static final Logger LOGGER = Logger.getLogger(Sleeper.class);
	
	public static void sleep(long seconds){
		try {
			LOGGER.info("Stopped thread at " + seconds + " seconds");
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}

}
