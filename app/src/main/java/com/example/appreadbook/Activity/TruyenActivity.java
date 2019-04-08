package com.example.appreadbook.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appreadbook.Model.CHUONG;
import com.example.appreadbook.Model.TRUYEN;
import com.example.appreadbook.R;
import com.example.appreadbook.Service.APIService;
import com.example.appreadbook.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TruyenActivity extends AppCompatActivity {
    ListView lvDSChuong;
    ImageView imgAnhBia;
    TextView textTenTruyen,textTacGia,textTheLoai,textSlChuong;
    Button btnDocTruyen,btnNoiDung,btnTheoDoi;

    ArrayList<CHUONG> data;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_truyen );

        AnhXa();
        GetDataLocal();
        GetData();
        ClickItem();
    }

    private void ClickItem() {
        lvDSChuong.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent( TruyenActivity.this, ChuongActivity.class );
                intent.putExtra( "IDCHUONG", data.get( position ).getID() );
                startActivity( intent );
            }
        } );
        btnDocTruyen.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );
        btnTheoDoi.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );
        btnNoiDung.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        } );
    }


    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<TRUYEN> call = dataservice.GETTRUYENBYID(ID);
        call.enqueue( new Callback<TRUYEN>() {
            @Override
            public void onResponse(Call<TRUYEN> call, Response<TRUYEN> response) {
                TRUYEN truyen  = response.body();
                textTenTruyen.setText( truyen.getTEN() );
                textTacGia.setText( "Tác Giả: " + truyen.getTACGIA() );
                textTheLoai.setText( "Thể Loại: " + truyen.getTENTHELOAI() );
                textSlChuong.setText( "Số Chương: " + "0");
                Picasso.with( TruyenActivity.this ).load( truyen.getANHBIA() ).into( imgAnhBia );
            }

            @Override
            public void onFailure(Call<TRUYEN> call, Throwable t) {
                Log.d("Tag", t.getMessage());
                t.printStackTrace();
            }
        } );

        data = new ArrayList<>(  );
        Call<List<CHUONG>> call12 = dataservice.GETCHUONGTHEOID( ID );
        call12.enqueue( new Callback<List<CHUONG>>() {
            @Override
            public void onResponse(Call<List<CHUONG>> call, Response<List<CHUONG>> response) {
                data = (ArrayList<CHUONG>) response.body();
                ArrayList<String> ListChuong = new ArrayList<>(  );
                for (int i = 0; i < data.size(); i++ ){
                    ListChuong.add( "Chương " + (i + 1)  + " : " + data.get( i ).getTENCHUONG());
                }

                ArrayAdapter adapter = new ArrayAdapter( TruyenActivity.this, android.R.layout.simple_list_item_1, ListChuong );
                lvDSChuong.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<CHUONG>> call, Throwable t) {
                Log.d("Tag", t.getMessage());
                t.printStackTrace();
            }
        } );
    }

    private void AnhXa() {
        lvDSChuong = (ListView)findViewById( R.id.listviewDSChuong );
        imgAnhBia = (ImageView)findViewById( R.id.imageViewAnhBia );
        textTenTruyen = (TextView)findViewById( R.id.textViewTen );
        textTacGia = (TextView)findViewById( R.id.tenTacGia );
        textTheLoai = (TextView)findViewById( R.id.tenTheLoai );
        textSlChuong = (TextView)findViewById( R.id.slchuong );
        btnDocTruyen = (Button)findViewById( R.id.btnDocTuyen );
        btnNoiDung = (Button)findViewById( R.id.btnNoiDung );
        btnTheoDoi = (Button)findViewById( R.id.btnTheoDoi );

    }

    private void GetDataLocal() {
        Intent intent = getIntent();
        ID = intent.getIntExtra( "ID" , 1);
    }
}
