package topica.edu.vn._02_mang;

import java.util.Arrays;

public class _2_DemoMang {

	public static void main(String[] args) {
		int M[] = new int[4];
		M[0]=7;
		M[1]=0;
		M[2]=3;
		M[3]=9;
		System.out.println("Mảng của bạn là:");
		for (int i = 0; i < M.length; i++) {
			System.out.print(M[i]+"\t");
		}
		
		Arrays.sort(M);
		System.out.println("\nMảng sau khi sắp xếp là:");
		for (int i = 0; i < M.length; i++) {
			System.out.print(M[i]+"\t");
		}
		
		System.out.println("\nCác số nguyên tố là:");
		for (int i = 0; i < M.length; i++) {
			int dem=0;
			for (int j = 1; j <= M[i]; j++) {
				if(M[i]%j==0){
					dem++;
				}
			}
			if(dem==2){
					System.out.print(M[i]+"\t");
			}
		}
	}

}
