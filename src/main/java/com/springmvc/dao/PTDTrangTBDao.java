package com.springmvc.dao;

import com.springmvc.beans.PTDTrangTB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("unused")
@Repository
public class PTDTrangTBdao {
    
    private JdbcTemplate jdbcTemplate;

    // Constructor Injection of JdbcTemplate
    @Autowired
    public PTDTrangTBdao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Get all devices
    public List<PTDTrangTB> getAllDevices() {
        String sql = "SELECT * FROM PTDTrangTB";
        return jdbcTemplate.query(sql, new PTDTrangTBMapper());
    }

    // Get device by ID
    public PTDTrangTB getDeviceById(int id) {
        String sql = "SELECT * FROM PTDTrangTB WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PTDTrangTBMapper());
    }

    // Add a new device
    public void addDevice(PTDTrangTB device) {
        String sql = "INSERT INTO PTDTrangTB (PTDTenThietBi, PTDAnh, PTDMoTa, PTDSoLuong, PTDTinhTrang, PTDNgayBaoTriTiepTheo) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, device.getPtDTenThietBi(), device.getPtDAnh(), device.getPtDMoTa(), 
                             device.getPtDSoLuong(), device.getPtDTinhTrang(), device.getPtDNgayBaoTriTiepTheo());
    }

    // Update an existing device
    public void updateDevice(PTDTrangTB device) {
        String sql = "UPDATE PTDTrangTB SET PTDTenThietBi = ?, PTDAnh = ?, PTDMoTa = ?, PTDSoLuong = ?, PTDTinhTrang = ?, PTDNgayBaoTriTiepTheo = ? WHERE ID = ?";
        jdbcTemplate.update(sql, device.getPtDTenThietBi(), device.getPtDAnh(), device.getPtDMoTa(), 
                             device.getPtDSoLuong(), device.getPtDTinhTrang(), device.getPtDNgayBaoTriTiepTheo(), device.getId());
    }

    // Delete a device
    public void deleteDevice(int id) {
        String sql = "DELETE FROM PTDTrangTB WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

    // RowMapper to map database rows to PTDTrangTB objects
    private static final class PTDTrangTBMapper implements RowMapper<PTDTrangTB> {
        public PTDTrangTB mapRow(ResultSet rs, int rowNum) throws SQLException {
            PTDTrangTB device = new PTDTrangTB();
            device.setId(rs.getInt("ID"));
            device.setPtDTenThietBi(rs.getString("PTDTenThietBi"));
            device.setPtDAnh(rs.getString("PTDAnh"));
            device.setPtDMoTa(rs.getString("PTDMoTa"));
            device.setPtDSoLuong(rs.getInt("PTDSoLuong"));
            device.setPtDTinhTrang(rs.getString("PTDTinhTrang"));
            device.setPtDNgayBaoTriTiepTheo(rs.getDate("PTDNgayBaoTriTiepTheo"));
            return device;
        }
    }
}
