package com.arkademy.travel.service;

import com.arkademy.travel.dto.TravelDto;
import com.arkademy.travel.entity.Travel;
import com.arkademy.travel.travelrepo.TravelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface TravelService {


    List<TravelDto> findAllTravel();

    Travel saveTravel(TravelDto travelDto);

    TravelDto findTravelById(Long travel);

    void updateTravel(TravelDto travelDto);

    void deleteTravel(Long travelId);
}