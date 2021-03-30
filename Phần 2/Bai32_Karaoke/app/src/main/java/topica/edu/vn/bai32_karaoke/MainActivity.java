package topica.edu.vn.bai32_karaoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

import topica.edu.vn.adapter.MusicAdapter;
import topica.edu.vn.model.Music;

public class MainActivity extends AppCompatActivity {

    ListView lvBaiHatGoc;
    ArrayList<Music> dsBaiHatGoc;
    MusicAdapter adapterBaiHatGoc;

    ListView lvBaiHatYeuThich;
    ArrayList<Music> dsBaiHatYeuThich;
    MusicAdapter adapterBaiHatYeuThich;

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        // Sự kiện lắng nghe đang nhấn trên tab nào (0, 1,..)
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) { // tabId = tên tapSpec
                if(tabId.equalsIgnoreCase("t1")){
                    xuLyHienThiBaiHatGoc();
                }
                else if(tabId.equalsIgnoreCase("t2")){
                    xuLyHienThiBaiHatYeuThich();
                }
            }
        });
    }

    private void xuLyHienThiBaiHatGoc() {

    }

    private void xuLyHienThiBaiHatYeuThich() {
        dsBaiHatYeuThich.clear(); // Xoá dữ liệu gốc của arrayList
        for (Music music:dsBaiHatGoc){
            if(music.isThich()){
                dsBaiHatYeuThich.add(music);
            }
        }
        adapterBaiHatYeuThich.notifyDataSetChanged(); // Cập nhật dữ liệu lên giao diện
    }

    private void addControls() {
        // Sử dụng TabHost
        tabHost = findViewById(R.id.TabHost);
        tabHost.setup(); // Tạo tabHost (đựng các tab nhỏ) sử dụng trên giao diện

        // Tạo từng tab nhỏ
        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1"); // t1 = id của tab
        tab1.setContent(R.id.tab1); // Nội dung của tab
        tab1.setIndicator("", getResources().getDrawable(R.drawable.music)); // Tên tab
        tabHost.addTab(tab1); // Thêm tab

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2"); // t2 = id của tab
        tab2.setContent(R.id.tab2); // Nội dung của tab
        tab2.setIndicator("", getResources().getDrawable(R.drawable.musicfavorite));// Tên tab
        tabHost.addTab(tab2); // Thêm tab

        // Sử dụng ListView
        lvBaiHatGoc = findViewById(R.id.lvBaiHatGoc);
        dsBaiHatGoc = new ArrayList<>();
        adapterBaiHatGoc = new MusicAdapter(
                MainActivity.this,
                R.layout.item,
                dsBaiHatGoc
        );
        lvBaiHatGoc.setAdapter(adapterBaiHatGoc);

        lvBaiHatYeuThich = findViewById(R.id.lvBaiHatYeuThich);
        dsBaiHatYeuThich = new ArrayList<>();
        adapterBaiHatYeuThich = new MusicAdapter(
                MainActivity.this,
                R.layout.item,
                dsBaiHatYeuThich
        );
        lvBaiHatYeuThich.setAdapter(adapterBaiHatYeuThich);
        giaLapBaiHat();
    }

    // Tạo danh sách bài hát
    private void giaLapBaiHat() {
        dsBaiHatGoc.add(new Music("55555", "Không yêu đừng nói lời cay đắng", "Ngọt ngào"
                , false));
        dsBaiHatGoc.add(new Music("33333", "Lòng mẹ", "Ngọc Sơn", true));
        dsBaiHatGoc.add(new Music("12345", "Riêng một góc trời", "Tuấn Ngọc", false));
        dsBaiHatGoc.add(new Music("67890", "Ly cà phê ban mê", "Siu black", false));
        adapterBaiHatGoc.notifyDataSetChanged(); // Thay đổi thông tin hiển thị trên giao diện
    }
}