package topica.edu.vn._01_KeThua;

public interface _09_DoAble { // Tập các phương thức mà các lớp con phải tuân thủ
	// Tất cả phương thức bắt buộc để public và mặc định interface là abtract
	public void fn1();
	public double fn2(double x, double y);
	public void xuatThongTin();
	
	public static int x = 5; // Chia sẻ ô nhớ, các lớp được chia sẻ dùng chung giá trị
	// final: khai báo hằng số
	public final double PI = 3.14; // Đảm bảo tính đóng gói vì không thay đổi được
}
