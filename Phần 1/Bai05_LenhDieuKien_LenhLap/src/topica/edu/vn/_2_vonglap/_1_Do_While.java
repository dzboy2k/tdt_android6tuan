package topica.edu.vn._2_vonglap;

public class _1_Do_While {

	public static void main(String[] args) {
		/*
		 * break: Thoát vòng lặp 
		 * continue: kết thúc sớm 1 vòng lặp
		 */
		int n=1, i=1;
		do {
			n*=i;
			i++;
		} while (i<=5);
		System.out.println("5! = "+n);
	}

}
