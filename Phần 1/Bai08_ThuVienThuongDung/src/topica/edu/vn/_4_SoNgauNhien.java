package topica.edu.vn;

import java.util.Random;

public class _4_SoNgauNhien {
	public static void main(String[] args) {
		int []M=new int[10];
		Random rd=new Random();
		for (int i = 0; i < M.length; i++) {
			M[i]=-50+rd.nextInt(100); // Lấy giá trị ngẫu nhiên từ 0->99
		}
		for (int i = 0; i < M.length; i++) {
			System.out.print(M[i]+"\t");
		}
		/* [-50...50]
		 * int x=-50 + rd.nextInt(101)
		 */
	}
}
