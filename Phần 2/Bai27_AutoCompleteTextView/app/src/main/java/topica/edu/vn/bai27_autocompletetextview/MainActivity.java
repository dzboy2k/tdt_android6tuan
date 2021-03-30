package topica.edu.vn.bai27_autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtTen;

    // Khai báo AutoCompleteTextView
    AutoCompleteTextView autoTinhThanh;
    String []arrTinhThanh; // Nguồn dữ liệu
    ArrayAdapter<String> adapterTinhThanh;

    Button btnXacNhan;
    TextView txtThongTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXacNhanThongTin();
            }
        });
    }

    private void xuLyXacNhanThongTin() {
        String s = txtTen.getText().toString() + "\n" +
                autoTinhThanh.getText().toString();

        // Hiển thị thông tin
        txtThongTin.setText(s);
    }

    private void addControls() {
        txtTen = findViewById(R.id.txtTen);
        btnXacNhan = findViewById(R.id.btnXacNhan);
        txtThongTin = findViewById(R.id.txtThongTin);
        autoTinhThanh = findViewById(R.id.autoTinhThanh);

        // Lấy dữ liệu từ strings.xml
        arrTinhThanh = getResources().getStringArray(R.array.arrayTinhThanh);
        // Sử dụng adapter
        adapterTinhThanh = new ArrayAdapter<>(
                MainActivity.this, // Màn hình hiện tại
                android.R.layout.simple_list_item_1, // Layout sử dụng (Giao diện hiển thị lên)
                arrTinhThanh); // Nguồn dữ liệu
        autoTinhThanh.setAdapter(adapterTinhThanh); // Gán adapter vào AutoCompleteTextView
    }
}