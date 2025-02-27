package com.springmvc.beans;

import java.sql.Date;

public class PTDLichSuDung {
	private int id;

 
    private PTDTrangTB ptdThietBi;

    
    private PTDNguoiDung ptdNguoiDung;

   
    private Date ptdNgaySuDung;

   
    private String ptdMucDichSuDung;


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the ptdThietBi
	 */
	public PTDTrangTB getPtdThietBi() {
		return ptdThietBi;
	}


	/**
	 * @param ptdThietBi the ptdThietBi to set
	 */
	public void setPtdThietBi(PTDTrangTB ptdThietBi) {
		this.ptdThietBi = ptdThietBi;
	}


	/**
	 * @return the ptdNguoiDung
	 */
	public PTDNguoiDung getPtdNguoiDung() {
		return ptdNguoiDung;
	}


	/**
	 * @param ptdNguoiDung the ptdNguoiDung to set
	 */
	public void setPtdNguoiDung(PTDNguoiDung ptdNguoiDung) {
		this.ptdNguoiDung = ptdNguoiDung;
	}


	/**
	 * @return the ptdNgaySuDung
	 */
	public Date getPtdNgaySuDung() {
		return ptdNgaySuDung;
	}


	/**
	 * @param ptdNgaySuDung the ptdNgaySuDung to set
	 */
	public void setPtdNgaySuDung(Date ptdNgaySuDung) {
		this.ptdNgaySuDung = ptdNgaySuDung;
	}


	/**
	 * @return the ptdMucDichSuDung
	 */
	public String getPtdMucDichSuDung() {
		return ptdMucDichSuDung;
	}


	/**
	 * @param ptdMucDichSuDung the ptdMucDichSuDung to set
	 */
	public void setPtdMucDichSuDung(String ptdMucDichSuDung) {
		this.ptdMucDichSuDung = ptdMucDichSuDung;
	}


}
