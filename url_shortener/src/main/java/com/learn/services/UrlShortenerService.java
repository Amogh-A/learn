package com.learn.services;

public interface UrlShortenerService {

    String shortenUrl(String url);

    String resolve(String shortenedUrl);

}
