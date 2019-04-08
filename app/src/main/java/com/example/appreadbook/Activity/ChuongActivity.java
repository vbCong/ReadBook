package com.example.appreadbook.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appreadbook.Adapter.ChuongAdapter;
import com.example.appreadbook.Model.CHUONG;
import com.example.appreadbook.R;
import com.example.appreadbook.Service.APIService;
import com.example.appreadbook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChuongActivity extends AppCompatActivity {

    ListView lvVanBan,lvAnh;
    List<String> data;
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
        int IDCHUONG = intent.getIntExtra( "IDCHUONG" , 1);
        //Toast.makeText(ChuongActivity.this,  IDCHUONG + "", Toast.LENGTH_SHORT).show();
    }

    private void Getdata() {
        data = new ArrayList<>(  );
        Dataservice dataservice = APIService.getService();
        Call<List<String>> call = dataservice.GETLINKANH();
        call.enqueue( new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                data = response.body();
                ChuongAdapter adapter = new ChuongAdapter( ChuongActivity.this, R.layout.dong_anh, data );
                lvAnh.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.d("Tag", t.getMessage());
                t.printStackTrace();
            }
        } );
    }

    private void AnhXa() {
        lvVanBan = (ListView)findViewById( R.id.dsNDVanBan );
        lvAnh = (ListView)findViewById( R.id.dsNDAnh );
    }
}
