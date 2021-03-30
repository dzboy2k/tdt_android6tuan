package topica.edu.vn;

public class _2_MainTamGiac {

	public static void main(String[] args) {
		_2_TamGiac tg1 = new _2_TamGiac(4, 5, 6);
		System.out.println(tg1);
		
		_2_TamGiac tg2 = new _2_TamGiac(1, 2, 3);
		System.out.println(tg2);
		
		System.out.println("Diện tích tam giác 1 = "+tg1.dienTich());
		System.out.println("Diện tích tam giác 2 = "+tg2.dienTich());
	}

}
