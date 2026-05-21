package com.learn.repository;

import com.learn.entities.UrlShortener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlShortenerRepository extends JpaRepository<UrlShortener, Long> {
}
