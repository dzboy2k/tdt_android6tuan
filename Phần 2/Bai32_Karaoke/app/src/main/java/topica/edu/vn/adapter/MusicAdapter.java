package topica.edu.vn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import topica.edu.vn.bai32_karaoke.R;
import topica.edu.vn.model.Music;

public class MusicAdapter extends ArrayAdapter<Music> {

    Activity context; // Màn hình hiện tại
    int resource; // Layout sử dùng cho từng dòng
    List<Music> objects; // Danh sách nguồn dữ liệu

    public MusicAdapter( Activity context, int resource,  List<Music> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    // Sửa hàm getView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // position -> Vị trí đang vẽ
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        // Build layout bình thường thành code java
        View row = layoutInflater.inflate(this.resource, null); // Tạo dòng giao diện
        TextView txtMa = row.findViewById(R.id.txtMa);
        TextView txtTen = row.findViewById(R.id.txtTen);
        TextView txtCaSi = row.findViewById(R.id.txtCaSi);
        ImageButton btnLike = row.findViewById(R.id.btnLike);
        ImageButton btnDislike = row.findViewById(R.id.btnDislike);

        // Hiển thị thông tin lên giao diện
        Music music = this.objects.get(position);
        txtTen.setText(music.getTen());
        txtMa.setText(music.getMa());
        txtCaSi.setText(music.getCaSi());

        // Xử lý ẩn, hiện like và dislike
        if(music.isThich()){
            btnLike.setVisibility(View.INVISIBLE); // Ẩn đi
            btnDislike.setVisibility(View.VISIBLE); // Hiển thị lên
        }
        else {
            btnLike.setVisibility(View.VISIBLE);
            btnDislike.setVisibility(View.INVISIBLE);
        }

        // Xử lý Click like,dislike
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyThich(music);
            }
        });

        return row;
    }

    private void xuLyThich(Music music) {
        music.setThich(true);
    }
}
