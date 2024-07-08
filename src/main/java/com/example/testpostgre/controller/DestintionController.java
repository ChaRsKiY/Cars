package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.service.destination.DestinationService;

@Controller
public class DestintionController {

    @Autowired
    DestinationService destinationService;

    @RequestMapping(value = "/destinations/get", method = RequestMethod.GET)
    public String getDestinations(Model model) {
        model.addAttribute("destinations", destinationService.findAll());
        return "destinations";
    }
}
