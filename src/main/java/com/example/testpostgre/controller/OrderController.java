package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.service.order.OrderService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/orders/get", method = RequestMethod.GET)
    public String getDrivers(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }
}
