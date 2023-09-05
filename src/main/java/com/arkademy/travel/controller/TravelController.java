package com.arkademy.travel.controller;

import com.arkademy.travel.dto.TravelDto;
import com.arkademy.travel.entity.Travel;
import com.arkademy.travel.service.TravelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@Controller
@RequestMapping("/travels")
public class TravelController {
    private TravelService travelService;
    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("")
    public String listTravel(Model model) {
        List<TravelDto> travel = travelService.findAllTravel();
        log.info("travel info {} ",travel);
        model.addAttribute("travel", travel);
        return "/reservation/reservation-list";
    }
    @GetMapping("/new")
    public String createTravel(Model model){
        TravelDto travelDto = new TravelDto();
        model.addAttribute("travel",travelDto);
        return "/reservation/reservation-add";
    }
    @PostMapping("/save")
    public String saveTravel(@ModelAttribute("travel") TravelDto travelDto, Model model){
        model.addAttribute("travel",travelDto);
        travelService.saveTravel(travelDto);
        return "redirect:/travels";
    }
    @GetMapping("/{travelId}/edit")
    public String editTravel(@PathVariable ("travelId") Long travel,Model model){
        TravelDto travelDto = travelService.findTravelById(travel);
        model.addAttribute("travelId",travelDto);
        return "/reservation/reservation-edit";
    }
    @PostMapping("/{travelId}/update")
    public String updateTravel(@PathVariable( value = "travelId") Long travelId,@ModelAttribute("travel") TravelDto travelDto, Model model){
        model.addAttribute("travelId",travelDto);
        travelDto.setId(travelId);
        travelService.updateTravel(travelDto);
        return "/reservation/reservation-list";
    }
    @GetMapping("/{travelId}/delete")
    public String deleteClub(@PathVariable("travelId") Long travelId) {
        travelService.deleteTravel(travelId);
        return "redirect:/travels";
    }
    @GetMapping("/about")
    public String aboutTravel(Model model) {
        String titleAbout = "About Us";
        String about = "More than 10 years, Arkademy Travel service has grow at a steady pace and become one " +
                "of Indonesia's leading travel agent offering a complete travel solution for both leisure" +
                " and business travels.The company has over 500 staff within 24 branches across the county";
        model.addAttribute("about", about);
        model.addAttribute("aboutUs", titleAbout);
        return "/reservation/reservation-about";
    }
    @GetMapping("/{travelId}")
    public String detailTravel(@PathVariable ("travelId")Long travelId, Model model){
        TravelDto travelDto= travelService.findTravelById(travelId);
        model.addAttribute("travelId",travelDto);
        return "/reservation/reservation-detail";
    }
}