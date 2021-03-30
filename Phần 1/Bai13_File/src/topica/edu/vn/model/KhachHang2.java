package topica.edu.vn.model;

import java.io.Serializable;

public class KhachHang2 implements Serializable {
	/* io : tương tác file
	 * model : mô hình hóa
	 * test : kiểm tra model
	 */
	private String ma;
	private String ten;
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public KhachHang2(String ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
	}
	public KhachHang2() {
		super();
	}
	public String toString() {
		return this.ma +"\t"+ this.ten;
	}
}
