package topica.edu.vn.bai22_cackythuatxulysukien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    // Khai báo EditText
    EditText txtA, txtB;

    // Khai báo button
    Button btnTru;
    Button btnNhan, btnChia;
    Button btnAn;
    Button btnThoat;

    // Tạo biến sự kiện (variable as listener)
    View.OnClickListener suKienChiaSe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Chỉ khi nào chạy xong hàm setContentView thì lúc đó tất cả các control trên
        // giao diện mới được khởi tạo xong -> Viết lệnh sau setContentView

        addControls(); // alt + Enter: tự động tạo hàm
        addEvents();
    }

    // Hàm gán sự kiện
    private void addEvents() {
        // Tạo sự kiện anonymous
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyPhepTru();
            }
        });

        // Tạo sự kiện variable
        suKienChiaSe = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId()==R.id.btnNhan) { // view.getId() -> trả về id của control đang dùng sự kiện
                    xuLyPhepNhan(); // alt + enter + main activity
                }
                else if(view.getId()==R.id.btnChia) {
                    xuLyPhepChia();
                }
            }
        };
        // Gán sự kiện variable
        btnNhan.setOnClickListener(suKienChiaSe);
        btnChia.setOnClickListener(suKienChiaSe);

        // Gán sự kiện activity
        btnAn.setOnLongClickListener(this); // this -> Đối tượng hiện tại

        // Gán sự kiện explicit class
        btnThoat.setOnClickListener(new MyEvent());
    }

    private void xuLyPhepChia() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a / b;
        Toast.makeText(MainActivity.this, "Chia = "+c, Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepNhan() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a * b;
        Toast.makeText(MainActivity.this, "Nhân = "+c, Toast.LENGTH_LONG).show();
    }

    private void xuLyPhepTru() {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a - b;
        Toast.makeText(MainActivity.this, "Trừ = "+c, Toast.LENGTH_LONG).show();
    }

    // Hàm khởi tạo các controls
    private void addControls() {
        // Cộng
        txtA = (EditText) findViewById(R.id.txtA); // Lấy id, alt + enter: ép kiểu
        txtB = (EditText) findViewById(R.id.txtB);

        // Trừ
        btnTru = this.<Button> findViewById(R.id.btnTru);

        // Nhân
        btnNhan = this.<Button> findViewById(R.id.btnNhan);

        // Chia
        btnChia = this.<Button> findViewById(R.id.btnChia);

        // Ẩn
        btnAn = this.<Button> findViewById(R.id.btnAn);

        // Thoát
        btnThoat = this.<Button>findViewById(R.id.btnThoat);
    }

    public void xuLyPhepCong(View v)
    {
        int a = Integer.parseInt(txtA.getText().toString());
        // getText() -> Lấy dữ liệu, toString() -> Chuyển sang chuỗi, Integer.parseInt -> chuyển chuỗi thành số
        int b = Integer.parseInt(txtB.getText().toString());
        int c = a + b;

        // Thông báo, MainActivity.this -> Màn hình hiện tại, "Tổng = "+c -> nội dung thông báo
        // Toast.LENGTH_LONG -> Thời gian hiển thị: LENGTH_LONG (1.5s -> 3.5s), LENGTH_SHORT (<1.5s)
        // show() -> Hiển thị kết quả
        Toast.makeText(MainActivity.this, "Tổng = "+c, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId()==R.id.btnAn){
            btnAn.setVisibility(View.INVISIBLE); // Ẩn button
        }
        return false;
    }

    // Sử dụng Explicit class Listener
    public class MyEvent implements View.OnClickListener, View.OnLongClickListener {

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btnThoat) {
                finish(); // Đóng chương trình
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    // Sử dụng View Subclassing
    public void xuLyDoiManHinhKhac (View view) {
        // Tạo button
        Button btnMoi = new Button(MainActivity.this){
            @Override
            public boolean performClick() { // Sự kiện click cho view động
                setContentView(R.layout.activity_main);
                addControls();
                addEvents();

                return super.performClick();
            }
        };

        btnMoi.setText("Quay về");
        btnMoi.setWidth(200);
        btnMoi.setHeight(200);

        setContentView(btnMoi); // Đổi giao diện mới
    }
}