package topica.edu.vn;

public class _3_Overloading {
	/* Overloading method - Nạp chồng hàm
	 * Trong cùng 1 lớp, có nhiều phương thức cùng tên 
	 * nhưng khác nhau về signature
	 * signature:
	 * 	+ 1. Số lượng các đối số khác nhau
	 * 	+ 2. Kiểu dữ liệu của các đối số khác nhau
	 * 	+ 3. Kiểu trả về không phải là signature
	 */
	
	public static int fn(int x, int y) {
		return x+y;
	}
	public static double fn(double x, double y) {
		return x+y+100;
	}
	
	public static int fn2(int x, int y, int z) {
		return x+y+z;
	}
	public static int fn2(int x) {
		return x;
	}
	
	// Ctrl + Shift + /: comment nhiều dòng
	/*public static int fn3(int x, int y) {
		return x+y;
	}
	public static double fn3(int x, int y) {
		return x+y;
	}*/
	
	// Parameter list
	public static int fn4(int ...arr) { // Truyền nhiều tham số
		int sum=0;
		for(int x: arr){
			sum+=x;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(fn(1,1));
		System.out.println(fn(1.0,1.0));
		System.out.println(fn2(1,2,3));
		System.out.println(fn2(1));
		
		System.out.println(fn4(1,2,3));
		System.out.println(fn4(1,2,3,4));
	}
}
