package topica.edu.vn;

public class _1_KhachHang { // Tên lớp: viết hoa kí tự đầu tiên của các từ 
	
	private String ma; // Đặt tên thuộc tính
	private String ten;
	private int tuoi;
	private String diaChi;
	
	// Static: Chia sẻ 1 phần ô nhớ
	private static double x;
	public void doiThongTinCuaX(int gtmoi){
		x=gtmoi;
	}
	public double layThongTinX(){
		return x;
	}
	
	// Source -> Generate Getters and Setters...: tự động tạo
	// Show line number: Hiển thị số dòng
	// Folding -> Collapse All : Gom nhóm hàm lại với nhau
	// Folding -> Expand All : Bỏ gom nhóm 
	
	public String getMa() { // Lấy thông tin
		return this.ma;
	}
	public void setMa(String ma) { // Thay đổi thông tin
		this.ma = ma;
	}

	public String getTen() {
		return this.ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return this.tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getDiaChi() {
		return this.diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	//Hàm tạo constructor: tự động khởi tạo các thông tin mặc đinh khi đối tượng được tạo ra
	public _1_KhachHang() {
		System.out.println("Constructor mặc định tự động được gọi");
	}
	// constructor đầy đủ đối số
	public _1_KhachHang(String ma, String ten, int tuoi, String diaChi) {
		this.ma = ma;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diaChi = diaChi;
	}
	public String toString() { // Xuất thông tin
			return this.ma+";"+this.ten+";"+this.tuoi+";"+this.diaChi;
	}
}
