package topica.edu.vn.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import topica.edu.vn.model.KhachHang;

/* Cơ sở dữ liệu là gì?
 * Dữ liệu text(chuỗi) cũng được coi là Cơ sở dữ liệu, miễn là
 * chuỗi này có cấu trúc (tức là có quy luật) -> Đọc hiểu và phân
 * tích bằng phần mềm được.
 */

public class TextFileFactory {
	public static boolean LuuFile(ArrayList<KhachHang> dsKH,String path)
	{
		try {
			// Tạo file lưu trong ổ cứng, path: đường dẫn
			FileOutputStream fos = new FileOutputStream(path); 
			// Xuất file với định dạng utf-8
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			// Đưa dữ liệu vào bộ đệm để lưu
			BufferedWriter bw = new BufferedWriter(osw);
			for (KhachHang kh : dsKH) {
				String line = kh.getMa() +";"+ kh.getTen();
				// Đưa dữ liệu xuống ổ cứng, ghi một dòng
				bw.write(line);
				// Xuống dòng kế tiếp
				bw.newLine();
			}
			
			// Đóng file, thiếu lệnh này dữ liệu bằng rỗng
			bw.close();
			osw.close();
			fos.close();
			return true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<KhachHang> docFile(String path)
	{
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		
		try 
		{	
			// Tìm file trong ổ cứng, path: dường dẫn
			FileInputStream fis = new FileInputStream(path);
			// Đọc File với định dạng utf-8
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			// Đọc dữ liệu từ file
			BufferedReader br = new BufferedReader(isr);
			
			String line = br.readLine(); // Đọc dòng đầu tiên
			while (line != null) {
				String []arr = line.split(";"); // Tách chuỗi
				if(arr.length==2){
					KhachHang kh = new KhachHang(arr[0], arr[1]);
					dsKH.add(kh);
				}
				line = br.readLine(); // Di chuyển tới dòng kế tiếp
			}
			
			// Đóng file
			br.close();
			isr.close();
			fis.close();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}	
		return dsKH;
	}
}
