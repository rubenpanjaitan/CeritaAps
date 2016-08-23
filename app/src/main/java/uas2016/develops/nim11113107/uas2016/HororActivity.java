package uas2016.develops.nim11113107.uas2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import java.util.ArrayList;

import tugas.develops.project.ceritaApps.Adapter.CeritaAdapter;
import tugas.develops.project.ceritaApps.Controller.CeritaController;
import tugas.develops.project.ceritaApps.DetailActivity;
import tugas.develops.project.ceritaApps.Model.CeritaModel;
import tugas.develops.project.ceritaApps.R;

public class HororActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    ListView grdData;
    CeritaAdapter adapter;
    ArrayList<CeritaModel> ceritas=new ArrayList<CeritaModel>();
    CeritaController controllerCerita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        controllerCerita = new CeritaController(this);

        grdData=(ListView)findViewById(R.id.grdData);
        try {
            //Open connection to db before access the data
            controllerCerita.open();
            ceritas = controllerCerita.getData("Cerita Horor");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Always close connection after open connection
            controllerCerita.close();
        }

        adapter = new CeritaAdapter(this,ceritas);
        grdData.setAdapter(adapter);
        //event handling untuk gridview
        grdData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("judul", ceritas.get(position).getJudul());
                intent.putExtra("tahun", ceritas.get(position).getTahun());
                intent.putExtra("penerbit", ceritas.get(position).getPenerbit());
                intent.putExtra("pengarang", ceritas.get(position).getPengarang());
                intent.putExtra("isi", ceritas.get(position).getIsi());
                intent.putExtra("gambar", ceritas.get(position).getGambar());
                startActivity(intent);

/*
                Toast.makeText(getApplicationContext(),
                        "Anda memilih " + reseps.get(position).getResep(), Toast.LENGTH_LONG)
                        .show();
                        */
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.horor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
