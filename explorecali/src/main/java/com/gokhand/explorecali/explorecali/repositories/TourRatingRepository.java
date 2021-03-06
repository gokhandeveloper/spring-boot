package com.gokhand.explorecali.explorecali.repositories;

import com.gokhand.explorecali.explorecali.models.TourRating;
import com.gokhand.explorecali.explorecali.models.TourRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository  extends CrudRepository<TourRating, TourRatingPk> {

    List<TourRating> findByPkTourId(Integer tourId);
    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customer);

}
