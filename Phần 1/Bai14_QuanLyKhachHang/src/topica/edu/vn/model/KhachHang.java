package topica.edu.vn.model;

import java.io.Serializable;

// implements thêm interface -> Thay đổi định dạng -> Không đọc được file 
// -> Nhập lại dữ liệu và lưu File -> Đọc được File
public class KhachHang implements Serializable, Comparable<KhachHang> {
	private int ma;
	private String ten;
	private String phone;
	public int getMa() {
		return ma;
	}
	public void setMa(int ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public KhachHang(int ma, String ten, String phone) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.phone = phone;
	}
	public KhachHang() {
		super();
	}
	public String toString() {
		return this.ma+"\t"+this.ten+"\t"+this.phone;
	}
	public int compareTo(KhachHang o) { 
		// So sánh chuỗi không phân biệt chữ hoa chữ thuòng
		return this.phone.compareToIgnoreCase(o.phone);
	}
}
