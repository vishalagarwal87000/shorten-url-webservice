/**
 * 
 */
package com.example.urlshortener.controller;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.urlshortener.model.Shortening;
import com.example.urlshortener.service.ShorteningService;
import com.example.urlshortener.vo.ShorteningVO;

/**
 * @author Vishal
 *
 */
@RestController
public class ShorteningController {

	public static final Logger LOGGER = LoggerFactory.getLogger(ShorteningController.class);

	@Autowired
	public ShorteningService shorteningService;

	@PostMapping("/createShortenURL")
	public Shortening createShortenURL(@Valid @RequestBody ShorteningVO shorteningVO) {
		LOGGER.info("-------------inside createShortenURL controller----------- ");
		try {
			LOGGER.info("-------------exit createShortenURL controller----------- ");
			return shorteningService.createShortenURL(shorteningVO);
		} catch (Exception e) {
			LOGGER.error("Exception createShortenURL controller----------- " + e.getMessage(), e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Url not Found", e);
		}
	}

	@GetMapping("/getOriginalURL/{path}")
	public ShorteningVO getOriginalURL(@Valid @PathVariable String path, HttpServletResponse response) {
		LOGGER.info("-------------inside getOriginalURL controller----------- ");
		try {
			ShorteningVO shorteningVO = shorteningService.getOriginalURL(path);
			if (shorteningVO != null) {
				return shorteningVO;
			}
		} catch (NoSuchElementException e) {
			LOGGER.error("NoSuchElementException getOriginalURL controller----------- " + e.getMessage(), e);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Url not Found", e);
		} catch (Exception e) {
			LOGGER.error("Exception getOriginalURL controller----------- " + e.getMessage(), e);
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Could not redirect to original URL",
					e);
		}
		LOGGER.info("-------------exit getOriginalURL controller----------- ");
		return null;
	}

}
