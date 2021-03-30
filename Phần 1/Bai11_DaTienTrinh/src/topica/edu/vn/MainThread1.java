package topica.edu.vn;

public class MainThread1 {
	public static void main(String[] args) {
		MyThread1 th1 = new MyThread1();
		th1.setName("Tiến trình 1");
		th1.start(); // Kích hoạt tiến trình (tiểu trình)
		
		MyThread1 th2 = new MyThread1();
		th2.setName("Tiến trính 2");
		th2.start();
	}
}
