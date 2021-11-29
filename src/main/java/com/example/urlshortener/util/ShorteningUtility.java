package com.example.urlshortener.util;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Vishal
 *
 */
@Component
public class ShorteningUtility {

	public static final Logger LOGGER = LoggerFactory.getLogger(ShorteningUtility.class);

	public static String isValid(String url) {
		/* Try creating a valid URL */
		LOGGER.info("-------------inside isValid----------- ");
		try {
			if (url.contains("http") || url.contains("https")) {
				new URL(url).toURI();
				LOGGER.info("-------------exit isValid----------- ");
				return url;
			} else if (url.contains(".") || url.contains("localhost")) {
				url = "http://" + url;
				new URL(url).toURI();
				LOGGER.info("-------------exit isValid----------- ");
				return url;
			} else {
				LOGGER.info("-------------exit isValid----------- ");
				return null;
			}
		}
		// If there was an Exception
		// while creating URL object
		catch (Exception e) {
			LOGGER.info("-------------exit isValid----------- ");
			return null;
		}
	}
}
