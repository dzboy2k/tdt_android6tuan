package topica.edu.vn.bai41_quanlydanhba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String DATABASE_NAME = "Bai41_dbContact.sqlite"; // Tên csdl
    String DB_PATH_SUFFIX = "/databases/"; // Thư mục lưu trữ csdl
    SQLiteDatabase database = null; // Lớp cho phép truy vẫn, tương tác csdl

    ListView lvDanhBa;
    ArrayList<String> dsDanhBa;
    ArrayAdapter adapterDanhBa;

    Button btnThemDanhBa, btnChinhSua, btnXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sao chép cơ sở dữ liệu
        xuLySaoChepCSDLTuAssetsVaoHeThongMobile();

        addControls();
        addEvents();

        // Truy vấn cơ sở dữ liệu
        showAllContactOnListView();
    }

    // Làm việc với cơ sở dữ liệu
    private void showAllContactOnListView() {
        // Bước 1: Mở CSDL trước
        database = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        // Mở cơ sở dữ liệu -> openOrCreateDatabase: trả về 1 csdl nếu như tồn tại, không tồn tại
        // thì tạo mới 1 csdl rỗng, không thể so sánh với null được

        // Truy vấn cơ sở dữ liệu -> query (theo cách riêng của Android)
        Cursor cursor = database.query("Contact", null, null,
                null, null, null, null);
        // Cursor -> Con trỏ quản lý bảng dữ liệu
        // => Cursor trỏ tới NULL (Chưa trỏ tới dòng dữ liệu nào cả trong bảng)

        // "Contact" -> Tên bảng

        // Truy vấn cơ sở dữ liệu -> rowQuery
        // Cursor cursor2 = database.rawQuery("select * from Contact", null);

        dsDanhBa.clear(); // Xóa dữ liệu cũ

        while (cursor.moveToNext()) {
            // moveToNext() -> di chuyển cursor tới dòng kế tiếp để đọc thông tin ra  -> Còn dữ liệu

            // Lấy thông tin ra
            int ma = cursor.getInt(0); // 0 -> Số thứ tự cột
            String ten = cursor.getString(1);
            String phone = cursor.getString(2);

            // Thêm dữ liệu vào arrayList
            dsDanhBa.add(ma+"-"+ten+"\n"+phone);
        }
        // Khi không còn di chuyển được nữa thì cursor.moveToNext() sẽ bằng false -> Ngừng vòng lặp

        cursor.close(); // Đóng kết nối
        adapterDanhBa.notifyDataSetChanged(); // Đẩy dữ liệu vào ListView
    }

    private void addEvents() {
        btnThemDanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThemDanhBa();
            }
        });
        btnChinhSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyChinhSuaDanhBa();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXoaDanhBa();
            }
        });
    }

    // Delete -> Xóa dữ liệu
    private void xuLyXoaDanhBa() {
        database.delete("Contact", "ma=?", new String[]{"2"});
        // "Contact" -> Tên bảng
        // ma=? -> Điều kiện
        // "2" -> Phần tử cho điều kiện
        showAllContactOnListView();
    }

    // Update - Thay đổi dữ liệu
    private void xuLyChinhSuaDanhBa() {
        // Tạo một dòng mới để update dữ liệu
        ContentValues row = new ContentValues();
        // Gán giá trị vào mỗi cột trong dòng vừa tạo
        row.put("Ten", "Hoàng Văn Huy");
        // Chỉnh sửa dòng đó trong cơ sở dữ liệu
        database.update("Contact", row, "ma=?", new String[]{"3"});
        // Contact -> Tên bảng, row -> Tên cột, ma=? -> Điều kiện,
        // new String[]{"3"} -> giá trị của điều kiện (số dấu "?" -> số giá trị)
        showAllContactOnListView();
        // Tất cả các dữ liệu trong SQLite có thể hiểu thành chuỗi
    }

    // Insert - Thêm dữ liệu
    private void xuLyThemDanhBa() {
        // Tạo một dòng mới để insert dữ liệu
        ContentValues row = new ContentValues();
        // Gán giá trị vào mỗi cột trong dòng vừa tạo
        row.put("Ma", 113); // "Ma" -> Tên cột, 113 -> dữ liệu
        row.put("Ten", "Trần Duy Thanh");
        row.put("Phone", "0987773061");
        // Thêm dòng đó vào cơ sở dữ liệu
        long r = database.insert("Contact", null, row); // trả về số dòng
        // "Contact" -> Tên bảng, row -> Tên dòng
        Toast.makeText(
                MainActivity.this,
                "Vừa thêm mới 1 Contact, kết quả trạng thái r = "+r,
                Toast.LENGTH_LONG).show();
        showAllContactOnListView();
    }

    private void addControls() {
        lvDanhBa = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                dsDanhBa);
        lvDanhBa.setAdapter(adapterDanhBa);

        btnThemDanhBa = findViewById(R.id.btnThemDanhBa);
        btnChinhSua = findViewById(R.id.btnChinhSua);
        btnXoa = findViewById(R.id.btnXoa);
    }

    // Xử lý sao chép cơ sở dữ liệu
    private void xuLySaoChepCSDLTuAssetsVaoHeThongMobile() {
        // Lấy file csdl
        File dbFile = getDatabasePath(DATABASE_NAME); // trả về đường dẫn chứa cơ sở dữ liệu
        if (!dbFile.exists()){ // Kiểm tra file chưa tồn tại
            // exists() -> Kiểm tra sự tồn tại của file
            try {
                CopyDataBaseFromAssets();
                Toast.makeText(this, "Sao chép CSDL vào hệ thống thành công",
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    // Sao chép cơ sở dũ liệu từ thư mục Assets
    private void CopyDataBaseFromAssets() {
        // Tương tác file ==> phải có try - catch
        try {
            // Đọc dữ liệu trong csdl từ thư mục assets
            InputStream myInput = getAssets().open(DATABASE_NAME);
            // getAssets() -> Lấy tài nguyên từ assets, open() -> Mở file

            // Lấy đường dẫn cần sao chép dữ liệu, nằm trong thư mục gốc
            String outFileName = layDuongDanLuuTru();

            // Tạo thư mục "databases" nếu chưa tồn tại
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            // Lấy đường dẫn của thư mục, getApplicationInfo().dataDir -> Lấy thư mục gốc
            if(!f.exists()){ // Kiểm tra thư mục chưa tồn tại
                f.mkdir(); // Tạo thư mục - tạo từ đường dẫn file
            }
            // Nếu không kiểm tra tồn tại thì lần chạy tiếp theo dữ liệu sẽ bị xóa

            // Tạo luồng xuất dữ liệu ra
            OutputStream myOutput = new FileOutputStream(outFileName);
            // Ghi dữ liệu, outFileName -> Đường dẫn;

            // Sao chép toàn bộ cơ sở dữ liệu từ Assets vào databases
            byte[] buffer = new byte[1024]; // Tạo mảng byte, 1024 Byte = 1MB
            int length; // Kiểm tra kích thước
            // Sao chép dữ liệu (Ghi vào file)
            while ((length = myInput.read(buffer)) > 0) {
                // myInput.read(buffer -> Mỗi lần đọc đủ 1024, sao chép các phần tử nhị phân vào buffer
                myOutput.write(buffer, 0, length); // Ghi dữ liệu vào myOuput
            }

            // Đóng file
            myOutput.flush(); // giải phóng dữ liệu còn lưu vào OutputStream tới điểm đích
            myOutput.close();
            myInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Lấy đường dẫn thư mục chứa database
    private String layDuongDanLuuTru(){
        // Lấy đường dẫn cần phải lưu trữ csdl vào
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;
        // getApplicationInfo().dataDir -> Trả về thư mục gốc cài đặt, cụ thể là thư mục
        // trỏ đến đúng package
    }

}