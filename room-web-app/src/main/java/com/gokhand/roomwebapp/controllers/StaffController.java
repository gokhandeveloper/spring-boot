package com.gokhand.roomwebapp.controllers;
import com.gokhand.roomwebapp.services.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private StaffService staffService;

    public StaffController(StaffService staffService){
        this.staffService =staffService;
    }
    @GetMapping
    public String getAllStaff(Model model) {
        model.addAttribute("staffs", staffService.getAllStaff());
        return "staff";
    }
}