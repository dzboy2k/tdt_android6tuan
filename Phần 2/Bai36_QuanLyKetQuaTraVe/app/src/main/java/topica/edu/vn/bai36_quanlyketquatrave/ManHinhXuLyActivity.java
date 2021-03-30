package topica.edu.vn.bai36_quanlyketquatrave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManHinhXuLyActivity extends AppCompatActivity {

    TextView txtNhan;
    Button btnTinhUSCLN;
    Intent intent;
    int a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_xu_ly);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnTinhUSCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyTinhUSCLN();
            }
        });
    }

    private void xuLyTinhUSCLN() {
        int min = Math.min(a,b); // Lấy số nhỏ nhất
        int uscln=1;
        for (int i=min; i>=1; i--) {
            if(a%i==0 && b%i==0) {
                uscln=i;
                break;
            }
        }
        // Bước 3: Thay đổi thông tin và gán vào trong intent
        // nên sử dụng lại intent (không cần tạo mới)
        intent.putExtra("USCLN", uscln);

        // Bước 4: Đánh dấu kết quả trả về
        setResult(33, intent);
        // 33 -> Mã kết quả trả về (bất kì, không trùng nhau), intent -< intent đã gọi

        // Bước 5: Phải đống màn hình này lại
        // để màn hình MainActivity trở thành Foreground lifetime
        // vì nó chỉ nhận được kết quả trả về ở trong Foreground lifetime
        finish();
    }

    private void addControls() {
        txtNhan = findViewById(R.id.txtNhan);
        btnTinhUSCLN = findViewById(R.id.btnTinhUSCLN);
        // Bước 2 Lấy dữ liệu ra
        intent = getIntent();
        a = intent.getIntExtra("a", -1);
        b = intent.getIntExtra("b", -1);
        txtNhan.setText("a = " + a + "; b = "+b);
    }
}