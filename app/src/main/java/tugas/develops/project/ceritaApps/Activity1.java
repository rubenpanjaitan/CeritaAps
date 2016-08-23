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
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import tugas.develops.project.ceritaApps.Adapter.BukuAdapter;
import tugas.develops.project.ceritaApps.Controller.BukuController;
import tugas.develops.project.ceritaApps.Model.BukuModel;

public class Activity1 extends AppCompatActivity {

    ListView grdData;
    BukuAdapter adapter;
    ArrayList<BukuModel> reseps=new ArrayList<BukuModel>();
    BukuController controllerResep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        controllerResep = new BukuController(this);

        grdData=(ListView)findViewById(R.id.grdData);
        try {
            //Open connection to db before access the data
            controllerResep.open();
            reseps = controllerResep.getData("Ayam");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Always close connection after open connection
            controllerResep.close();
        }

        adapter = new BukuAdapter(this,reseps);
        grdData.setAdapter(adapter);

        //event handling untuk gridview
        grdData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),Activity2.class);
                intent.putExtra("id",reseps.get(position).getId());
                intent.putExtra("judul",reseps.get(position).getJudul());
                intent.putExtra("tanggal",reseps.get(position).getTanggalterbit());
                intent.putExtra("harga",reseps.get(position).getHarga());
                intent.putExtra("isbn",reseps.get(position).getIsbn());
                intent.putExtra("jumlahhalaman",reseps.get(position).getJumlahhalaman());
                intent.putExtra("berat",reseps.get(position).getBerat());
                intent.putExtra("dimensi",reseps.get(position).getDimensi());
                intent.putExtra("gambar",reseps.get(position).getGambar());
                intent.putExtra("pengarang",reseps.get(position).getNamapengarang());
                intent.putExtra("penerbit",reseps.get(position).getNamapenerbit());
                intent.putExtra("kategori",reseps.get(position).getNamakategori());
                intent.putExtra("sinopsis",reseps.get(position).getSinopsis());
                startActivity(intent);

            }
        });



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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }if (id == R.id.about) {
            Intent intent=new Intent(this,About.class);
            startActivity(intent);
        }if (id == R.id.kat) {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
