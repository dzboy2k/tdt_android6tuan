package topica.edu.vn._01_chuoi;

public class _3_Demo_ToiUuString {

	public static void main(String[] args) {
		String s = "    Nguyễn       Văn    Tèo   ";
		System.out.println(s);
		// s = "Nguyễn Văn Tèo"
		s=s.trim(); // Xóa khoảng trắng dư thừa bên trái và bên phải
		String []arr = s.split(" "); // Tách chuỗi dựa vào khoảng trắng
		String sToiUu = "";
		for (String tu : arr) {
			if(tu.trim().length()!=0)
				sToiUu += tu+" ";;
		}
		System.out.println(sToiUu);
	}

}
