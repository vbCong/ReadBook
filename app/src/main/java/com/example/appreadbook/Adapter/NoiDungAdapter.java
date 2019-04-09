package com.example.appreadbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appreadbook.Model.NOIDUNG;
import com.example.appreadbook.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class NoiDungAdapter extends BaseAdapter {

    private Context context;
    private int layout;

    private List<NOIDUNG> NDList;

    public NoiDungAdapter(Context context, int layout, List<NOIDUNG> NDList) {
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
        ImageView imgAnh = (ImageView) convertView.findViewById( R.id.imageAnh);
        TextView txtND = (TextView) convertView.findViewById( R.id.textViewND );

        //gán giá trị
        if (!(NDList.get( position ).getANH().length() == 0)){
            Picasso.with(context).load(NDList.get( position ).getANH()).into(imgAnh);
            imgAnh.setVisibility( View.VISIBLE );
        }

        if(!(NDList.get( position ).getVANBAN().length() == 0)){
            txtND.setText( NDList.get( position ).getVANBAN() );
            txtND.setVisibility( View.VISIBLE );
        }
        return convertView;
    }
}

