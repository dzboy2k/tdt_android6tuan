package topica.edu.vn._02_QLNV;

public class NhanVien implements Comparable<NhanVien> { // Interface sắp xếp đối tượng
	/* Đổi thư viện java
	 * - Chọn project -> Build Path -> Configure Build Path
	 * -> Libraries -> Add Library -> JRE System Library -> Tìm 
	 * thư viện -> OK
	 */
	private int ma;
	private String ten;
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
	public NhanVien(int ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
	}
	public NhanVien() {
		super();
	}
	// 0 ==> Bằng nhau
	// >0 ==> đt1>đt2
	// <0 ==> đt1<đt2
	public int compareTo(NhanVien o) {
		// Sắp xếp chuỗi không phân biệt chữ hoa và chữ thường
		int ssTen = this.ten.compareToIgnoreCase(o.getTen()); 
		if(ssTen == 0){
			// Sắp xếp số
			if(this.ma==o.ma) 
				return 0;
			if(this.ma>o.ma)
				return -1;
			return 1;
		}
		return ssTen;
	}
}
