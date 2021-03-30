package topica.edu.vn.bai23_1_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox chkAndroid, chkWindowsPhone, chkIOS;
    Button btnChon;
    TextView txtMonHoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Hàm load giao diện
        
        addControls(); // alt + enter
        addEvents();
    }

    // Hàm gán sự kiện
    private void addEvents() {
        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyChonMonHoc(); // Alt + Enter + MainActivity
            }
        });
    }

    private void xuLyChonMonHoc() {
        String s = "";
        if (chkAndroid.isChecked()) {
            s += chkAndroid.getText().toString() + "\n";
            // getText(): lấy dữ liệu, toString: chuyển về chuỗi
        }
        if (chkWindowsPhone.isChecked()) {
            s += chkWindowsPhone.getText().toString() + "\n";
        }
        if (chkIOS.isChecked()) {
            s += chkIOS.getText().toString();
        }
        txtMonHoc.setText(s);
    }

    // Hàm tạo Control
    private void addControls() {
        chkAndroid = findViewById(R.id.chkAndroid);
        chkWindowsPhone = findViewById(R.id.chkWindowsPhone);
        chkIOS = findViewById(R.id.chkIOS);
        btnChon = findViewById(R.id.btnChon);
        txtMonHoc = findViewById(R.id.txtMonHoc);
    }
}