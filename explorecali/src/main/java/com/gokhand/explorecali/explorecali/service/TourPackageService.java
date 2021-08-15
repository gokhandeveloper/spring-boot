package com.gokhand.explorecali.explorecali.service;

import com.gokhand.explorecali.explorecali.models.TourPackage;
import com.gokhand.explorecali.explorecali.repositories.TourPackageRepository;
import com.gokhand.explorecali.explorecali.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }


    public TourPackage createTourPackage(String code, String name) {
        return tourPackageRepository.findById(code)
                .orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }
    public Iterable<TourPackage> lookUp(){
        return tourPackageRepository.findAll();
    }
    public long total(){
        return tourPackageRepository.count();
    }
}
