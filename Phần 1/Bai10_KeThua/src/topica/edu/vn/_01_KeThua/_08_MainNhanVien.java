package topica.edu.vn._01_KeThua;

public class _08_MainNhanVien {
	public static void main(String[] args) {
		_01_NhanVien teo = new _02_NhanVienChinhThuc();
		teo.setTen("Nguyễn Văn Tèo");
		System.out.println(teo);
		
		_02_NhanVienChinhThuc ty = new _02_NhanVienChinhThuc();
		ty.setTen("Trần Thị Tý");
		System.out.println(ty);
		
		// Tính đa hình: tạo nên bới tính kế thừa
		teo = new _03_NhanVienThoiVu(); // Ctrl + Click: Đến lớp được click
		teo.setTen("Nguyễn Văn Tèo");
		System.out.println(teo);
	}
}
