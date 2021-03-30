package topica.edu.vn._02_QLNV;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		ds.add(new NhanVien(5,"Tèo"));
		ds.add(new NhanVien(2,"An"));
		ds.add(new NhanVien(1,"Hồng"));
		ds.add(new NhanVien(4,"Bình"));
		ds.add(new NhanVien(3,"Tĩnh"));
		ds.add(new NhanVien(6,"An"));
		
		System.out.println("Danh sách nhân viên của công ty:");
		for (NhanVien nv : ds) {
			System.out.println(nv.getMa()+" "+nv.getTen());
		}
		
		Collections.sort(ds); // Sắp xếp đối tượng theo interface
		
		System.out.println("Danh sách nhân viên đã sort của công ty:");
		for (NhanVien nv : ds) {
			System.out.println(nv.getMa()+" "+nv.getTen());
		}
	}

}
