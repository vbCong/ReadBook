package com.example.appreadbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appreadbook.Model.TRUYEN;
import com.example.appreadbook.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ChuongAdapter extends BaseAdapter {

    private Context context;
    private int layout;

    private List<String> NDList;

    public ChuongAdapter(Context context, int layout, List<String> NDList) {
        this.context = context;
        this.layout = layout;
        this.NDList = NDList;
    }

    @Override
    public int getCount() {
        return NDList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//tạo dòng trả về view
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);
        //ánh xạ view
        ImageView imgAnh = (ImageView) convertView.findViewById(R.id.imageAnh);

        //gán giá trị
        Picasso.with(context).load(NDList.get(position)).into(imgAnh);

        return convertView;
    }
}
