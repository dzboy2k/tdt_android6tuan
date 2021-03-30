package topica.edu.vn.bai37_mycontactaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtPhone;
    EditText txtTinNhan;
    Button btnQuaySo, btnGoiLuon, btnNhanTin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        // Quay số
        btnQuaySo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyQuaySo();
            }
        });

        // Gọi luôn
        btnGoiLuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyGoiLuon();
            }
        });

        // Nhắn tin
        btnNhanTin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNhanTinVaQuanLyKetQua();
            }
        });
    }

    private void xuLyNhanTinVaQuanLyKetQua() {
        /** Gửi tin nhắn không quan tâm kết quả trả về (tin nhắn bình thường)
         *  final SmsManager sms = SmsManager.getDefault();
         *  // getDefault() -> Hàm lấy tin nhắn ra để sử dụng
         *
         * sendTextMessage -> Gửi tin nhắn
         *  sms.sendTextMessage("0987773061", null, "Hello teo teo!", null, null);
         *      + 0987773061 -> Số điện thoại
         *      + Hello teo teo! -> Nội dung tin nhắn
         */

        // Gửi tin nhắn quản lý kết quả trả về
        // Lấy mặc định SmsManager
        final SmsManager sms = SmsManager.getDefault();

        // Sử dụng intent ra lệnh cho Android System lấy lệnh gửi tin nhắn
        Intent msgSent = new Intent("ACTION_MSG_SENT");
        // Intent msgSent = new Intent(Intent.ACTION_SEND);

        // Khai báo PendingIntent để kiểm tra kết quả
        // PendingIntent : Intent delay, intent chờ khi nào xong mới kích hoạt
        final PendingIntent pendingMsgSent = PendingIntent.getBroadcast(this, 0,
                msgSent, 0);
        // Cấu hình tự dộng lắng nghe kết quả
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Đã gửi tin nhắn thành công";
                if(result != Activity.RESULT_OK) {
                    msg = "Gửi tin nhắn thất bại";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

            }
        }, new IntentFilter("ACTION_MSG_SENT"));
        // Gọi hàm gửi tin nhắn đi
        sms.sendTextMessage(txtPhone.getText().toString(), null,
                txtTinNhan.getText()+"", pendingMsgSent,null);
    }

    private void xuLyGoiLuon() {
        // Cú pháp lấy số điện thoại, không thay đổi "tel:"
        Uri uri = Uri.parse("tel:"+txtPhone.getText().toString());

        // Gọi Implicit Intent (Intent không tường minh) ACTION_CALL
        // ACTION_CALL -> Gọi điện thoại
        Intent intent = new Intent(Intent.ACTION_CALL);

        // Truyền giá trị kiểu uri (số điện thoại) vào intent
        // Intent intent = new Intent(Intent.ACTION_CALL, uri);
         intent.setData(uri);

        // Xử lý intent -> Đẩy cho Android System xử lý
        startActivity(intent);
    }

    private void xuLyQuaySo() {
        // Cú pháp lấy số điện thoại, không thay đổi "tel:"
        Uri uri = Uri.parse("tel:"+txtPhone.getText().toString());

        // Gọi Implicit Intent (Intent không tường minh) ACTION_DIAL
        // ACTION_DIAL (Hiển thị giao diện màn hình quay số)
        Intent intent = new Intent(Intent.ACTION_DIAL);

        // Truyền giá trị kiểu uri (số điện thoại) vào intent
        intent.setData(uri);

        // Xử lý intent -> Đẩy cho Android System xử lý
        startActivity(intent);
    }

    private void addControls() {
        txtPhone = findViewById(R.id.txtPhone);
        txtTinNhan = findViewById(R.id.txtTinNhan);
        btnGoiLuon = findViewById(R.id.btnGoiLuon);
        btnNhanTin = findViewById(R.id.btnNhanTin);
        btnQuaySo = findViewById(R.id.btnQuaySo);
    }
}