package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.model.*;
import com.example.testpostgre.service.truckrepairservice.TruckRepairService;

@Controller
public class TruckRepairController {

    @Autowired
    private TruckRepairService repairService;


    @RequestMapping(value = "/truckrepair/get", method = RequestMethod.GET)
    public String getTruckRepair(Model model) {
        model.addAttribute("truckrepair", repairService.findAll());
        return "truckrepair";
    }

}
