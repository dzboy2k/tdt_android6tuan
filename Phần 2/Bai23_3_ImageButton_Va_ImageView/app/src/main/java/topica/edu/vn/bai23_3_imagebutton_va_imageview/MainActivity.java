package topica.edu.vn.bai23_3_imagebutton_va_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton radHinhNha, radHinhNguoi;
    ImageView imgHinh;
    ImageButton btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        // Tự động lắng nghe sự kiện khi checked
        radHinhNguoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // Boolean b -> Xác định được đã checked hay chưa
                if(b){
                    // Lấy hình ảnh bên trong thư mục drawable
                    imgHinh.setImageResource(R.drawable.employee);
                }
            }
        });
        radHinhNha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    imgHinh.setImageResource(R.drawable.nhacuatui);
                }
            }
        });

        // Thoat chương trình khi click
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControls() {
        radHinhNguoi = findViewById(R.id.radHinhNguoi);
        radHinhNha = findViewById(R.id.radHinhNha);
        imgHinh = findViewById(R.id.imgHinh);
        btnThoat = findViewById(R.id.btnThoat);
    }
}