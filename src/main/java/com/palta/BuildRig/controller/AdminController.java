package com.palta.BuildRig.controller;


import com.palta.BuildRig.Models.Cpu;
import com.palta.BuildRig.Models.CpuCooler;
import com.palta.BuildRig.data.CpuCoolerDao;
import com.palta.BuildRig.data.CpuDao;
import com.palta.BuildRig.forms.hardwareType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @Autowired
    CpuDao cpuDao;
    @Autowired
    CpuCoolerDao cpuCoolerDao;

    @RequestMapping(value = "new-item", method = RequestMethod.GET)
    public String newItem(Model model){

        hardwareType[] hardwareEnums = hardwareType.values();

        model.addAttribute("hardwareType", hardwareEnums);
        model.addAttribute("title","New Hardware");
        return "admin/add-new-hardware";
    }


    @RequestMapping(value = "add-item",  method = RequestMethod.GET)
    public String addItem(Model model, @RequestParam hardwareType hardwareEnums){

        switch (hardwareEnums){
            case CPU:
                model.addAttribute("Component",new Cpu());
                break;
            case CPU_COOLER:
                model.addAttribute("Component",new CpuCooler());
                break;
        }

        return "admin/add-hardware";
    }


    @RequestMapping(value = "add-item",  method = RequestMethod.POST)
    public String addItemProcess(Model model,
                                 @RequestParam hardwareType hardwareEnums,
                                 Cpu cpu,
                                 CpuCooler cpuCooler){

        switch (hardwareEnums){
            case CPU:
                cpuDao.save(cpu);
                break;
            case CPU_COOLER:
                cpuCoolerDao.save(cpuCooler);
                break;
        }
        return "redirect:/admin/new-item";
    }
}
