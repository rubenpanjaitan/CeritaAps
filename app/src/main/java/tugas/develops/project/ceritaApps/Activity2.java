package tugas.develops.project.ceritaApps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //get value
        Intent intent=getIntent();
        String _judul=intent.getStringExtra("judul");
        String _isbn=intent.getStringExtra("isbn");
        String _harga=intent.getStringExtra("harga");
        String _tanggal=intent.getStringExtra("tanggal");
        String _halaman=intent.getStringExtra("jumlahhalaman");
        String _pengarang=intent.getStringExtra("pengarang");
        String _penerbit=intent.getStringExtra("penerbit");
        String _berat=intent.getStringExtra("berat");
        String _dimensi=intent.getStringExtra("dimensi");
        String _sinopsis=intent.getStringExtra("sinopsis");
        String gambar=intent.getStringExtra("gambar");

        ImageView gambarBuku=(ImageView)findViewById(R.id.gambar);
        Picasso.with(getApplicationContext())
                .load("http://192.168.43.65/uaspam/" + gambar)
                .into(gambarBuku);

        TextView judul=(TextView)findViewById(R.id.judul);
        judul.setText("Judul :" + _judul);
        TextView pengarang=(TextView)findViewById(R.id.pengarang);
        pengarang.setText("Pengarang :"+_pengarang);
        TextView penerbit=(TextView)findViewById(R.id.penerbit);
        penerbit.setText("Penerbit  :" + _penerbit);
        TextView isbn=(TextView)findViewById(R.id.isbn);
        isbn.setText("Isbn :" + _isbn);
        TextView harga=(TextView)findViewById(R.id.harga);
        harga.setText("Harga :" + _harga);
        TextView berat=(TextView)findViewById(R.id.berat);
        berat.setText("Berat :" + _berat);
        TextView halaman=(TextView)findViewById(R.id.halaman);
        halaman.setText("Halaman :" + _halaman);
        TextView dimensi=(TextView)findViewById(R.id.dimensi);
        dimensi.setText("dimensi :" + _dimensi);
        TextView tanggal=(TextView)findViewById(R.id.terbit);
        tanggal.setText("Terbit :" + _tanggal);
        TextView sinopsis=(TextView)findViewById(R.id.sinopsis);
        sinopsis.setText("Sinopsis :" + _sinopsis);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            Toast.makeText(this, "Search", Toast.LENGTH_LONG).show();
        }if (id == R.id.sort) {
            Toast.makeText(this,"Sort", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
