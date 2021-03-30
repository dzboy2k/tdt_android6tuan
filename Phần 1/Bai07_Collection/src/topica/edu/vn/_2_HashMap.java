package topica.edu.vn;

import java.util.HashMap;

public class _2_HashMap {
	public static void main(String[] args) {
		HashMap<Integer, String> ds = new HashMap<Integer, String>(); // Cấp phát bộ nhớ
		//  Integer: khóa chính, String: thông tin liên quan đến khóa chính
		ds.put(113, "Nguyễn Văn Tèo, quê ở Trường Sa"); // Thêm mới dữ liệu
		ds.put(114, "Trần Thị Mẹt, quê ở Hoàng Sa");
		ds.put(115, "Nguyễn Văn Tủn, quê Cà Mau");
		
		String nv = ds.get(114); // Lấy thông tin từ khóa chính
		System.out.println(nv);
		
		// Duyệt thông tin
		System.out.println("Nhân viên toàn bộ của công ty:");
		for (String ten : ds.values()) { //ds.values: thông tin của đối tượng
			System.out.println(ten);
		}
		
		ds.remove(115); // Xóa thông tin
		System.out.println("Nhân viên sau khi xóa:");
		for (String ten : ds.values()) { 
			System.out.println(ten);
		}
	}
}
