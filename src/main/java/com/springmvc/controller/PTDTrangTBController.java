package com.springmvc.controller;

import com.springmvc.beans.PTDTrangTB;
import com.springmvc.dao.PTDTrangTBdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/thietbi")
public class PTDTrangTBController {

    @Autowired
    private PTDTrangTBdao deviceDAO;

    // List all devices
    @GetMapping("/list")
    public String listDevices(Model model) {
        List<PTDTrangTB> devices = deviceDAO.getAllDevices();
        model.addAttribute("devices", devices);
        return "listDevices"; // View name
    }

    // Show form to add a new device
    @GetMapping("/add")
    public String showAddForm(Model model) {
        PTDTrangTB device = new PTDTrangTB();
        model.addAttribute("device", device);
        return "deviceForm"; // View name for adding a new device
    }

    // Save or update device
    @PostMapping("/save")
    public String saveDevice(@ModelAttribute PTDTrangTB device) {
        if (device.getId() == 0) {
            deviceDAO.addDevice(device); // Add new device
        } else {
            deviceDAO.updateDevice(device); // Update existing device
        }
        return "redirect:/thietbi/list"; // Redirect to list after saving
    }

    // Show form to edit a device
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        PTDTrangTB device = deviceDAO.getDeviceById(id);
        model.addAttribute("device", device);
        return "deviceForm"; // View name for editing a device
    }

    // Delete a device
    @GetMapping("/delete/{id}")
    public String deleteDevice(@PathVariable int id) {
        deviceDAO.deleteDevice(id);
        return "redirect:/thietbi/list"; // Redirect after deletion
    }
}
