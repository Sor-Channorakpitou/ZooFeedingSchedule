package com.zoo.services;

import com.zoo.dao.StaffDAO;
import com.zoo.exceptions.*;
import com.zoo.models.staff_roles.Staff;
import java.util.List;

public class StaffService {

    private final List<Staff> users;
    private final StaffDAO staffDAO;

    public StaffService(List<Staff> users, StaffDAO staffDAO) {
        this.users = users;
        this.staffDAO = staffDAO;
    }

    // Authentication
    public Staff login(String username, String password) throws ZooException {
        if (username == null || username.isBlank() || password == null) {
            throw new ZooException("Login failed: missing email/password.");
        }

        Staff user = staffDAO.login(username, password);

        if (!user.isActive()) {
            throw new ZooException("Login failed: staff is inactive.");
        }
        if (!user.checkPassword(password)) {
            throw new AuthenticationException("Login failed: wrong password.");
        }

        return user;
    }

    // CRUD                                                               
    public Staff createStaff(String fullName, String position, String username, String password,
                             float salary) throws ZooException {

        Zoo.validateName("Full name", fullName);
        Zoo.validateName("Username", username);

        if (salary < 0) {
            throw new OutOfRangeException("Salary cannot be negative.");
        }

        boolean exists = users.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(username.trim()));
        if (exists) {
            throw new ZooException("Cannot create staff: username already exists.");
        }

        Staff newStaff = staffDAO.createStaff(fullName, position, username, password, salary);
        users.add(newStaff);
        return newStaff;
    }

    public void removeStaff(int staffId) throws ZooException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == staffId) {
                staffDAO.deleteStaff(staffId);
                users.remove(i);
                return;
            }
        }
        throw new ZooException("Staff not found.");
    }
}