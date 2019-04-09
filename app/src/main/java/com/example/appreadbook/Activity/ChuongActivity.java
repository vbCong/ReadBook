package com.example.appreadbook.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appreadbook.Adapter.NoiDungAdapter;
import com.example.appreadbook.Model.NOIDUNG;
import com.example.appreadbook.R;
import com.example.appreadbook.Service.APIService;
import com.example.appreadbook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChuongActivity extends AppCompatActivity {

    Button btnDocTruyen,btnNoiDung,btnTheoDoi;
    ListView lvVanBan,lvAnh;
    ArrayList<NOIDUNG> data;
    int IDCHUONG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chuong );

        AnhXa();
        GetDataLocal();
        Getdata();

    }

    private void GetDataLocal() {
        Intent intent = getIntent();
        IDCHUONG = intent.getIntExtra( "IDCHUONG" , 1);
    }

    private void Getdata() {
        data = new ArrayList<>(  );
        Dataservice dataservice = APIService.getService();
        Call<List<NOIDUNG>> call = dataservice.GETNOIDUNG(IDCHUONG);
        call.enqueue( new Callback<List<NOIDUNG>>() {
            @Override
            public void onResponse(Call<List<NOIDUNG>> call, Response<List<NOIDUNG>> response) {
                data = (ArrayList<NOIDUNG>) response.body();
                NoiDungAdapter adapter = new NoiDungAdapter( ChuongActivity.this, R.layout.dong_noi_dung, data );
                lvAnh.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<NOIDUNG>> call, Throwable t) {
                Log.d("Tag", t.getMessage());
                t.printStackTrace();
            }
        } );
    }

    private void AnhXa() {
        lvVanBan = (ListView)findViewById( R.id.listND );
    }
}
