package topica.edu.vn._2_vonglap;

public class _4_For {
	public static void main(String[] args) {
		int n=1;
		for (int i = 1; i <= 5; i++) {
			n*=i;
		}
		/* Bước 1: Khởi tạo i=1, n=1
		 * Bước 2: Kiểm tra i<=5 <-> 1<=5 -> Đúng 
		 * 		   	-> Làm n*=i <-> n=1*1=1
		 * Bước 3: i++ -> i=2 (i=i+1=1+1=2)
		 * Bước 4: Kiểm tra i<=5 <-> 2<=5 -> Đúng
		 * 		   	-> Làm n*=i <-> n=1*2=2
		 * Bước 5: i++ -> i=3 (i=i+1=2+1=3)
		 * Bước 6: Kiểm tra i<=5 <-> 3<=5 -> Đúng 
		 * 		   	-> Làm n*=i <-> n=2*3=6
		 * Bước 7: i++ -> i=4 (i=i+1=3+1=4)
		 * Bước 8: Kiểm tra i<=5 <-> 4<=5 -> Đúng 
		 * 		   	-> Làm n*=i <-> n=6*4=24
		 * Bước 9: i++ -> i=5 (i=i+1=4+1=5)
		 * Bước 10: Kiểm tra i<=5 <-> 5<=5 -> Đúng 
		 * 		   	-> Làm n*=i <-> n=24*5=120
		 * Bước 11: i++ -> i=6 (i=i+1=5+1=6)
		 * Bước 12: Kiểm tra i<=5 <-> 6<=5 -> Sai(vô lý thường kiệt)
		 * 			-> Thoát for
		 * Cuối cùng ta có 5!=120
		 */
		System.out.println("5! = "+n);
	}
}
