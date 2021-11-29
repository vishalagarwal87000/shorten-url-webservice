package com.example.urlshortener.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.urlshortener.model.Shortening;

/**
 * @author Vishal
 *
 */
@Repository
public interface ShorteningRepository extends CrudRepository<Shortening, Long> {

	@Query(value = "select * from shortening s where s.SHORTURL = (?1)", nativeQuery = true)
	Shortening findByShortURL(String shortURL);
}
