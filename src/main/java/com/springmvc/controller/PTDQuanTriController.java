package com.springmvc.controller;

import com.springmvc.beans.PTDQuanTri;
import com.springmvc.dao.PTDQuanTridao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/quantri")
public class PTDQuanTriController {

    @Autowired
    private PTDQuanTridao quanTriDAO;

    // List all admin accounts
    @GetMapping("/list")
    public String listAdminAccounts(Model model) {
        List<PTDQuanTri> adminAccounts = quanTriDAO.getAllAdminAccounts();
        model.addAttribute("adminAccounts", adminAccounts);
        return "listAdminAccounts"; // View name
    }

    // Show form to add a new admin account
    @GetMapping("/add")
    public String showAddForm(Model model) {
        PTDQuanTri adminAccount = new PTDQuanTri();
        model.addAttribute("adminAccount", adminAccount);
        return "adminAccountForm"; // View name for adding an admin account
    }

    // Save or update admin account
    @PostMapping("/save")
    public String saveAdminAccount(@ModelAttribute PTDQuanTri adminAccount) {
        if (adminAccount.getPtDTaikhoan() == null || adminAccount.getPtDTaikhoan().isEmpty()) {
            quanTriDAO.addAdminAccount(adminAccount); // Add new admin account
        } else {
            quanTriDAO.updateAdminAccount(adminAccount); // Update existing admin account
        }
        return "redirect:/quantri/list"; // Redirect to list after saving
    }

    // Show form to edit an admin account
    @GetMapping("/edit/{username}")
    public String showEditForm(@PathVariable String username, Model model) {
        PTDQuanTri adminAccount = quanTriDAO.getAdminAccountByUsername(username);
        model.addAttribute("adminAccount", adminAccount);
        return "adminAccountForm"; // View name for editing admin account
    }

    // Delete an admin account
    @GetMapping("/delete/{username}")
    public String deleteAdminAccount(@PathVariable String username) {
        quanTriDAO.deleteAdminAccount(username);
        return "redirect:/quantri/list"; // Redirect after deletion
    }
}
