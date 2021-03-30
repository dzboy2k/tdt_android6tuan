package topica.edu.vn.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    // Serializable -> Chuyển dữ liệu qua lại giữa các màn hình cụ thể là các đối tượng

    private int ma;
    private String ten;

    public SinhVien() {
    }

    public SinhVien(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return this.ma + "\n" + this.ten;
    }
}
