/**
 * 
 */
package com.example.urlshortener.service;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.urlshortener.model.Shortening;
import com.example.urlshortener.repository.ShorteningRepository;
import com.example.urlshortener.util.ShorteningUtility;
import com.example.urlshortener.vo.ShorteningVO;
import com.google.common.hash.Hashing;

/**
 * @author Vishal
 *
 */
@Service
public class ShorteningService {

	public static final Logger LOGGER = LoggerFactory.getLogger(ShorteningService.class);

	@Autowired
	public ShorteningRepository shorteningRepo;

	public Shortening createShortenURL(ShorteningVO shorteningVO) throws Exception {
		LOGGER.info("-------------inside createShortenURL controller----------- ");
		Shortening shortening = null;
		String url = ShorteningUtility.isValid(shorteningVO.getLongUrl());
		if (url != null) {
			String shortUrl = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();
			shortening = shorteningRepo.findByShortURL(shortUrl);
			if (shortening != null) {
				return shortening;
			} else {
				shortening = new Shortening();
				shortening.setShortUrl(shortUrl);
				shortening.setLongUrl(url);
				shorteningRepo.save(shortening);
			}
		} else {
			throw new Exception("Url not Found");
		}
		LOGGER.info("-------------exit createShortenURL controller----------- ");
		return shortening;
	}

	public ShorteningVO getOriginalURL(String path) {
		LOGGER.info("-------------inside getOriginalURL controller----------- ");
		Shortening shortening = null;
		ShorteningVO shorteningVO = new ShorteningVO();
		try {
			shortening = shorteningRepo.findByShortURL(path);
			if (shortening != null)
				shorteningVO.setLongUrl(shortening.getLongUrl());
		} catch (Exception e) {
			LOGGER.error("Exception getOriginalURL controller----------- " + e.getMessage(), e);
		}
		LOGGER.info("-------------exit getOriginalURL controller----------- ");
		return shorteningVO;
	}

}
