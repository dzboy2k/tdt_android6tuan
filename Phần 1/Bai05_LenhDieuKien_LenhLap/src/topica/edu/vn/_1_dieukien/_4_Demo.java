package topica.edu.vn._1_dieukien;

import java.util.Scanner;

public class _4_Demo { // Ctrl + i : Sửa lỗi thụt lề, làm đẹp code
	public static void main(String[] args) {
		int thang;
		Scanner sc = new Scanner(System.in); // Nhập dữ liệu từ bàn phím
		System.out.println("Mời bạn nhập tháng: ");
		thang = sc.nextInt();
		switch (thang) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				System.out.println("Tháng "+thang+" có 31 ngày.");
				break; // Thoát lệnh switch
			case 4: case 6: case 9: case 11:
				System.out.println("Tháng "+thang+" có 30 ngày.");
				break;
			case 2:
				System.out.println("Nếu nhuần thì tháng 2 có 29, ngược lại 28");
				break;
			default:
				System.out.println("Bạn nhập lụi rồi!");
				break;
		}
	}
}
