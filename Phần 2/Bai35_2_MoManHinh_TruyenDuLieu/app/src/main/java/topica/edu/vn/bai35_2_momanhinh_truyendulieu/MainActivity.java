package topica.edu.vn.bai35_2_momanhinh_truyendulieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import topica.edu.vn.model.SinhVien;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMoVaGuiDuLieu(View view) {
        Intent intent = new Intent(MainActivity.this, ManHinh2Activity.class);

        // Đưa dữ liệu vào intent
        intent.putExtra("KIEU_BOOLEAN", true);
        // KIEU_BOOLEAN -> Tên biến, true -> giá trị
        intent.putExtra("KIEU_CHAR", 'x');
        intent.putExtra("KIEU_INT", 100);
        intent.putExtra("KIEU_DOUBLE", 15.99);
        intent.putExtra("KIEU_CHUOI", "Topica Edumall"); // Không phải primary data

        // Đưa đối tường vào intent
        SinhVien topica = new SinhVien(1, "Topica Excellent!");
        intent.putExtra("SINHVIEN", topica);

        startActivity(intent);
    }
}