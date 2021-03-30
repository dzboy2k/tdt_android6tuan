package topica.edu.vn.bai28_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import topica.edu.vn.adapter.HinhAdapter;

public class MainActivity extends AppCompatActivity {

    // Khai báo GridView
    GridView gvHinh;
    ArrayList<Integer> dsHinh; // Nguồn dữ liệu
    HinhAdapter adapter; // adapter

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
        gvHinh = findViewById(R.id.gvHinh);

        // Đưa thông tin vào danh sách hình
        dsHinh = new ArrayList<>();
        dsHinh.add(R.drawable.h1);
        dsHinh.add(R.drawable.h2);
        dsHinh.add(R.drawable.h3);
        dsHinh.add(R.drawable.h4);
        dsHinh.add(R.drawable.h5);
        dsHinh.add(R.drawable.h6);
        dsHinh.add(R.drawable.h7);
        dsHinh.add(R.drawable.h8);
        dsHinh.add(R.drawable.h9);
        dsHinh.add(R.drawable.h10);
        dsHinh.add(R.drawable.h11);

        // Tạo adapter
        adapter = new HinhAdapter(MainActivity.this, R.layout.item, dsHinh);
        gvHinh.setAdapter(adapter);
    }
}