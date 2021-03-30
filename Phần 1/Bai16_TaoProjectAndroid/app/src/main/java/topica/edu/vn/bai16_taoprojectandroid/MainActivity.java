package topica.edu.vn.bai16_taoprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Gán giao diện để xử lý
        // R là lớp lưu trữ toàn bộ id của tất cả các thành phần trên giao diện được kéo thả
    }
}