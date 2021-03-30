package topica.edu.vn.bai39_1_assetsvasharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView txtFont;
    ListView lvFont;
    ArrayList<String> dsFont;
    ArrayAdapter<String> fontAdapter;

    // Đặt tên Shared Preferences, không đặt tên thì mặc định lấy tên MainActivity
    String tenLuuTru = "TrangThaiFont";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position -> Vị trí đang chọn
                xuLyFontChu(position);
            }
        });
    }

    private void xuLyFontChu(int position) {
        // Đổi phông chữ -> Typeface
        Typeface typeface = Typeface.createFromAsset(getAssets(),
                "font/" + dsFont.get(position));
        // createFromAsset -> Tạo từ thư mục Asset
        // getAssets() -> Lấy tài nguyên của Assets
        // "font" + dsFont.get(position) -> trỏ tới đường dẫn từ thư muc Assets

        txtFont.setTypeface(typeface);

        // Lưu phông trữ -> SharedPreferences (Lưu trạng thái)
        SharedPreferences preferences = getSharedPreferences(tenLuuTru, MODE_PRIVATE);
        // tenLuuTru -> Tên tập tin muốn đặt, là 1 file .xml được tự động tạo ra
        // MODE_PRIVATE -> Lưu trong hệ thống để xử lý, chi mình ứng dụng này được xài
        // getSharedPreferences không bao giờ trả về null -> Thấy tên tập tin thì đọc,
        // nếu tập tin chưa tồn tại thì tạo mới

        // Lưu dữ liệu xuống file
        SharedPreferences.Editor editor = preferences.edit();
        // Đánh dấu Lưu trữ trạng thái của font chữ
        editor.putString("FONTCHU", "font/" + dsFont.get(position));
        // Xác nhận lưu trữ xuống file .xml
        editor.commit();
    }

    private void addControls() {
        txtFont = findViewById(R.id.txtFont);
        lvFont = findViewById(R.id.lvFont);
        dsFont = new ArrayList<>();
        fontAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsFont);
        lvFont.setAdapter(fontAdapter);

        // Tương tác với dữ liệu của Assets
        try {
            // Lấy toàn bộ tài nguyên bên trong thư mục Assets
            AssetManager assetManager = getAssets();
            // Lấy danh sách tệp tin bên trong thư mục của Assets, "font" -> Tên thư mục
            String []arrFontName = assetManager.list("font");
            // Đưa danh sách dữ liệu đã lấy được từ Asset vào dsFont, đưa mảng -> collection
            dsFont.addAll(Arrays.asList(arrFontName));
            fontAdapter.notifyDataSetChanged();

            // Khởi tạo font chữ đã lưu
            SharedPreferences preferences = getSharedPreferences(tenLuuTru, MODE_PRIVATE);
            // Lấy trạng thái font chữ đã lưu, "" -> giá trị mặc định, chưa được chọn
            String font = preferences.getString("FONTCHU", "");
            // Lấy font chữ đã chọn khi khởi động ứng dụng
            if(font.length()>0)
            {
                Typeface typeface = Typeface.createFromAsset(getAssets(), font);
                txtFont.setTypeface(typeface);
            }

        } catch (Exception ex) {
            Log.e("LOI_FONT", ex.toString()); // Xuất thông báo lỗi
        }
    }
}