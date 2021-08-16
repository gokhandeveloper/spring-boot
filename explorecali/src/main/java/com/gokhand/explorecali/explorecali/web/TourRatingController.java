package com.gokhand.explorecali.explorecali.web;

import com.gokhand.explorecali.explorecali.models.Tour;
import com.gokhand.explorecali.explorecali.models.TourRating;
import com.gokhand.explorecali.explorecali.models.TourRatingPk;
import com.gokhand.explorecali.explorecali.repositories.TourRatingRepository;
import com.gokhand.explorecali.explorecali.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path="/tours/{tourId}/ratings")
public class TourRatingController {

    TourRatingRepository tourRatingRepository;
    TourRepository tourRepository;

    @Autowired
    public TourRatingController(TourRatingRepository tourRatingRepository, TourRepository tourRepository) {
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }
    protected TourRatingController() {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(
            @PathVariable(value="tourId") int tourId,
            @RequestBody @Validated RatingDto ratingDto) {
        Tour tour = verifyTour(tourId);
        tourRatingRepository
                .save(new TourRating
                        (new TourRatingPk(tour, ratingDto.getCustomerId()),
                        ratingDto.getScore(),ratingDto.getComment()));
    }
    private Tour verifyTour(int tourId) throws NoSuchElementException {
        return tourRepository.findById(tourId).orElseThrow(() ->
                new NoSuchElementException("tour does not exists"));
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();
    }



}
