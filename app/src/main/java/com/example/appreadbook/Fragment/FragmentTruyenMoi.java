package com.example.appreadbook.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.appreadbook.Activity.TruyenActivity;
import com.example.appreadbook.Adapter.TruyenAdapter;
import com.example.appreadbook.Model.TRUYEN;
import com.example.appreadbook.R;
import com.example.appreadbook.Service.APIService;
import com.example.appreadbook.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentTruyenMoi extends Fragment {
    View view;
    ListView lvDSTruyen;
    ArrayList<TRUYEN> data;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_truyen_moi, container, false);
        AnhXa();
        GetData();
        ClickItem();
        return view;
    }

    private void ClickItem() {
        lvDSTruyen.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent( getActivity(), TruyenActivity.class );
            intent.putExtra( "ID", data.get( position ).getID() );
            startActivity( intent );
            }
        } );
    }

    private void GetData() {
        data = new ArrayList<>(  );

        Dataservice dataservice = APIService.getService();
        Call<List<TRUYEN>> call = dataservice.GETTRUYENMOI();
        call.enqueue( new Callback<List<TRUYEN>>() {
            @Override
            public void onResponse(Call<List<TRUYEN>> call, Response<List<TRUYEN>> response) {
                data = (ArrayList<TRUYEN>) response.body();
                TruyenAdapter adapter = new TruyenAdapter( getActivity(), R.layout.dong_truyen, data);
                lvDSTruyen.setAdapter( adapter );
            }

            @Override
            public void onFailure(Call<List<TRUYEN>> call, Throwable t) {
                Log.d("Tag", t.getMessage());
                t.printStackTrace();
            }
        } );
    }

    private void AnhXa() {
        lvDSTruyen = view.findViewById(R.id.listviewDSTruyen);
    }
}
