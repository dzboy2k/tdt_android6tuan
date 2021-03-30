package topica.edu.vn._01_KeThua;

public abstract class _01_NhanVien { // abstract: tính trừu tượng 
	private String ten;
	private String cmnd;
	public abstract int xuatLuong(); // Khai báo trong lớp kế thừa
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public _01_NhanVien(String ten, String cmnd) {
		super();
		this.ten = ten;
		this.cmnd = cmnd;
	}
	public _01_NhanVien() {
		super();
	}
	public String toString() {
		return this.ten+" => "+xuatLuong();
	}
}
