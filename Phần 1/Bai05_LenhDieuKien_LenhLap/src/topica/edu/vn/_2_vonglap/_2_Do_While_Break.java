package topica.edu.vn._2_vonglap;

public class _2_Do_While_Break {
	public static void main(String[] args) {
		int n=1, i=1;
		do {
			n*=i;
			i++;
			if(i>5)
				break;
		} while (true);
		System.out.println("5! = "+n);
	}
}
