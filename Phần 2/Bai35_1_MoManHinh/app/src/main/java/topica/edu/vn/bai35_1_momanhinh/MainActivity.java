package topica.edu.vn.bai35_1_momanhinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyMo1ManHinh(View view) {
        // đối số 1: Là màn hình hiện tại gọi cái Intent này (tên Activity.this)
        // đối số 2: là màn hình bạn muốn mở lên (tên Activity.class)
        Intent i = new Intent(MainActivity.this, ManHinh2Activity.class);
        // Gửi lệnh tới Android system để mở màn hình
        startActivity(i);
    }
}