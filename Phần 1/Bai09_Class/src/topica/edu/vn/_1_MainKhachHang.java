package topica.edu.vn;

public class _1_MainKhachHang {

	public static void main(String[] args) {
		_1_KhachHang teo = new _1_KhachHang();
		teo.setMa("NV1");
		// teo.ma = "NV1"; // KO ĐƯỢC
		teo.setTen("Trần Văn Tèo");
		teo.setTuoi(30);
		teo.setDiaChi("Cà Mau");
		System.out.println(teo);
		
		System.out.println("Tui chỉ muốn lấy địa chỉ = "+teo.getDiaChi());
		
		/* Alias và cơ chế gom rác tự đọng
		 * Tại ô nhớ có 2 biến đối tượng x và y cùng trỏ tới
		 * -> Tại ô nhớ có hơn 1 biến đối tượng quản lý 
		 * -> Alias, Y thay đổi thì X cũng thay đổi
		 * -> Ô nhớ X bây giờ không có biến đối tượng nào quản lý
		 * -> Hệ thống sẽ gom rác tự động (thu hồi ô nhớ đã cấp phát)
		 */
		
		_1_KhachHang ty = new _1_KhachHang();
		ty.setTen("Hồ Thị Tí");
		
		System.out.println("Tên của Tèo = "+teo.getTen());
		System.out.println("Tên của Tý = "+ty.getTen());
		
		teo=ty; // Trỏ tới ô nhớ
		teo.setTen("Hồ Văn Đồ");
		System.out.println("Tên của Tý = "+ty.getTen());
		
		System.out.println("x="+teo.layThongTinX());
		_1_KhachHang an = new _1_KhachHang();
		an.doiThongTinCuaX(100);
		System.out.println("x="+teo.layThongTinX());
		
		_1_KhachHang binh = new _1_KhachHang();
		System.out.println("x của Bình ="+binh.layThongTinX());
	}

}
