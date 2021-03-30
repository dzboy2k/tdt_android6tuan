package topica.edu.vn.bai25_listviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import topica.edu.vn.adapter.DanhBaAdapter;
import topica.edu.vn.model.DanhBa;

public class MainActivity extends AppCompatActivity {

    ListView lvDanhBa;
    ArrayList<DanhBa> dsDanhBa; // Nguồn dữ liệu
    DanhBaAdapter danhBaAdapter; // Sử dụng lớp adapter đã được kế thừa ArrayAdapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
    }

    private void addControls() {
        // Tạo ListView
        lvDanhBa = findViewById(R.id.lvDanhBa);

        // Tạo nguồn dữ liệu
        dsDanhBa = new ArrayList<>();
        dsDanhBa.add(new DanhBa(1, "Nguyễn Văn Tèo","0981234567"));
        dsDanhBa.add(new DanhBa(2, "Trần Thị Tý","0951284566"));
        dsDanhBa.add(new DanhBa(3, "Hồ Văn Đồ","0911122333"));

        // Tạo adapter
        danhBaAdapter = new DanhBaAdapter(MainActivity.this, R.layout.item, dsDanhBa);
        // MainActivity.this -> Màn hình hiện tại
        // R.layout.item -> layout muốn hiển thị lên
        // dsDanhBa -> Nguồn dữ liệu
        lvDanhBa.setAdapter(danhBaAdapter);
    }
}