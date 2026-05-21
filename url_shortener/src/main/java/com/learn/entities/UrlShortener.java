package com.learn.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.annotation.processing.Generated;
import java.util.Date;

@Table(name = "shortener")
@Data
@Entity
@Builder
public class UrlShortener {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "ORIGINAL_URL")
    private String originalUrl;

    @CreationTimestamp
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

}
