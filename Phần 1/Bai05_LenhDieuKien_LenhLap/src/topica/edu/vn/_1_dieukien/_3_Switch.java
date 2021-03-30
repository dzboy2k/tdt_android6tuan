package topica.edu.vn._1_dieukien;

import java.util.Scanner;

public class _3_Switch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("i = ");
		int i = Integer.parseInt(sc.nextLine());
		switch (i) {
		case 1:
			System.out.println("Số 1");
			break;
		case 2:
			System.out.println("Số 2");
			break;
		default:
			System.out.println("default");
			break;
		}
	}
}
