package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.testpostgre.dto.SalaryDTO;
import com.example.testpostgre.model.Salary;
import com.example.testpostgre.service.driverservice.DriverService;
import com.example.testpostgre.service.salaryservice.SalaryService;

import java.util.List;

@Controller
public class SalaryOfDriverController {

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private DriverService driverService;

    @RequestMapping(value = "/salaryDriver", method = RequestMethod.GET)
    public String getDrivers(Model model) {
        model.addAttribute("drivers", driverService.findAll());
        return "salaryDriver";
    }

    @RequestMapping(value = "/salary/driver", method = RequestMethod.POST)
    public String salaryDriver(@RequestParam("driverId") Long id,
                               Model model) {
        List<Salary> salary = salaryService.findByIdLike(id);
        SalaryDTO sal=new SalaryDTO();
        sal.setSalary(salary);
        double summa=0;
        if(!salary.isEmpty()) {
            for (var s : salary) {
                summa += s.getSumma();
            }
            sal.setAllSumma(summa);
            sal.setName(salary.get(0).getDriverId().getFullName());
        }
        model.addAttribute("salaryDTO",sal);
        return "salaryOfDriver";
    }

}
