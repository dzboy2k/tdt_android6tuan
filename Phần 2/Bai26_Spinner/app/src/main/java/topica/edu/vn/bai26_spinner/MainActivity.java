package topica.edu.vn.bai26_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import topica.edu.vn.model.NhanVien;

public class MainActivity extends AppCompatActivity {

    EditText txtTen, txtSoNgay;
    Button btnXacNhan;

    // Khai báo spinner
    Spinner spThu;
    ArrayList<String> dsThu;
    ArrayAdapter<String> adapterThu;

    // Khai báo biến lưu lại vị trí đang chọn
    int lastedSelected = -1; // =-1 : Chưa được chọn

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
                xuLyXacNhanCongTac();
            }
        });

        // Sự kiện chọn item của spinner
        spThu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // int i -> Vị trí của dòng đang chọn

                // Thông báo
                Toast.makeText(MainActivity.this, "Bạn chọn: "+dsThu.get(i),
                        Toast.LENGTH_LONG).show();
                // Đánh dấu vị trí vừa chọn
                lastedSelected = i;
            }

            // Chưa được chọn
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void xuLyXacNhanCongTac() {
        if(lastedSelected == -1) {
            Toast.makeText(MainActivity.this, "Nhà ngươi chưa chọn thứ mà xác nhận" +
                    "cái gì???", Toast.LENGTH_LONG).show();
            return;
        }
        // Khi chọn thành công
        NhanVien nv = new NhanVien();
        nv.setTenNhanVien(txtTen.getText().toString());
        nv.setThuBatDauCongTac(dsThu.get(lastedSelected));
        nv.setSoNgayCongTacDuKien(Integer.parseInt(txtSoNgay.getText().toString()));

        Toast.makeText(MainActivity.this, nv.toString(), Toast.LENGTH_LONG).show();
    }

    private void addControls() {
        txtTen = findViewById(R.id.txtTen);
        txtSoNgay = findViewById(R.id.txtSoNgay);
        btnXacNhan = findViewById(R.id.btnXacNhan);

        // Tạo spinner
        spThu = findViewById(R.id.spThu);
        // Tạo nguồn dữ liệu
        dsThu = new ArrayList<>();
        dsThu.add("Thứ 2");
        dsThu.add("Thứ 3");
        dsThu.add("Thứ 4");
        dsThu.add("Thứ 5");
        dsThu.add("Thứ 6");
        dsThu.add("Thứ 7");
        dsThu.add("Thứ 8");

        // Tạo adapter
        adapterThu = new ArrayAdapter<String>(
                MainActivity.this, // Màn hình hiện tại
                android.R.layout.simple_spinner_item, // Layout sử dụng
                dsThu // Nguồn dữ liệu
                );

        // Layout hiển thị danh sách dữ liệu
        adapterThu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Gán adapter
        spThu.setAdapter(adapterThu);
    }
}