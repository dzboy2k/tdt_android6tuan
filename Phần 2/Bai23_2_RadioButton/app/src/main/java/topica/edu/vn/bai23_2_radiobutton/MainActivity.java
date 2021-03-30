package topica.edu.vn.bai23_2_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton radRatTuyetVoi, radTuyetVoi, radTamChapNhan, radKhongTotLam;
    Button btnBinhChon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    // Gán sự kiện
    private void addEvents() {
        btnBinhChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyBinhChon();
            }
        });
    }

    private void xuLyBinhChon() {
        String s = "";
        if(radRatTuyetVoi.isChecked()){
            s = radRatTuyetVoi.getText().toString();
        }
        else if(radTuyetVoi.isChecked()){
            s = radTuyetVoi.getText().toString();
        }
        else if(radTamChapNhan.isChecked()){
            s = radTamChapNhan.getText().toString();
        }
        else if(radKhongTotLam.isChecked()){
            s = radKhongTotLam.getText().toString();
        }
        // Thông báo
        Toast.makeText(MainActivity.this,"Bạn chọn: "+ s,Toast.LENGTH_LONG).show();
    }

    // Tạo control
    private void addControls() {
        radRatTuyetVoi = findViewById(R.id.radRatTuyetVoi);
        radTuyetVoi = findViewById(R.id.radTuyetVoi);
        radTamChapNhan = findViewById(R.id.radTamChapNhan);
        radKhongTotLam = findViewById(R.id.radKhongTotLam);
        btnBinhChon = findViewById(R.id.btnBinhChon);
    }
}