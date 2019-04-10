package com.example.appreadbook.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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

public class FragmentChuong extends Fragment {

    View view;
    ListView listviewNoiDung;
    ArrayList<NOIDUNG> data;
    int IDCHUONG;
    String TenTr;

    public FragmentChuong() {
    }

    public static FragmentChuong newInstance(int IDCHUONG) {
        FragmentChuong fragmnent = new FragmentChuong();
        Bundle bundle = new Bundle(  );
        bundle.putInt( "IDCHUONG" , IDCHUONG);
        fragmnent.setArguments( bundle );
        return fragmnent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        IDCHUONG = getArguments().getInt( "IDCHUONG" );
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_chuong, container, false);
        AnhXa();
        Getdata();
        return view;
    }

    private void Getdata() {
        data = new ArrayList<>(  );
        Dataservice dataservice = APIService.getService();
        Call<List<NOIDUNG>> call = dataservice.GETNOIDUNG(IDCHUONG);
        call.enqueue( new Callback<List<NOIDUNG>>() {
            @Override
            public void onResponse(Call<List<NOIDUNG>> call, Response<List<NOIDUNG>> response) {
                data = (ArrayList<NOIDUNG>) response.body();
                NoiDungAdapter adapter = new NoiDungAdapter( getActivity(), R.layout.dong_noi_dung, data );
                listviewNoiDung.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<NOIDUNG>> call, Throwable t) {
                Log.d("Tag", t.getMessage());
                t.printStackTrace();
            }
        } );
    }

    private void AnhXa() {
        listviewNoiDung = (ListView)view.findViewById( R.id.listviewNoiDung );
    }


}
