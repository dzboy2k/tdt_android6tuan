package topica.edu.vn;

public class XuLyCheckedError {

	public static void main(String[] args) {
		try {
			int x = 1/0;
			System.out.println("Đây là lỗi thực thi (cụ thể là chia cho 0)");
		} 
		catch (Exception ex) {
			// Xuất chi tiết lỗi để kiểm tra
			ex.printStackTrace(); 
		}
		
		System.out.println("Tạm biệt");
	}

}
