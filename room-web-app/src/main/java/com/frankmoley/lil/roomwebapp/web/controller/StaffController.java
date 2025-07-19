package com.frankmoley.lil.roomwebapp.web.controller;

import com.frankmoley.lil.roomwebapp.data.entity.StaffMember;
import com.frankmoley.lil.roomwebapp.data.repository.StaffRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping
    public String getStaffPage(Model model) {
        List<StaffMember> staffMembers = this.staffRepository.findAll();
        List<com.frankmoley.lil.roomwebapp.web.model.StaffMember> staff = new ArrayList<>(staffMembers.size());
        staffMembers.forEach(e -> staff.add(new com.frankmoley.lil.roomwebapp.web.model.StaffMember(e.getEmployeeId(), e.getFirstName(), e.getLastName(), e.getPosition().toString())));
        model.addAttribute("staff", staff);
        return "staff";
    }
}
