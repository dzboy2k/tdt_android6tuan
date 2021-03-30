package topica.edu.vn.bai35_3_momanhinh_truyendulieu_bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import topica.edu.vn.model.SanPham;

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

        // Lấy intent gọi nó
        Intent intent = getIntent();

        // Lấy bundle từ intent
        Bundle bundle = intent.getBundleExtra("BUNDLE_CUA_TUI");

        // Lấy dữ liệu đổi tượng trong bundle
        SanPham sp = (SanPham) bundle.getSerializable("SANPHAM");

        txtKetQua.setText(
                "X = " + bundle.getInt("X") + "\n" + // Lấy dữ liệu primary data trong bundle
                "D = " + bundle.getDouble("D") + "\n" +
                "SP = " + sp +"\n"
        );
    }
}