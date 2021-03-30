package topica.edu.vn._01_KeThua;

public class _02_NhanVienChinhThuc extends _01_NhanVien { // Tính kế thừa

	public int xuatLuong() {
		return 5000;
	}

	public String toString() {
		// sau super: ctrl + click chuột -> đến lớp cha
		return super.toString() + " ==> vì là nhân viên chính thức"; 
		// super: gọi lớp cha
	}
	
	/* Tổng quát hóa và chuyên biệt hóa
	 * - Những thông tin nào là chung (giống nhau) cho mọi đối tượng
	 * 		=> Tập hợp tạo thành 1 lớp cha => Tổng quát hóa
	 * 
	 * - Những thông tin hoàn toàn khác nhau, chỉ có trong từng đối tượng 
	 * cụ thể nào đó => Tạo lớp con (lớp con nào đã kế thừa thông tin chung 
	 * từ lớp cha rồi) => Chuyên biệt hóa   
	 */
	
	/* Dowload objuml java cho Eclipse- hỗ trợ trình diễn các class
	 *  - Search "objuml java" -> objectaid.com -> Download 
	 * -> Copy URL: http://www.objectaid.com/update/current
	 *  
	 *  - Vào Eclipse -> Help -> Install New Software... -> Add 
	 * -> Paste URL vào Name, Locations -> OK -> Tích vào ObjectAid UML Explorer
	 * -> Next -> Finish -> Restart lại máy
	 */
	
	/* Sử dụng objuml java
	 * Chọn Project -> Other -> ObjectAid UML Diagram -> Class Diagram -> Tạo file
	 * Chọn các file class của java thả vào file vừa tạo (.ucls)
	 */
}


