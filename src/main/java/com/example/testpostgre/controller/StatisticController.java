package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.model.*;
import com.example.testpostgre.service.statisticservice.StatisticService;

@Controller
public class StatisticController {


    @Autowired
    private StatisticService statService;

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public String getStat(Model model) {
        model.addAttribute("driver", statService.findDriver());
        model.addAttribute("destination", statService.findDestination());
        model.addAttribute("cargo", statService.findCargo());
       model.addAttribute("mincargo", statService.findMinWeightCargo());
        model.addAttribute("orders", statService.findCargoIn());
        return "statistic";
    }



    }
