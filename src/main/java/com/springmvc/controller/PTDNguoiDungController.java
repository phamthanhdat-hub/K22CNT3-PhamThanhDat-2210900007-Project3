package com.springmvc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.beans.PTDNguoiDung;
import com.springmvc.dao.PTDNguoiDungdao;

@Controller
@RequestMapping("/nguoidung") // Set base URL for the controller
public class PTDNguoiDungController {
    
    @Autowired
    private PTDNguoiDungdao nguoiDungDAO;

    // Show all users
    @GetMapping("/list")
    public String listUsers(Model model) {
        List<PTDNguoiDung> users = nguoiDungDAO.getAllUsers();
        model.addAttribute("users", users);
        return "listUsers"; // View name
    }

    // Show form to add a new user
    @GetMapping("/add")
    public String showAddForm(Model model) {
        PTDNguoiDung user = new PTDNguoiDung();
        model.addAttribute("user", user);
        return "userForm"; // View name for adding a user
    }

    // Save or update user
    @PostMapping("/save")
    public String saveUser(@ModelAttribute PTDNguoiDung user) {
        if (user.getId() == 0) {
            nguoiDungDAO.addUser(user); // Add new user
        } else {
            nguoiDungDAO.updateUser(user); // Update existing user
        }
        return "redirect:/nguoidung/list"; // Redirect after saving
    }

    // Show form to edit a user
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        PTDNguoiDung user = nguoiDungDAO.getUserById(id);
        model.addAttribute("user", user);
        return "userForm"; // View name for editing a user
    }

    // Delete a user
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        nguoiDungDAO.deleteUser(id);
        return "redirect:/nguoidung/list"; // Redirect after deletion
    }
}
