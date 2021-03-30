package topica.edu.vn.model;

import java.io.Serializable;

public class DanhBa implements Serializable { // Serializable: Cho phép mã hóa đối tượng
    private int ma;
    private String ten;
    private String phone;

    // Tạo Constructor: Alt + Insert (Generate...) -> Constructor
    public DanhBa() {
    }

    public DanhBa(int ma, String ten, String phone) {
        this.ma = ma;
        this.ten = ten;
        this.phone = phone;
    }

    // Tạo Getter và Setter: Alt + Insert (Generate...) -> Getter and Setter
    // -> Ctrl + A -> OK
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
