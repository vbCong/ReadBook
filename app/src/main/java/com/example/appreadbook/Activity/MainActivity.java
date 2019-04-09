package com.example.appreadbook.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView lvDSTruyen;
    ArrayList<TRUYEN> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab;
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Just tap", Toast.LENGTH_SHORT).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );

        AnhXa();
        GetData();
        ClickItem();
    }

    private void ClickItem() {
        lvDSTruyen.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, data.get( position ).getID(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent( MainActivity.this, TruyenActivity.class );
                intent.putExtra( "ID", data.get( position ).getID() );
                startActivity( intent );
            }
        } );
    }

    private void GetData() {
        data = new ArrayList<>(  );

        Dataservice dataservice = APIService.getService();
        Call<List<TRUYEN>> call = dataservice.GETTRUYEN();
        call.enqueue( new Callback<List<TRUYEN>>() {
            @Override
            public void onResponse(Call<List<TRUYEN>> call, Response<List<TRUYEN>> response) {
                data = (ArrayList<TRUYEN>) response.body();
                TruyenAdapter adapter = new TruyenAdapter(MainActivity.this, R.layout.dong_truyen, data);
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
        lvDSTruyen = findViewById(R.id.listviewDSTruyen);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.menuSettings:
                Toast.makeText(this, "You choose Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuShare:
                Toast.makeText(this, "You choose Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuPhone:
                Toast.makeText(this, "You choose Phone", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuEmail:
                Toast.makeText(this, "You choose Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuExit:


//                    @Override
//                    public void onClick(View view) {
//                        //Khoi tao lai Activity main
//                        Intent intent = new Intent(getApplicationContext(), R.class);
//                        startActivity(intent);
//
//                        // Tao su kien ket thuc app
//                        Intent startMain = new Intent(Intent.ACTION_MAIN);
//                        startMain.addCategory(Intent.CATEGORY_HOME);
//                        startActivity(startMain);
//                        finish();
//                    }
//                });
                break;
        }

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
//            MainActivity mainActivity = new MainActivity();
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.fragment, mainActivity).commit();
        } else if (id == R.id.nav_alarm) {
//            TruyenActivity truyenActivity = new TruyenActivity();
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            fragmentManager.beginTransaction().replace(R.id.fragment, truyenActivity).commit();
        } else if (id == R.id.nav_newbook) {

        } else if (id == R.id.nav_xemnhieu) {

        } else if (id == R.id.nav_image) {

        } else if (id == R.id.nav_text) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}
