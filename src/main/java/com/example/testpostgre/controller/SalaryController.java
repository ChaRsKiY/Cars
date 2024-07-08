package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.service.salaryservice.SalaryService;

@Controller
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "/salary/get", method = RequestMethod.GET)
    public String getSalary(Model model) {
        model.addAttribute("salary", salaryService.findAll());
        return "salary";
    }

}
