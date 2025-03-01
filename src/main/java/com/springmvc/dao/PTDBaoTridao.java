package com.springmvc.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.beans.PTDBaoTri;

@SuppressWarnings("unused")
public class PTDBaoTridao {
	@Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all maintenance records
    public List<PTDBaoTri> getAllPTDBaoTri() {
        String sql = "SELECT * FROM PTDBaoTri";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PTDBaoTri.class));
    }

    // Get a maintenance record by ID
    public PTDBaoTri getById(int id) {
        String sql = "SELECT * FROM PTDBaoTri WHERE PTDThietBiID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(PTDBaoTri.class));
    }

    // Save or update a maintenance record
    public void saveOrUpdate(PTDBaoTri ptDBaoTri) {
        String sql = "INSERT INTO PTDBaoTri (PTDThietBiID, PTDNgayBaoTri, PTDMoTaBaoTri, PTDChiPhi, PTDNguoiThucHien) " +
                     "VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE PTDNgayBaoTri = ?, PTDMoTaBaoTri = ?, PTDChiPhi = ?, PTDNguoiThucHien = ?";
        jdbcTemplate.update(sql, ptDBaoTri.getPtdThietBiID(), ptDBaoTri.getPtdNgayBaoTri(), ptDBaoTri.getPtdMoTaBaoTri(),
                ptDBaoTri.getPtdChiPhi(), ptDBaoTri.getPtdNguoiThucHien(), ptDBaoTri.getPtdNgayBaoTri(), ptDBaoTri.getPtdMoTaBaoTri(),
                ptDBaoTri.getPtdChiPhi(), ptDBaoTri.getPtdNguoiThucHien());
    }

    // Delete a maintenance record by ID
    public void delete(int id) {
        String sql = "DELETE FROM PTDBaoTri WHERE PTDThietBiID = ?";
        jdbcTemplate.update(sql, id);
    }
}
