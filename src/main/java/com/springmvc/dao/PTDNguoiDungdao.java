package com.springmvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.beans.PTDNguoiDung;

@SuppressWarnings("unused")
public class PTDNguoiDungdao {
	private JdbcTemplate jdbcTemplate;

    public void PTDNguoiDungDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Get all users
    public List<PTDNguoiDung> getAllUsers() {
        String sql = "SELECT * FROM PTDNguoiDung";
        return jdbcTemplate.query(sql, new PTDNguoiDungMapper());
    }

    // Get a user by ID
    public PTDNguoiDung getUserById(int id) {
        String sql = "SELECT * FROM PTDNguoiDung WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PTDNguoiDungMapper());
    }

    // Add a new user
    public void addUser(PTDNguoiDung user) {
        String sql = "INSERT INTO PTDNguoiDung (ID, PTDTen, PTDEmail, PTDVaiTro, PTDMatKhau) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getId(), user.getPtDten(), user.getPtDEmail(), user.getPtDVaiTro(), user.getPtDMatKhau());
    }

    // Update an existing user
    public void updateUser(PTDNguoiDung user) {
        String sql = "UPDATE PTDNguoiDung SET PTDTen = ?, PTDEmail = ?, PTDVaiTro = ?, PTDMatKhau = ? WHERE ID = ?";
        jdbcTemplate.update(sql, user.getPtDten(), user.getPtDEmail(), user.getPtDVaiTro(), user.getPtDMatKhau(), user.getId());
    }

    // Delete a user by ID
    public void deleteUser(int id) {
        String sql = "DELETE FROM PTDNguoiDung WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

    // RowMapper to map result set to PTDNguoiDung object
    private static final class PTDNguoiDungMapper implements RowMapper<PTDNguoiDung> {
        public PTDNguoiDung mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            PTDNguoiDung user = new PTDNguoiDung();
            user.setId(rs.getInt("ID"));
            user.setPtDten(rs.getString("PTDTen"));
            user.setPtDEmail(rs.getString("PTDEmail"));
            user.setPtDVaiTro(rs.getString("PTDVaiTro"));
            user.setPtDMatKhau(rs.getString("PTDMatKhau"));
            return user;
        }
    }
}