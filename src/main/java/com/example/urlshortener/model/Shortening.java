package com.example.urlshortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Vishal
 *
 */
@Entity
@Table(name = "shortening")
public class Shortening {

	@Id
	@SequenceGenerator(name = "id_seq", sequenceName = "id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
	@Column(name = "ID", updatable = false)
	private Long id;

	@Column(name = "SHORTURL")
	private String shortUrl;

	@Column(name = "LONGURL")
	private String longUrl;

	public Shortening() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shortening(Long id, String shortUrl, String longUrl) {
		super();
		this.id = id;
		this.shortUrl = shortUrl;
		this.longUrl = longUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

}
