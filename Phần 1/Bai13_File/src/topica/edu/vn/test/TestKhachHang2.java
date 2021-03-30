package topica.edu.vn.test;

import java.util.ArrayList;

import topica.edu.vn.io.SerializeFile;
import topica.edu.vn.model.KhachHang2;

public class TestKhachHang2 {
	public static void testLuuFile() {
		ArrayList<KhachHang2> dsKH = new ArrayList<KhachHang2>();
		dsKH.add(new KhachHang2("KH01","Nguyễn Thị An"));
		dsKH.add(new KhachHang2("KH02","Trần Văn Bình"));
		dsKH.add(new KhachHang2("KH03","Hồ Thị Giải"));
		dsKH.add(new KhachHang2("KH04","Hoàng Ngọc Thoát"));
		
		boolean kt = SerializeFile.luuFile(dsKH, "D:\\dulieu2.txt");
		if(kt==true){
			System.out.println("Đã lưu file thành công");
		}
		else{
			System.out.println("Lưu file thất bại");
		}
	}
	public static void main(String[] args) {
		testLuuFile();
		ArrayList<KhachHang2> dsKH = SerializeFile.docFile("D:\\dulieu2.txt");
		System.out.println("Danh sách khách hàng nạp vào máy tính là:");
		System.out.println("Mã\tTên");
		for (KhachHang2 kh : dsKH) {
			System.out.println(kh);
		}
	}
}
