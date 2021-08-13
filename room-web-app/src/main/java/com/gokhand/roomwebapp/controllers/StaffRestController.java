package com.gokhand.roomwebapp.controllers;

import com.gokhand.roomwebapp.models.Staff;
import com.gokhand.roomwebapp.services.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/staff")
public class StaffRestController {
    private StaffService staffService;
    public StaffRestController(StaffService staffService) {
        this.staffService = staffService;
    }
    @GetMapping
    public List<Staff> getStaff() {
        return staffService.getAllStaff();
    }

}
