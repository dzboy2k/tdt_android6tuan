package topica.edu.vn._01_chuoi;

public class _1_Chuoi_String {
	public static void main(String[] args) {
		// Khai báo chuỗi
		String s1 = new String();
		String s2 = "Hello";
		
		// Các phương thức xử lý trên kiểu String
		String s = "Happy ";
		s1 = "New Year";
		s2 = "New Year";
		System.out.println("s1="+s.length()); // Tính chiều dài chuỗi
		
		s=s.concat(s1); // Nối chuỗi s1 vào chuỗi s <-> s + s1
		System.out.println("s2="+s); 
		
		System.out.println("s3="+s.charAt(8)); 
		// Lấy một kí tự tại vị trí thứ 8 của s
		
		System.out.println("s4="+s2.compareTo(s1)); 
		// So sánh chuỗi, trả về 0-(s2=s1), <0-(s2<s1) hoặc >0-(s2>s1)
		
		System.out.println("s5="+s.indexOf(s2)); 
		// Tìm vị trí xuất hiện đầu tiên của chuỗi s2 trong chuỗi s
		
		System.out.println("s6="+s.lastIndexOf(s2)); 
		// Tìm vị trí xuất hiện cuối cùng của chuỗi s2 trong chuỗi s 
		// (trả về -1 nếu không tìm thấy)
		
		s1 = "Happy";
		s2 = "New";
		System.out.println("s7="+s.replace(s1,s2));
		// Thay thế chuỗi s1 bằng chuỗi s2 trong chuỗi s
		
		 String s3 = "  Hello  Bi    !     ";
		 System.out.println("s8="+s3.trim()+"Bi");
		// Loại bỏ khoảng trắng dư thừa ở đầu và cuối của chuỗi s3
		
		String s4 = s.substring(6); 
		// Tạo chuỗi con s4 từ chuỗi s từ vị trí số 6 
		System.out.println("s9="+s4);
	}
}
