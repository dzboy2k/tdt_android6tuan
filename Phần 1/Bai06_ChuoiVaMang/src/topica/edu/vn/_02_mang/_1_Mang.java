package topica.edu.vn._02_mang;

import java.util.Arrays;

public class _1_Mang {

	public static void main(String[] args) {
		// Khai báo mảng
		int[] a1;
		int a2[];
		
		// Khởi tạo vào cấp phát bộ nhớ cho mảng
		int a3[] = new int[5];
		int[] a4 = new int[5];
		
		int[] a5 = new int[]{2,10,4,8,5};
		int[] a6 = {2, 10, 4, 8, 5};
		
		System.out.println("Length a6="+a6.length); // Lấy chiều dài của mảng
		
		// Duyệt mảng
		System.out.println("Duyệt mảng:");
		for (int i = 0; i < a5.length; i++) {
			System.out.print(+a5[i]+"\t");
		}
		System.out.println();
		
		// Câc hàm thao tác với mảng
		int array[] = {2, 5, -2, 6, -3, 8, 0, 7, -9, 4};
		int array1[] = {2, 5, 6, -3, 8};
		
		// Sắp xếp mảng số nguyên theo thứ tự tăng dần
		Arrays.sort(array);
		System.out.println("\nArr1="+Arrays.toString(array));
		
		// So sánh 2 mảng số nguyên array1 và array
		array1.equals(array);
		System.out.println("\nArr2="+array1.equals(array));
		
		// Gán giá trị cho các phần tử trong mảng array1
		Arrays.fill(array1, 10);
		System.out.println("\nArr3="+Arrays.toString(array1));
		
		// Sao chép mảng array1 sang mảng array2
		int[] arr2 = Arrays.copyOf(array1, 6);
		System.out.println("\nArr4="+Arrays.toString(arr2));
	}

}
