package topica.edu.vn.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import topica.edu.vn.bai38_projectcontactmanager.NhanTinSmsActivity;
import topica.edu.vn.bai38_projectcontactmanager.R;
import topica.edu.vn.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Activity context;
    int resource;
    List<Contact> objects;
    public ContactAdapter( Activity context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context; // Activity
        this.resource = resource; // Layout
        this.objects = objects; // Arraylist
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View row = layoutInflater.inflate(this.resource, null);
        TextView txtTen = row.findViewById(R.id.txtTen);
        TextView txtPhone = row.findViewById(R.id.txtPhone);
        ImageButton btnCall = row.findViewById(R.id.btnCall);
        ImageButton btnSms = row.findViewById(R.id.btnSms);
        ImageButton btnDelete = row.findViewById(R.id.btnDelete);

        // Hiển thi dữ liệu
        Contact contact = this.objects.get(position);
        txtTen.setText(contact.getName());
        txtPhone.setText(contact.getPhone());

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyCall(contact);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLySms(contact);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyXoa(contact);
            }
        });
        return row;
    }

    private void xuLyXoa(Contact contact) {
        this.remove(contact); // Xóa dữ liệu
    }

    private void xuLySms(Contact contact) {
        // Mở màn hình NhanTinSmsActivity
        Intent intent = new Intent(this.context, NhanTinSmsActivity.class);
        intent.putExtra("CONTACT", contact);
        this.context.startActivity(intent);
    }

    private void xuLyCall(Contact contact) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + contact.getPhone());
        intent.setData(uri);
        this.context.startActivity(intent);
    }
}
