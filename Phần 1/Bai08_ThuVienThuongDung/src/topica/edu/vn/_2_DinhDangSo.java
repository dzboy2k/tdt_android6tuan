package topica.edu.vn;

import java.text.DecimalFormat;

public class _2_DinhDangSo {

	public static void main(String[] args) {
		double toan = 5;
		double ly = 6;
		double hoa = 9;
		double dtb = (toan+ly+hoa)/3;
		System.out.println("Điểm trung bình = "+dtb);
		
		DecimalFormat dcf = new DecimalFormat("#.##"); //Định dạng số
		System.out.println("Điểm trung bình = "+dcf.format(dtb));
	}

}
