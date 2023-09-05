package com.arkademy.travel.service.implement;

import com.arkademy.travel.dto.TravelDto;
import com.arkademy.travel.entity.Travel;
import com.arkademy.travel.service.TravelService;
import com.arkademy.travel.travelrepo.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelServiceImpl implements TravelService {
    private TravelRepository travelRepository;
    @Autowired
    public TravelServiceImpl(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }


    @Override
    public List<TravelDto> findAllTravel() {
        List<Travel> travels = travelRepository.findAll();
        return travels.stream().map(travel -> mapToTravelDto(travel)).collect(Collectors.toList());
    }

    @Override
    public Travel saveTravel(TravelDto travelDto) {
        Travel travel = mapToTravel(travelDto);
        return travelRepository.save(travel);
    }

    @Override
    public TravelDto findTravelById(Long travel) {
        Travel travels = travelRepository.findById(travel).get();
        return mapToTravelDto(travels);
    }

    @Override
    public void updateTravel(TravelDto travelDto) {
        Travel travel = mapToTravel(travelDto);
        travelRepository.save(travel);
    }

    @Override
    public void deleteTravel(Long travelId) {
        travelRepository.deleteById(travelId);
    }

    private Travel mapToTravel(TravelDto travel) {
        Travel travels = Travel.builder()
                .id(travel.getId())
                .name(travel.getName())
                .phoneNum(travel.getPhoneNum())
                .email(travel.getEmail())
                .country(travel.getCountry())
                .content(travel.getContent())
                .createdOn(travel.getCreatedOn())
                .build();
        return travels;

    }
    private TravelDto mapToTravelDto(Travel travel){
        TravelDto travelDto = TravelDto.builder()
                .id(travel.getId())
                .name(travel.getName())
                .phoneNum(travel.getPhoneNum())
                .content(travel.getContent())
                .country(travel.getCountry())
                .email(travel.getEmail())
                .createdOn(travel.getCreatedOn())
                .build();
        return travelDto;
    }
}

