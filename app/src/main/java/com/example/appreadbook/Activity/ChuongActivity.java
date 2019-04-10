package com.example.appreadbook.Activity;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appreadbook.Adapter.NoiDungAdapter;
import com.example.appreadbook.Fragment.FragmentChuong;
import com.example.appreadbook.Fragment.FragmentTruyen;
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

    android.support.v7.widget.Toolbar toolbar;
    Button btnBack,btnNext;
    int IDCHUONG;
    int IDTR;
    int POS;
    String TenTr;
    ArrayList<Integer> arrIDCHUONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_chuong );

        AnhXa();
        GetDataLocal();
        GetData();
        SetUpToolbar();
        NextandBack();
    }

    private void GetDataLocal() {
        Intent intent = getIntent();
        IDCHUONG = intent.getIntExtra( "IDCHUONG" , 1);
        POS = intent.getIntExtra( "POS" , 1);
        TenTr = intent.getStringExtra( "TenTr" );
        IDTR = intent.getIntExtra( "IDTR", 1 );
    }
    private void GetData() {
        arrIDCHUONG = new ArrayList<>(  );
        Dataservice dataservice = APIService.getService();
        Call<List<Integer>> call = dataservice.GETARRIDCHUONGBYIDTR( IDTR );
        call.enqueue( new Callback<List<Integer>>() {
            @Override
            public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                arrIDCHUONG = (ArrayList<Integer>) response.body();
            }

            @Override
            public void onFailure(Call<List<Integer>> call, Throwable t) {
                Log.d("Tag", t.getMessage());
                t.printStackTrace();
            }
        } );

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = FragmentChuong.newInstance( IDCHUONG );
        transaction.replace( R.id.framecontent, fragment );
        transaction.commit();
    }

    private void AnhXa() {
        btnBack = (Button)findViewById( R.id.btnBack );
        btnNext = (Button)findViewById( R.id.btnNext );
        toolbar = (Toolbar)findViewById( R.id.toolbar );
    }

    private void SetUpToolbar() {
        //Set lại title
        toolbar.setTitle(TenTr + " : Chương " + (POS + 1));
        setSupportActionBar(toolbar);

        //Thêm nút navigation và Thay đổi icon
        //Lấy chiều cao của ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void NextandBack() {
        btnNext.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (IDCHUONG < arrIDCHUONG.get( arrIDCHUONG.size() - 1 )){
                POS++;
                IDCHUONG = arrIDCHUONG.get( POS );
                toolbar.setTitle(TenTr + " : Chương " + (POS + 1));
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment = FragmentChuong.newInstance( IDCHUONG );
                transaction.replace( R.id.framecontent, fragment );
                transaction.commit();
            }
            }
        } );
        btnBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (IDCHUONG > arrIDCHUONG.get( 0 )){
                POS--;
                IDCHUONG = arrIDCHUONG.get( POS );
                toolbar.setTitle(TenTr + " : Chương " + (POS + 1));
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment = FragmentChuong.newInstance( IDCHUONG );
                transaction.replace( R.id.framecontent, fragment );
                transaction.commit();
            }
            }
        } );
    }


}
