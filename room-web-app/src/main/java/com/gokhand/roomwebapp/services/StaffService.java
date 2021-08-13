package com.gokhand.roomwebapp.services;

import com.gokhand.roomwebapp.data.StaffRepository;
import com.gokhand.roomwebapp.models.Staff;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();}


}
