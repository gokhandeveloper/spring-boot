package com.gokhand.explorecali.explorecali.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Rating of a Tour by a Customer
 *
 * Created by Mary Ellen Bowman
 */
@Document
public class TourRating {

    @Id
    private String id;

    private String tourId;

    @NotNull
    private Integer customerId;

    @Min(0)
    @Min(5)
    private Integer score;

    @Size(max=255)
    private String comment;

    /**
     * Create a fully initialized TourRating.
     *
     * @param pk         primiary key of a tour and customer id.
     * @param score      Integer score (1-5)
     * @param comment    Optional comment from the customer
     */
    public TourRating(String id, Integer score, String comment) {
        this.id = id;
        this.score = score;
        this.comment = comment;
    }


    protected TourRating() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
