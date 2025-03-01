package com.springmvc.beans;

import java.util.Date;

public class PTDTrangTB {

    private int id;
    private String ptDTenThietBi;
    private String ptDAnh;
    private String ptDMoTa;
    private int ptDSoLuong;
    private String ptDTinhTrang;
    private Date ptDNgayBaoTriTiepTheo;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPtDTenThietBi() {
        return ptDTenThietBi;
    }

    public void setPtDTenThietBi(String ptDTenThietBi) {
        this.ptDTenThietBi = ptDTenThietBi;
    }

    public String getPtDAnh() {
        return ptDAnh;
    }

    public void setPtDAnh(String ptDAnh) {
        this.ptDAnh = ptDAnh;
    }

    public String getPtDMoTa() {
        return ptDMoTa;
    }

    public void setPtDMoTa(String ptDMoTa) {
        this.ptDMoTa = ptDMoTa;
    }

    public int getPtDSoLuong() {
        return ptDSoLuong;
    }

    public void setPtDSoLuong(int ptDSoLuong) {
        this.ptDSoLuong = ptDSoLuong;
    }

    public String getPtDTinhTrang() {
        return ptDTinhTrang;
    }

    public void setPtDTinhTrang(String ptDTinhTrang) {
        this.ptDTinhTrang = ptDTinhTrang;
    }

    public Date getPtDNgayBaoTriTiepTheo() {
        return ptDNgayBaoTriTiepTheo;
    }

    public void setPtDNgayBaoTriTiepTheo(Date ptDNgayBaoTriTiepTheo) {
        this.ptDNgayBaoTriTiepTheo = ptDNgayBaoTriTiepTheo;
    }
}
