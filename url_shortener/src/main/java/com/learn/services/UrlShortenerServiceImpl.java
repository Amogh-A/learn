package com.learn.services;

import com.learn.entities.UrlShortener;
import com.learn.repository.UrlShortenerRepository;
import com.learn.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Autowired
    private UrlShortenerRepository urlShortenerRepository;

    @Override
    public String shortenUrl(String url) {
        UrlShortener urlShortener = UrlShortener.builder()
                .originalUrl(url)
                .build();
        urlShortener = urlShortenerRepository.save(urlShortener);
        return "";
    }

    @Override
    public String resolve(String shortenedUrl) {
        return "";
    }
}
