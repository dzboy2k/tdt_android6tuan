package topica.edu.vn.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import topica.edu.vn.model.KhachHang;

public class SerializeFileFactory {
	public static boolean luuFile(ArrayList<KhachHang> dsKH, String path)
	{
		try {
			// Láy đường dẫn để lưu file
			FileOutputStream fos = new FileOutputStream(path);
			// Cho phép ghi hình nguyên đối tượng
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// Ghi đối tượng
			oos.writeObject(dsKH);
			// Đóng file
			oos.close();
			fos.close();
			return true;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	public static ArrayList<KhachHang> docFile (String path){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		
		try {
			// Tìm đường dẫn của file
			FileInputStream fis = new FileInputStream(path);
			// Cho phép đọc đối tượng
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Dọc file
			Object data = ois.readObject();
			// Ép kiểu về ArrayList
			dsKH = (ArrayList<KhachHang>) data; // Ctrl + 1: gỡ lỗi 
			// Đóng file
			ois.close();
			fis.close();
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return dsKH;
	}
}
