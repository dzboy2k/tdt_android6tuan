package topica.edu.vn;

import java.util.ArrayList;

public class _1_ArrayList {

	public static void main(String[] args) {
		// Ctrl + Shift + /: Comment nhiều dòng
		/*ArrayList ds = new ArrayList(); // Khai báo ArrayList
		ds.add("x"); // Thêm phần tử vào danh sách
		ds.add(9+"");
		
		 Cấu hình JRE System Library:
		 * Bấm chuột phải vào projecr -> Build Path -> Configure Build Path
		 * -> Libraríes -> Chọn JRE -> Remove -> Add Library 
		 * -> JRE System Library -> Next -> Finish -> OK 
		 
		ArrayList ds2 = new ArrayList();
		ds2.add("1.5");*/
		
		ArrayList ds3 = new ArrayList();
		ds3.add("An");
		ds3.add("Bình");
		ds3.add("Giải");
		ds3.add("Thoát");
		ds3.add(2, "TÈO"); // Chèn mới 1 phần tử vào vị trí
		
		// Duyệt theo vị trí
		for (int i = 0; i < ds3.size(); i++) { // size(): sô lượng phần tử
			String x = ds3.get(i)+""; // Lấy phần tử từ danh sách tại vị trí
			System.out.println(x);
		}
		
		System.out.println("=====================");
		// Duyệt theo đối tượng
		for(Object data: ds3){
			System.out.println(data);
		}
		
		ArrayList<Double> ds4 = new ArrayList<Double>();
		for (int i = 0; i < 10; i++) {
			ds4.add(i*2.0);
		}
		System.out.println("Giá trị của ds4 là:");
		for (Double x : ds4) {
			System.out.println(x);
		}
		
		ArrayList<Float> ds5 = new ArrayList<Float>();
		ds5.add(1.5f);
		ds5.add(1.8f);
		System.out.println("Số phần tử của ds5="+ds5.size());
		ds5.add(113.114f);
		System.out.println("Số phần tử của ds5="+ds5.size());
		ds5.remove(1.5f); // Xóa phần tử
		System.out.println("Số phần tử của ds5="+ds5.size());
		
		System.out.println("Các phần tử trong ArrayList ds5:");
		for (Float x : ds5) {
			System.out.println(x);
		}
		ds5.set(0, 78.99f); // Sửa phần tử tại vị trí
		
		System.out.println("Các phần tử trong ArrayList ds5 sau khi sửa:");
		for (Float x : ds5) {
			System.out.println(x);
		}
	}

}
