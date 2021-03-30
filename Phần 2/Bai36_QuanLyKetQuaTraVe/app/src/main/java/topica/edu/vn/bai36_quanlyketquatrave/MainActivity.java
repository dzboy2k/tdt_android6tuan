package topica.edu.vn.bai36_quanlyketquatrave;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB;
    Button btnXuLy;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXuLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLayUSCLN();
            }
        });
    }

    private void xuLyLayUSCLN() {
        Intent intent = new Intent(MainActivity.this, ManHinhXuLyActivity.class);
        // Gửi dữ liệu
        intent.putExtra("a", Integer.parseInt(txtA.getText().toString()));
        intent.putExtra("b", Integer.parseInt(txtB.getText().toString()));
        // Bước 1: Bạn phải gọi startActivityForResult
        startActivityForResult(intent, 99);
        // intent -> intent muốn gọi, 99 -> mã yêu cầu (bất kì, không trùng nhau)
    }

    // Bước 6: Nhận kết quả trong onActivityResult (chỉ nhận trong vòng đời Foreground lifetime)
    // onActivityResult là 1 hàm tự động lấy kết quả trả về từ một màn hình khác (foreground lifetime)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // requestCode -> mã yêu cầu gửi đi
        // resultCode -> mã kết quả trả về
        // data -> kết quả trả về

        if(requestCode == 99 && resultCode == 33) {
            int uscln = data.getIntExtra("USCLN",1);
            txtKetQua.setText("USCLN = " + uscln);
        }
    }

    private void addControls() {
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        btnXuLy = findViewById(R.id.btnXuLy);
        txtKetQua = findViewById(R.id.txtKetQua);
    }
}