package com.example.urlshortener.vo;

public class ShorteningVO {

	private String shortUrl;
	private String longUrl;

	public ShorteningVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShorteningVO(String shortUrl, String longUrl) {
		super();
		this.shortUrl = shortUrl;
		this.longUrl = longUrl;
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
