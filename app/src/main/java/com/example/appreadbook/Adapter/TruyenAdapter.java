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

public class TruyenAdapter extends BaseAdapter {
    private Context context;
    private int layout;

    private List<TRUYEN> TruyenList;

    public TruyenAdapter(Context context, int layout, List<TRUYEN> truyenList) {
        this.context = context;
        this.layout = layout;
        this.TruyenList = truyenList;
    }

    @Override
    public int getCount() {
        return TruyenList.size();
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
        TextView txtTen = (TextView) convertView.findViewById( R.id.textViewTen);
        TextView txtTTND = (TextView) convertView.findViewById(R.id.textViewTheLoai);
        ImageView imgAnhBia = (ImageView) convertView.findViewById(R.id.imageViewAnhBia);

        //gán giá trị
        txtTen.setText(TruyenList.get(position).getTEN());
        txtTTND.setText(TruyenList.get(position).getTENTHELOAI());
        Picasso.with(context).load(TruyenList.get(position).getANHBIA()).into(imgAnhBia);

        return convertView;
    }
}
