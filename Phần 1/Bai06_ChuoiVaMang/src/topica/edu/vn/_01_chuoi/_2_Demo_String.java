package topica.edu.vn._01_chuoi;

public class _2_Demo_String {
	public static void main(String[] args) {
		// Ctrl + D : Xóa 1 dòng
		String s = "5 Topica Education 3";
		System.out.println("Chiều dài của chuỗi = "+s.length());
		
		// Đếm xem chuỗi có bao nhiêu chữ In Hoa, in thường, số
		char []arr = s.toCharArray(); // Đổi chuỗi thành các mảng ký tự
		int soInHoa=0;
		int soInThuong=0;
		int soChuSo=0;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if(Character.isUpperCase(c)){ // Kiểm tra kí tự in hoa
				soInHoa++;
			}
			if(Character.isLowerCase(c)){ // Kiểm tra kí tự in thường
				soInThuong++;
			}
			if(Character.isDigit(c)){ // Kiểm tra số
				soChuSo++;
			}
		}
		System.out.println("Chuỗi có "+soInHoa+" ký tự hoa");
		System.out.println("Chuỗi có "+soInThuong+" ký tự thường");
		System.out.println("Chuỗi có "+soChuSo+" chữ số");
		
		String bh1 = "d:/music/nhactrinh/riengmotgoctroi.mp3";
		String bh2 = "d:\\music\\nhactrinh\\riengmotgoctroi.mp3";
		int vtcuoi=bh1.lastIndexOf("/");
		String tenBaiHat = bh1.substring(vtcuoi+1);
		System.out.println("Tên bài hát = "+tenBaiHat);
		
		int viTriCuoiDauCham = bh1.lastIndexOf(".");
		tenBaiHat = bh1.substring(vtcuoi+1, viTriCuoiDauCham); //
		System.out.println("Tên bài hát không có đuôi = "+tenBaiHat);
	}
}
