package topica.edu.vn.bai35_3_momanhinh_truyendulieu_bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import topica.edu.vn.model.SanPham;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMoVaGuiDuLieu(View view) {
        Intent intent = new Intent(MainActivity.this, ManHinh2Activity.class);

        // ĐÓng gói vào Bundle
        Bundle bundle = new Bundle();
        bundle.putInt("X",113); // Đưa dữ liệu primary data vào bundle
        bundle.putDouble("D",114.115);
        SanPham coca = new SanPham(1, "Coca co la la la", 1500.0);
        bundle.putSerializable("SANPHAM", coca);

        intent.putExtra("BUNDLE_CUA_TUI", bundle);
        startActivity(intent);
    }
}