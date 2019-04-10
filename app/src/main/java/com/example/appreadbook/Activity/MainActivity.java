package com.example.appreadbook.Activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.appreadbook.Fragment.FragmentTruyen;
import com.example.appreadbook.Fragment.FragmentTruyenMoi;
import com.example.appreadbook.Fragment.FragmentTruyenTL;
import com.example.appreadbook.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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


        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();
        if(savedInstanceState == null) {
            //getSupportFragmentManager().beginTransaction().replace(R.id., new HomePageFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new FragmentTruyen();
        transaction.replace( R.id.framecontent, fragment );
        transaction.commit();
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
//                  }
//              });
            break;
        }

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.nav_home:
                fragment = new FragmentTruyen();
                break;
            case R.id.nav_truyenmoi:
                fragment = new FragmentTruyenMoi();
                break;
            case R.id.nav_kiemhiep:
                fragment = FragmentTruyenTL.newInstance( 1 );
                break;
            case R.id.nav_trinhtham:
                fragment = FragmentTruyenTL.newInstance( 2 );
                break;
            case R.id.na_tieuthuyet:
                fragment = FragmentTruyenTL.newInstance( 3 );
                break;
            case R.id.nav_vanhoc:
                fragment = FragmentTruyenTL.newInstance( 4 );
                break;
            case R.id.nav_ngontinh:
                fragment = FragmentTruyenTL.newInstance( 5 );
                break;
            case R.id.nav_dammy:
                fragment = FragmentTruyenTL.newInstance( 6 );
                break;
            case R.id.nav_tuduy:
                fragment = FragmentTruyenTL.newInstance( 7 );
                break;
            case R.id.nav_khoahoc:
                fragment = FragmentTruyenTL.newInstance( 8 );
                break;
            case R.id.nav_truyentranh:
                fragment = FragmentTruyenTL.newInstance( 9 );
                break;
            case R.id.nav_tho:
                fragment = FragmentTruyenTL.newInstance( 10 );
                break;
        }

        transaction.replace( R.id.framecontent, fragment );
        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}
