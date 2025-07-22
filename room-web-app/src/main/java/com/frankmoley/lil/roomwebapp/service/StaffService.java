package com.frankmoley.lil.roomwebapp.service;

import com.frankmoley.lil.roomwebapp.data.entity.Position;
import com.frankmoley.lil.roomwebapp.data.entity.StaffMember;
import com.frankmoley.lil.roomwebapp.data.repository.StaffRepository;
import com.frankmoley.lil.roomwebapp.web.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaff() {
        List<StaffMember> staffMembers = this.staffRepository.findAll();
        List<Staff> staff = new ArrayList<>(staffMembers.size());
        staffMembers.forEach(s -> staff.add(getStaffFromEntity(s)));
        return staff;
    }

    public Staff getStaffById(UUID id) {
        Optional<StaffMember> staffMember = this.staffRepository.findById(id);

        if (staffMember.isEmpty()) {
            return null;
        }

        return getStaffFromEntity(staffMember.get());
    }

    public Staff addStaff(Staff staff) {
        StaffMember staffMember = getEntityFromStaff(staff);
        staffMember = this.staffRepository.save(staffMember);
        return getStaffFromEntity(staffMember);
    }

    public Staff updateStaff(Staff staff) {
        return addStaff(staff);
    }

    public void deleteStaff(UUID id) {
        this.staffRepository.deleteById(id);
    }

    private Staff getStaffFromEntity(StaffMember staffMember) {
        return new Staff(staffMember.getEmployeeId(), staffMember.getFirstName(), staffMember.getLastName(), staffMember.getPosition().toString());
    }

    private StaffMember getEntityFromStaff(Staff staff) {
        return new StaffMember(staff.getId(), staff.getFirstName(), staff.getLastName(), getPositionFromString(staff.getPosition()));
    }

    private Position getPositionFromString(String position) {
        return switch (position) {
            case "Concierge" -> Position.CONCIERGE;
            case "Housekeeping" -> Position.HOUSEKEEPING;
            case "Front Desk" -> Position.FRONT_DESK;
            case "Security" -> Position.SECURITY;
            default -> null;
        };
    }
}
