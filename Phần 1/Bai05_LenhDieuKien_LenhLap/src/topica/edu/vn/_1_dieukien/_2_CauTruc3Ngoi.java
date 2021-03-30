package topica.edu.vn._1_dieukien;

import java.util.Scanner;

public class _2_CauTruc3Ngoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("i = ");
		int i = Integer.parseInt(sc.nextLine());
		String a = (i%2 == 0)?"Số chẵn":"Số lẻ";
		System.out.println(a);
	}
}
