package topica.edu.vn;

public class Excepcion {
	public static void main(String[] args) {
		// int x=1.5; // Lỗi biên dịch - viết đâu sai đó
		// int x=1/0; // Lỗi thực thi - Chạy lên tắt ngang chương trình
		
		// Lỗi làm sai nghiệp vụ
		double toan = 5;
		double ly = 7;
		double hoa = 4;
		// (toan*2+ly+hoa)/4
		double dtb=(toan+ly+hoa)/3;
		System.out.println(dtb);
		
		// Unchecked error: Thấy lỗi không sửa
		// Checked error: Thấy sẽ sửa
		
		// Gỡ lỗi logic bằng công cụ debug
		/* 1. Chọn số thứ tự ở đầu dòng cần kiểm tra -> Chuột phải 
		 * 		-> Toggle Breakpoint hoặc (Run -> Toggle Breakpoint) 
		 * 		hoặc (Ctrl + Shift + B)   
		 * 2. Run -> Debug (F11) -> Yes
		 * 3. Run -> Step Over (F6)
		 */
	}
}
