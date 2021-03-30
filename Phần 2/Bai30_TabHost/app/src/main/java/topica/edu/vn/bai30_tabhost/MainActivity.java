package topica.edu.vn.bai30_tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB;
    Button btnCong;

    ListView lvHistory;
    ArrayList<String> dsCong;
    ArrayAdapter<String> adapterCong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyPhepCong();
            }
        });
    }

    private void xuLyPhepCong() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        String s = a + "+" + b + "=" + (a+b);
        dsCong.add(s);
        adapterCong.notifyDataSetChanged(); // Cập nhật dữ liệu vào listView
        txtA.setText(""); // Xóa dữ liệu cũ
        txtB.setText("");
    }

    private void addControls() {
        // Lấy TabHost trên giao diện
        TabHost tabHost = findViewById(R.id.TabHost);
        // Gọi lệnh setup() -> Tạo tabHost
        tabHost.setup();

        // Tạo từng tab nhỏ ->TabSpec
        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1"); // t1: tên tab (id), không trùng nhau
        // tab1.setIndicator("1. Phép cộng"); // Tên tab hiển thị trên giao diện
        tab1.setIndicator("", getResources().getDrawable(R.drawable.hinh1)); // Tên tab sử dụng hình ảnh
        tab1.setContent(R.id.tab1); // Nội dung của tab
        tabHost.addTab(tab1); // Thêm vào tabHost

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        // tab2.setIndicator("2. Lịch sử");
        tab2.setIndicator("", getResources().getDrawable(R.drawable.hinh2));
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        btnCong = findViewById(R.id.btnCong);

        // Tạo ListView
        lvHistory = findViewById(R.id.lvHistory);
        dsCong = new ArrayList<>();
        adapterCong = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsCong);
        lvHistory.setAdapter(adapterCong);
    }
}