package topica.edu.vn.bai33_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyCheKhuatToanBo(View view) { // Alt + Enter (activity_main.xml)
        // Mở màn hình
        Intent intent = new Intent(MainActivity.this, ManHinh2Activity.class);
        startActivity(intent);
    }

    // Generate... -> Overrides Methods... (trong các lớp cha con có các hàm giống nhau)
    // onStart() -> onResume(), khi bị che khuất: onPause(); -> onStop();
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume", Toast.LENGTH_LONG).show();
    }

    // Thứ tự các sự kiện xảy ra trong Activity
    // Khởi động lên: onstart -> onresume: bắt đầu vào foreground lifetime

    // Trường hợp 1: Nếu bị che khuất toàn bộ: -> onPause -> onStop
    // Sau khi bị che khuất toàn bộ và phuc hồi màn hình cũ: onRestart -> onstart -> onResume

    // Trường hợp 2: Nếu bị che khuất 1 phần: -> onPause
    // Sau khi bị che khuất 1 phần và phuc hồi màn hình cũ: -> onResume

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "onRestart", Toast.LENGTH_LONG).show();
    }

    public void xuLyCheKhuat1Phan(View view) {
        // Mở màn hình
        Intent intent = new Intent(MainActivity.this, ManHinh3Activity.class);
        startActivity(intent);
    }
}