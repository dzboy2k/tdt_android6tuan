package topica.edu.vn.bai29_dateanddatetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    TextView txtDate, txtTime;
    ImageButton btnDate, btnTime;
    // Calendar -> Thư viện ngày tháng năm
    Calendar calendar = Calendar.getInstance(); // Trả về ngày tháng năm hiện tại

    // SimpleDateFormat -> Thư viện hiển thị ngày tháng năm
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày-tháng-năm
    SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm"); // Định dạng giờ - phút

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyHienThiDatePicker();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyHienThiTimePicker();
            }
        });
    }

    private void xuLyHienThiTimePicker() {
        // Lắng nghe sự thay đổi giờ phút trên giao diện
        TimePickerDialog.OnTimeSetListener callBack = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                calendar.set(Calendar.HOUR_OF_DAY, i);
                calendar.set(Calendar.MINUTE, i1);
                txtTime.setText(sdf2.format(calendar.getTime()));
            }
        };

        // Ctrl + Click "TimePickerDialog" -> Xem Constructor
        // Khai báo TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                MainActivity.this, // Màn hình sử dụng
                callBack, // Lắng nghe sự thay đổi
                calendar.get(Calendar.HOUR_OF_DAY), // Giờ
                calendar.get(Calendar.MINUTE), // Phút
                true
        );
        // Hiển thị cửa sổ TimePicker
        timePickerDialog.show();
    }

    private void xuLyHienThiDatePicker() {
        // Lắng nghe sự thay đổi ngày tháng năm trên giao diện
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i); // Thay đổi năm
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);
                txtDate.setText(sdf1.format(calendar.getTime())); // Hiển thị thời gian
            }
        };

        // Khai báo DatePicker (Ctrl + Click vào DatePickerDialog -> Xem Constructor)
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this, // Màn hình sử dụng
                callBack, // Sự kiện lắng nghe sự thay đổi
                calendar.get(Calendar.YEAR), // Năm
                calendar.get(Calendar.MONTH), // Tháng
                calendar.get(Calendar.DAY_OF_MONTH)); // Ngày
        datePickerDialog.show(); // Hiển thị cửa sổ DatePickerDialog
    }

    private void addControls() {
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
        btnDate = findViewById(R.id.btnDate);
        btnTime = findViewById(R.id.btnTime);

        calendar = Calendar.getInstance();
        txtDate.setText(sdf1.format(calendar.getTime())); // Trả về thời gian đã định dạng
        txtTime.setText(sdf2.format(calendar.getTime()));
    }
}