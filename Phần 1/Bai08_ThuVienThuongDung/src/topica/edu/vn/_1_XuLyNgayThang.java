package topica.edu.vn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class _1_XuLyNgayThang {
	public static void main(String[] args) {
		/* Chỉnh giao diện Eclipse về mặc định:
		 * 1. Window -> Open Perspective -> Other -> Java
		 * 2. Window -> Reset Perspective -> Yes
		 */
		Calendar cal = Calendar.getInstance(); // Lấy ngày tháng năm hiện tại
		int nam = cal.get(Calendar.YEAR); // Lấy năm
		System.out.println("Năm nay là: "+nam);
		int thang = cal.get(Calendar.MONTH); // Tháng chạy từ 0-11
		System.out.println("Hôm nay là tháng: "+(thang+1));
		int ngay = cal.get(Calendar.DAY_OF_MONTH); // Lấy ngày
		System.out.println("Hôm nay là ngày: "+ngay);
		
		// Hiển thị ngày-tháng-năm
		Date t = cal.getTime(); // Trả về thông tin thời gian hiện tại
		// 26/02/2016
		// Định dạng ngày tháng năm
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		// d(day): đại diện cho ngày
		// M(month) : đại diện cho tháng
		// y: đại diện cho năm
		
		// Hiển thị định dạng ngày - tháng - năm theo sdf
		System.out.println("Hôm nay: "+sdf.format(t)); 
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("d/M/yyyy");
		System.out.println("Hôm nay: "+sdf2.format(t)); 
		
		// Hiển thị thời gian
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		// HH: định dạng 12 giờ
		System.out.println("Hôm nay: "+sdf3.format(t));
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("hh:mm:ss aaa"); 
		// hh: định dạng 12 giờ, aaa: định dạng AM, PM
		System.out.println("Hôm nay: "+sdf4.format(t));
	}
}
