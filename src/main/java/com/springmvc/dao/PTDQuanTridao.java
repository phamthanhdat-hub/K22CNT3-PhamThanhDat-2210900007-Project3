package com.springmvc.dao;

import com.springmvc.beans.PTDQuanTri;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PTDQuanTridao {
    private JdbcTemplate template;

    // Setter for JdbcTemplate
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // Save new admin account
    public int addAdminAccount(PTDQuanTri adminAccount) {
        String sql = "INSERT INTO PTDQuanTri (PTDTaiKhoan, PTDTrangThai) VALUES (?, ?)";
        return template.update(sql, adminAccount.getPtDTaikhoan(), adminAccount.getPtDTrangthai());
    }

    // Update existing admin account
    public int updateAdminAccount(PTDQuanTri adminAccount) {
        String sql = "UPDATE PTDQuanTri SET PTDTaiKhoan = ?, PTDTrangThai = ? WHERE PTDTaiKhoan = ?";
        return template.update(sql, adminAccount.getPtDTaikhoan(), adminAccount.getPtDTrangthai(), adminAccount.getPtDTaikhoan());
    }

    // Delete admin account by username
    public int deleteAdminAccount(String username) {
        String sql = "DELETE FROM PTDQuanTri WHERE PTDTaiKhoan = ?";
        return template.update(sql, username);
    }

    // Get admin account by username
    public PTDQuanTri getAdminAccountByUsername(String username) {
        String sql = "SELECT * FROM PTDQuanTri WHERE PTDTaiKhoan = ?";
        return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<>(PTDQuanTri.class));
    }

    // Get all admin accounts
    public List<PTDQuanTri> getAllAdminAccounts() {
        String sql = "SELECT * FROM PTDQuanTri";
        return template.query(sql, new BeanPropertyRowMapper<>(PTDQuanTri.class));
    }
}
