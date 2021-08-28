package com.gokhand.explorecali.explorecali.service;

import com.gokhand.explorecali.explorecali.models.Tour;
import com.gokhand.explorecali.explorecali.models.TourPackage;
import com.gokhand.explorecali.explorecali.repositories.TourPackageRepository;
import com.gokhand.explorecali.explorecali.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TourService {


    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository,
                       TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String tourPackageName,
                           Map<String, String> details){
        TourPackage tourPackage =
                tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour package does not exist"));
       return tourRepository.save(new Tour(title,tourPackage,details));

    }
    public long total() {
        return tourRepository.count();
    }


}
