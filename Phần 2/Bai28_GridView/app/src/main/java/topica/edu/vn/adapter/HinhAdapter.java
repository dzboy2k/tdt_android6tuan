package topica.edu.vn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import topica.edu.vn.bai28_gridview.R;

public class HinhAdapter extends ArrayAdapter<Integer> { // id có kiểu int (Integer)
    Activity context; // màn hình sử dụng
    int resource; // layout sử dụng
    List<Integer> objects; // Danh sách nguồn dữ liệu

    public HinhAdapter(Activity context, int resource, List<Integer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    // Vẽ giao diện
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater(); // build layout thành code java
        View row = inflater.inflate(this.resource, null); // Đưa layout vào inflate

        // Lấy hình hiển thị lên giao diện
        ImageView img = row.findViewById(R.id.imgHinh);
        // Hiển thị hình ảnh
        img.setImageResource(this.objects.get(position)); // position: vị trí của hình đang vẽ

        return row;
    }
}
