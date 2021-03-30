package topica.edu.vn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import topica.edu.vn.bai25_listviewnangcao.R;
import topica.edu.vn.model.DanhBa;

public class DanhBaAdapter extends ArrayAdapter<DanhBa> {

    // Đối số 1: màn hình sử dụng layout này (giao diện này)
    Activity context;
    // layout cho từng dòng muốn hiển thị (làm theo khách hàng) -> item.xml
    int resource;
    // Danh sách nguồn dữ liệu muốn hiển thị lên giao diện
    List<DanhBa> objects;

    // Constuctor số 5 của ArrayAdapter
    public DanhBaAdapter(Activity context, int resource, List<DanhBa> objects) {
        super(context, resource, objects); // //gọi Constructor của lớp cha
        this.context = context; // this -> Tham chiếu tới biến của class
        this.resource = resource;
        this.objects = objects;
    }

    // Hiệu chỉnh hàm getView()
    @Override // Ghi đè phương thức
    public View getView(int position,  View convertView, ViewGroup parent) {
        // int position -> Vị trí mà dữ liệu hiện tại cần vẽ lên

        // Sử dụng LayoutInflater: Lớp build layout bình thường thành code java
        // mà android có thể sử dụng được
        LayoutInflater inflater = this.context.getLayoutInflater();
        // Sử dụng View
        View row = inflater.inflate(this.resource, null);

        // Lấy các control đưa vào row
        TextView txtTen = row.findViewById(R.id.txtTen);
        TextView txtPhone = row.findViewById(R.id.txtPhone);
        ImageButton btnCall = row.findViewById(R.id.btnCall);
        ImageButton btnSms = row.findViewById(R.id.btnSms);
        ImageButton btnDetails = row.findViewById(R.id.btnChiTiet);

        // Trả về danh bạ hiện tại muốn vẽ
        DanhBa danhBa = this.objects.get(position);
        txtTen.setText(danhBa.getTen());
        txtPhone.setText(danhBa.getPhone());

        // Xử lý sự kiện
        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyXemChiTiet(danhBa);
            }
        });

        return row;
    }

    private void xuLyXemChiTiet(DanhBa danhBa) {
        // Thông báo
        Toast.makeText(this.context, "Bạn chọn: " + danhBa.getTen(), Toast.LENGTH_LONG).show();
    }
}


