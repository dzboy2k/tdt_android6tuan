package topica.edu.vn;

public class MyThread2 implements Runnable{ 
	// Chia sẻ giá trị của các biến qua lại giữa các tiểu trình

	private int x = 0;
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()+" i = "+i+"\n\tx="+x);
			x++;
		}
	}
	public int getX(){
		return this.x;
	}
}
