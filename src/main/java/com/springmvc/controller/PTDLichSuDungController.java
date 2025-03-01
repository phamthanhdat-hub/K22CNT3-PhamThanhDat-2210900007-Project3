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

import com.springmvc.beans.PTDLichSuDung;
import com.springmvc.dao.PTDLichSuDungdao;

@Controller
@RequestMapping("/lichsudung") // Base URL mapping for Lich Su Dung
public class PTDLichSuDungController {

    @Autowired
    private PTDLichSuDungdao lichSuDungDAO;

    @GetMapping("")
    public String listPTDLichSuDung(Model model) {
        List<PTDLichSuDung> lichSuDungList = lichSuDungDAO.getAll();
        model.addAttribute("lichSuDungs", lichSuDungList);
        return "lichsudung_list"; // View Name
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("lichSuDung", new PTDLichSuDung());
        return "lichsudung_form"; // View Name for adding
    }

    @PostMapping("/save")
    public String savePTDLichSuDung(@ModelAttribute("lichSuDung") PTDLichSuDung lichSuDung) {
        lichSuDungDAO.saveOrUpdate(lichSuDung);
        return "redirect:/lichsudung"; // Redirect after saving
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        PTDLichSuDung lichSuDung = lichSuDungDAO.getById(id);
        model.addAttribute("lichSuDung", lichSuDung);
        return "lichsudung_form"; // View Name for editing
    }

    @GetMapping("/delete/{id}")
    public String deletePTDLichSuDung(@PathVariable("id") int id) {
        lichSuDungDAO.delete(id);
        return "redirect:/lichsudung"; // Redirect after deleting
    }
}
