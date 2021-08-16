package com.gokhand.explorecali.explorecali.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;

import java.util.Map;
import java.util.Objects;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Tour {
    @Id
    private String id;

    @Indexed
    private String title;


    private String tourPackageCode;

    @Indexed
    private String tourPackageName;

    private Map<String, String> details;

    public Tour(String title, TourPackage tourPackage, Map<String, String> details) {
        this.title = title;
        this.tourPackageCode = tourPackage.getCode();
        this.tourPackageName = tourPackage.getName();
        this.details = details;
    }

    protected Tour() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTourPackageCode() {
        return tourPackageCode;
    }

    public void setTourPackageCode(String tourPackageCode) {
        this.tourPackageCode = tourPackageCode;
    }

    public String getTourPackageName() {
        return tourPackageName;
    }

    public void setTourPackageName(String tourPackageName) {
        this.tourPackageName = tourPackageName;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", tourPackageCode='" + tourPackageCode + '\'' +
                ", tourPackageName='" + tourPackageName + '\'' +
                ", details=" + details +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        return new EqualsBuilder().append(id, tour.id).append(title, tour.title).append(tourPackageCode, tour.tourPackageCode).append(tourPackageName, tour.tourPackageName).append(details, tour.details).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(title).append(tourPackageCode).append(tourPackageName).append(details).toHashCode();
    }
}
