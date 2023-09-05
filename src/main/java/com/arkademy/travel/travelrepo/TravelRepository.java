package com.arkademy.travel.travelrepo;

import com.arkademy.travel.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TravelRepository extends JpaRepository<Travel,Long> {

}
