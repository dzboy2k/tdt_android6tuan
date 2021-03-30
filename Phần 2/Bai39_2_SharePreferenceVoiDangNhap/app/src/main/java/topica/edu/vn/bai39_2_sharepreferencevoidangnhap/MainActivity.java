package topica.edu.vn.bai39_2_sharepreferencevoidangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtUserName, txtPassword;
    CheckBox chkLuuThongTin;
    Button btnDangNhap, btnThoat;

    String tenThongTinDangNhap = "login";

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
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        chkLuuThongTin = findViewById(R.id.chkLuuThongTin);
        btnDangNhap = findViewById(R.id.btnDangNhap);
        btnThoat = findViewById(R.id.btnThoat);
    }

    // onPause() -> Tắt phần mềm -> lưu trạng thái
    @Override
    protected void onPause() {
        super.onPause();

        // Lưu thông tin đăng nhập
        SharedPreferences preferences = getSharedPreferences(tenThongTinDangNhap, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("UserName", txtUserName.getText().toString());
        editor.putString("PassWord", txtPassword.getText().toString());
        editor.putBoolean("SAVE", chkLuuThongTin.isChecked());
        // isChecked() -> Kiểm tra Checked có được tích hay không
        editor.commit(); // Xác nhận lưu thông tin
    }

    // onResume() -> Hiển thị phần mềm -> Phục hồi trạng thái
    @Override
    protected void onResume() {
        super.onResume();

        // Lấy thông tin đã lưu
        SharedPreferences preferences = getSharedPreferences(tenThongTinDangNhap, MODE_PRIVATE);
        String userName = preferences.getString("UserName", "");
        String passWord = preferences.getString("PassWord", "");
        Boolean save = preferences.getBoolean("SAVE", false);
        if(save) {
            txtUserName.setText(userName);
            txtPassword.setText(passWord);
        }
    }
}