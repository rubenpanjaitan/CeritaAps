package tugas.develops.project.ceritaApps;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Intent intent=getIntent();
        String judul = intent.getStringExtra("judul");
        String tahun = intent.getStringExtra("tahun");
        String pengarang = intent.getStringExtra("pengarang");
        String isi = intent.getStringExtra("isi");
        String gambar = intent.getStringExtra("gambar");

        //set data
        ImageView gambarResep=(ImageView)findViewById(R.id.gambar);
        Picasso.with(getApplicationContext())
                .load("http://192.168.43.65/kumpulancerita/" + gambar)
                .into(gambarResep);

        TextView Judul=(TextView)findViewById(R.id.judul);
        Judul.setText(judul);
        /*TextView Tahun=(TextView)findViewById(R.id.tahun);
        Tahun.setText(""tahun);
        TextView Pengarang=(TextView)findViewById(R.id.pengarang);
        Pengarang.setText(pengarang);*/
        TextView Isi=(TextView)findViewById(R.id.isi);
        Isi.setText(isi);



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
        getMenuInflater().inflate(R.menu.detail, menu);
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

        if (id == R.id.cerita_dongeng) {
            Intent intent = new Intent(this, DongengActivity.class);
            startActivity(intent);
        } else if (id == R.id.cerita_anak) {
            Intent intent = new Intent(this,AnakActivity.class);
            startActivity(intent);
        } else if (id == R.id.cerita_rakyat) {
            Intent intent = new Intent(this, RakyatActivity.class);
            startActivity(intent);

        } else if (id == R.id.cerita_lucu) {
            Intent intent = new Intent(this, LucuActivity.class);
            startActivity(intent);

        } else if (id == R.id.cerita_horor) {
            Intent intent = new Intent(this, HantuActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
