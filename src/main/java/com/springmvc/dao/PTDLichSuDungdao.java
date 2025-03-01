package com.springmvc.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.springmvc.beans.PTDLichSuDung;

@Repository
public class PTDLichSuDungdao {

    private JdbcTemplate jdbcTemplate;

    // Constructor injection for JdbcTemplate
    @Autowired
    public PTDLichSuDungdao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Create or Update record
    public int saveOrUpdate(PTDLichSuDung lichSuDung) {
        if (lichSuDung.getId() == 0) {
            String sql = "INSERT INTO PTDLichSuDung (PTDThietBiID, PTDNguoiDungID, PTDNgaySuDung, PTDMucDichSuDung) VALUES (?, ?, ?, ?)";
            return jdbcTemplate.update(sql, lichSuDung.getPtdThietBi(), lichSuDung.getPtdNguoiDung(),
                    lichSuDung.getPtdNgaySuDung(), lichSuDung.getPtdMucDichSuDung());
        } else {
            String sql = "UPDATE PTDLichSuDung SET PTDThietBiID = ?, PTDNguoiDungID = ?, PTDNgaySuDung = ?, PTDMucDichSuDung = ? WHERE ID = ?";
            return jdbcTemplate.update(sql, lichSuDung.getPtdThietBi(), lichSuDung.getPtdNguoiDung(),
                    lichSuDung.getPtdNgaySuDung(), lichSuDung.getPtdMucDichSuDung(), lichSuDung.getId());
        }
    }

    // Get a single record by ID
    public PTDLichSuDung getById(int id) {
        String sql = "SELECT * FROM PTDLichSuDung WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(PTDLichSuDung.class));
    }

    // Get all records
    public List<PTDLichSuDung> getAll() {
        String sql = "SELECT * FROM PTDLichSuDung";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PTDLichSuDung.class));
    }

    // Delete record by ID
    public int delete(int id) {
        String sql = "DELETE FROM PTDLichSuDung WHERE ID = ?";
        return jdbcTemplate.update(sql, id);
    }
}
