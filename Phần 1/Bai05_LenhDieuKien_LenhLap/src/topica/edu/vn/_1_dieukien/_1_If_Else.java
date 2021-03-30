package topica.edu.vn._1_dieukien;

import java.util.Scanner;

public class _1_If_Else {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("i= ");
		int i = Integer.parseInt(sc.nextLine());
		if(i % 2==0){
			System.out.println("i là số chẵn");
		}
		else{
			System.out.println("i là số lẻ");
		}
		
		System.out.print("y= ");
		int y = Integer.parseInt(sc.nextLine());
		if((y%4==0 && y%100!=0) || y%400==0){
			System.out.println("y là năm nhuận");
		}
		else{
			System.out.println("y không là năm nhuận");
		}
	}
}
