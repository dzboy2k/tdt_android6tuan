package topica.edu.vn;

public class _5_StringBuilder {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < 100; i++) {
			builder.append("Phần tử thứ "+i); // Nối chuỗi
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}
}
