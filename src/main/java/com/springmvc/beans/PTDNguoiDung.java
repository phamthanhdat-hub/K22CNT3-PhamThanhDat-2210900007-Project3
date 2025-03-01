package com.springmvc.beans;

public class PTDNguoiDung {

    private int id;
    private String ptDten;
    private String ptDEmail;
    private String ptDVaiTro;
    private String ptDMatKhau;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPtDten() {
        return ptDten;
    }

    public void setPtDten(String ptDten) {
        this.ptDten = ptDten;
    }

    public String getPtDEmail() {
        return ptDEmail;
    }

    public void setPtDEmail(String ptDEmail) {
        this.ptDEmail = ptDEmail;
    }

    public String getPtDVaiTro() {
        return ptDVaiTro;
    }

    public void setPtDVaiTro(String ptDVaiTro) {
        this.ptDVaiTro = ptDVaiTro;
    }

    public String getPtDMatKhau() {
        return ptDMatKhau;
    }

    public void setPtDMatKhau(String ptDMatKhau) {
        this.ptDMatKhau = ptDMatKhau;
    }
}
