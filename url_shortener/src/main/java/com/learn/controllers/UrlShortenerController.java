package com.learn.controllers;

import com.learn.services.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shortener")
public class UrlShortenerController {

    @Autowired
    private UrlShortenerService urlShortenerService;

    @GetMapping("/shorten")
    String shorten(@RequestParam String url){
        return urlShortenerService.shortenUrl(url);
    }

    @GetMapping("/resolve")
    String resolveUrl(@RequestParam String shortenedUrl){
        return urlShortenerService.resolve(shortenedUrl);
    }

}
