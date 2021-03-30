package topica.edu.vn.bai24_listviewcoban_dulieucodinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Khai báo nguồn cố định
    String []arrThu;

    // Tạo ArrayAdapter
    ArrayAdapter<String> adapterThu;

    // Khai báo ListView
    ListView lvThu;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        // Tạo sự kiện Click vào Item cho ListView
        lvThu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // int i -> Vị trí đang chọn trên giao diện

                // Thông báo
                Toast.makeText(MainActivity.this, "Bạn chọn [" + arrThu[i]
                + "]", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addControls() {
        // Lấy dữ liệu từ resources trong strings.xml
        arrThu = getResources().getStringArray(R.array.arrThu);

        // Tạo adapter và gán nguồn cho adapter
        adapterThu = new ArrayAdapter<String>(
                MainActivity.this, // Màn hình sử dụng Adapter
                android.R.layout.simple_expandable_list_item_1,
                // Giao diện vẽ từng dòng dữ liệu -> sử dụng hệ thống layout của android
                arrThu); // Nguồn dữ liệu gán cho adapter

        // Tạo listView
        lvThu = findViewById(R.id.lvThu);
        // Gán adapter cho ListView
        lvThu.setAdapter(adapterThu);

    }
}