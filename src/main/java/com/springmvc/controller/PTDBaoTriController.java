package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.beans.PTDBaoTri;
import com.springmvc.dao.PTDBaoTridao;

public class PTDBaoTriController {
	@Autowired
    private PTDBaoTridao ptDBaoTriDAO;

    // List all maintenance records
    @GetMapping("")
    public String listPTDBaoTri(Model model) {
        model.addAttribute("baotris", ptDBaoTriDAO.getAllPTDBaoTri());
        return "baotri_list";
    }

    // Show form to add a new maintenance record
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("baotri", new PTDBaoTri());
        return "baotri_form";
    }

    // Save or update a maintenance record
    @PostMapping("/save")
    public String savePTDBaoTri(@ModelAttribute("baotri") PTDBaoTri ptDBaoTri) {
        ptDBaoTriDAO.saveOrUpdate(ptDBaoTri);
        return "redirect:/baotri";
    }

    // Show form to edit an existing maintenance record
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("baotri", ptDBaoTriDAO.getById(id));
        return "baotri_form";
    }

    // Delete a maintenance record
    @GetMapping("/delete/{id}")
    public String deletePTDBaoTri(@PathVariable("id") int id) {
        ptDBaoTriDAO.delete(id);
        return "redirect:/baotri";
    }

}
