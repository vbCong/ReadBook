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
import android.widget.Toast;
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

public class FragmentTruyenTL extends Fragment {
    View view;
    ListView lvDSTruyen;
    ArrayList<TRUYEN> data;
    int IDTHELOAI;

    public FragmentTruyenTL() {
    }

    public static FragmentTruyenTL newInstance(int IDTHELOAI) {
        FragmentTruyenTL fragmnent = new FragmentTruyenTL();
        Bundle bundle = new Bundle(  );
        bundle.putInt( "IDTHELOAI" , IDTHELOAI);
        fragmnent.setArguments( bundle );
        return fragmnent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        IDTHELOAI = getArguments().getInt( "IDTHELOAI" );
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.fragment_truyen_tl, container, false);
        AnhXa();
        GetData();
        ClickItem();
        return view;
    }

    private void ClickItem() {
        lvDSTruyen.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(MainActivity.this, data.get( position ).getID(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent( getActivity(), TruyenActivity.class );
            intent.putExtra( "ID", data.get( position ).getID() );
            startActivity( intent );
            }
        } );
    }

    private void GetData() {
        data = new ArrayList<>(  );

        final Dataservice dataservice = APIService.getService();
        Call<List<TRUYEN>> call = dataservice.GETTRUYENBYIDTL(IDTHELOAI);
        call.enqueue( new Callback<List<TRUYEN>>() {
            @Override
            public void onResponse(Call<List<TRUYEN>> call, Response<List<TRUYEN>> response) {
                data = (ArrayList<TRUYEN>) response.body();
                Toast.makeText(getActivity(),IDTHELOAI + "", Toast.LENGTH_SHORT).show();
                for (int i = 0 ; i < data.size(); i++){
                    Log.d( "Tag", data.get( i ).getTEN() );
                }
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
