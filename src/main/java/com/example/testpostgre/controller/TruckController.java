package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.service.truckservice.TruckService;

@Controller
public class TruckController {

    @Autowired
    private TruckService trService;

    @RequestMapping(value = "/trucks/get", method = RequestMethod.GET)
    public String getSubjects(Model model) {
        model.addAttribute("trucks", trService.findAll());
        return "trucks";
    }



}
