package topica.edu.vn;

import java.util.StringTokenizer;

public class _6_StringTokenizer {
	public static void main(String[] args) {
		String s="học, học, học, học nữa,..., học mãi";
		StringTokenizer token = new StringTokenizer(s); // Tách chuỗi
		while (token.hasMoreTokens()) { // còn dữ liệu 
			System.out.println(token.nextToken()); // Lấy ra và di chuyển tới phần tử kế tiếp
		}
		System.out.println("======================");
		StringTokenizer token2 = new StringTokenizer(s,","); // Tách chuỗi theo dấu ,
		while (token2.hasMoreTokens()) { 
			System.out.println(token2.nextToken()); 
		}
		System.out.println("======================");
		StringTokenizer token3 = new StringTokenizer(s,", "); 
		while (token3.hasMoreTokens()) { 
			System.out.println(token3.nextToken()); 
		}
	}
}
