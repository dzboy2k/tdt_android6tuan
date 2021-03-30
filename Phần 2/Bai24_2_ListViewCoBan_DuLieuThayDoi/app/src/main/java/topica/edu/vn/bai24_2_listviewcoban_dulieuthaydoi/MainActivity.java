package topica.edu.vn.bai24_2_listviewcoban_dulieuthaydoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Khai báo nguồn dữ liệu thay đổi
    ArrayList<String> arrTen;

    // Khai báo ArrayAdapter
    ArrayAdapter<String> adapterTen;

    // Khai báo ListView
    ListView lvTen;

    EditText txtTen;
    Button btnLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyLuuDuLieu(); // Alt + Enter + MainActivity
            }
        });
    }

    private void xuLyLuuDuLieu() {
        String ten = txtTen.getText().toString();
        arrTen.add(ten); // Thêm dữ liệu mới
        adapterTen.notifyDataSetChanged(); // Ra lệnh cho ListView cập nhật lại giao diện
        txtTen.setText("");
        txtTen.requestFocus(); // Di chuyển con trỏ văn bản trỏ đến ô nhập
    }

    private void addControls() {
        arrTen = new ArrayList<String>();
        adapterTen = new ArrayAdapter<String>(
                MainActivity.this, // Màn hình sử dụng
                android.R.layout.simple_expandable_list_item_1, // dòng hiển thị dữ liệu lên giao diện
                arrTen // Nguồn đổ vào cho adapter
                );

        // Gán adapter cho ListView
        lvTen = findViewById(R.id.lvTen);
        lvTen.setAdapter(adapterTen);

        txtTen = findViewById(R.id.txtTen);
        btnLuu = findViewById(R.id.btnLuuDuLieu);
    }
}