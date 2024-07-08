package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.model.Route;
import com.example.testpostgre.service.createrouteservice.CreateRouteService;
import com.example.testpostgre.service.route.RouteService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class RouteController {

    @Autowired
    CreateRouteService createRouteService;

    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/routes/get", method = RequestMethod.GET)
    public String getRoutes(Model model) {
        List<Route> routes=routeService.findAll();
        Collections.sort(routes, Comparator.comparingInt(Route::getDate));
        model.addAttribute("routes", routeService.findAll());
        return "routes";
    }



}
