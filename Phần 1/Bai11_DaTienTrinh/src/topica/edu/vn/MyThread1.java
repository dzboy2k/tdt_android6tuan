package topica.edu.vn;

public class MyThread1 extends Thread{
	// Sources -> Overrides/Implement Methods... -> Thread -> Run() -> OK
	public void run() {
		super.run();
		
		for (int i = 0; i < 5; i++) {
			// Trả về tiến trình đang chạy
			System.out.println(Thread.currentThread().getName()+" i = "+i);
		}
	}
	
}
