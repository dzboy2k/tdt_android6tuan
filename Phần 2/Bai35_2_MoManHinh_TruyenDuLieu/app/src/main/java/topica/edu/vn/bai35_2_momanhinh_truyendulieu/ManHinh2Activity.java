package topica.edu.vn.bai35_2_momanhinh_truyendulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import topica.edu.vn.model.SinhVien;

public class ManHinh2Activity extends AppCompatActivity {
    
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        
        addControls();
    }

    private void addControls() {
        txtKetQua = findViewById(R.id.txtKetQua);
        // Lấy intent gửi qua từ MainActivity
        Intent intent = getIntent(); // Trả về intent mở màn hình này

        // Lấy dữ liệu từ intent
        Boolean kieuBoolean = intent.getBooleanExtra("KIEU_BOOLEAN", false);
        // KIEU_BOOLEAN -> Tên biến trùng với tên biến intent được gửi qua,
        // false -> giá trị mặc định sẽ được gán khi biến không được tìm thấy
        char kieuChar = intent.getCharExtra("KIEU_CHAR", 'w');
        int kieuInt = intent.getIntExtra("KIEU_INT", 0);
        double kieuDouble = intent.getDoubleExtra("KIEU_DOUBLE", 0.0);
        String kieuChuoi = intent.getStringExtra("KIEU_CHUOI");

        // Lấy đối tượng từ intent
        SinhVien sv = (SinhVien) intent.getSerializableExtra("SINHVIEN");

        txtKetQua.setText(
                "Kiểu boolean = " + kieuBoolean + "\n" +
                "Kiểu char = " + kieuChar + "\n" +
                "Kiểu int = " + kieuInt + "\n" +
                "Kiểu Double = " + kieuDouble + "\n" +
                "Kiểu chuỗi = " + kieuChuoi + "\n" +
                "Kiểu đối tượng = " + sv
                );
    }
}