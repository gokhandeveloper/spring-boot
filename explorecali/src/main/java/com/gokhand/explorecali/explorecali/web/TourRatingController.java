package com.gokhand.explorecali.explorecali.web;

import com.gokhand.explorecali.explorecali.models.Tour;
import com.gokhand.explorecali.explorecali.models.TourRating;
import com.gokhand.explorecali.explorecali.models.TourRatingPk;
import com.gokhand.explorecali.explorecali.repositories.TourRatingRepository;
import com.gokhand.explorecali.explorecali.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<RatingDto> getAllRatingsFourTour(
            @PathVariable(value="tourId") int tourId){
        verifyTour(tourId);
        return tourRatingRepository.findByPkTourId(tourId).stream()
                .map(RatingDto::new).collect(Collectors.toList());
    }

    @GetMapping(path = "/average")
    public Map<String, Double> getAverage(
            @PathVariable(value = "tourId") int tourId) {
        verifyTour(tourId);
        return Map.of("average",tourRatingRepository.findByPkTourId(tourId).stream()
                .mapToInt(TourRating::getScore).average()
                .orElseThrow(() ->
                        new NoSuchElementException("Tour has no Ratings")));
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
