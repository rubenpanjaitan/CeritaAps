package tugas.develops.project.ceritaApps;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tugas.develops.project.ceritaApps.Controller.BukuController;
import tugas.develops.project.ceritaApps.Controller.CeritaController;
import tugas.develops.project.ceritaApps.Model.BukuModel;
import tugas.develops.project.ceritaApps.Model.CeritaModel;
import tugas.develops.project.ceritaApps.RESTClient.RestClient;
import tugas.develops.project.ceritaApps.Response.BukuResponse;
import tugas.develops.project.ceritaApps.Response.CeritaResponse;

public class Splashscreen extends AppCompatActivity {

    Context mycontext;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        mycontext=getApplicationContext();
        //menampilkan dialog
        progress= ProgressDialog.show(Splashscreen.this, "Inisialisasi data", "Sedang Mengundah Data Untuk Aplikasi", true);
        //RESTClient
        RestClient.getRestClient().getMenu(new Callback<CeritaResponse>(){
            @Override
            public void success(CeritaResponse cerita, Response response) {
                if (cerita.getAllCerita().size() > 0) {
                    CeritaController ctr = new CeritaController(mycontext);
                    ctr.open();
                    ctr.deleteData();
                    for (int i = 0; i < cerita.getAllCerita().size(); i++) {
                        //get and insert to sqllite
                        CeritaModel tmpHasil = cerita.getAllCerita().get(i);
                        Toast.makeText(getApplicationContext(),tmpHasil.getJudul()+tmpHasil.getID(), Toast.LENGTH_LONG).show();
                        ctr.insertData(tmpHasil.getID(), tmpHasil.getJudul(),tmpHasil.getTahun(),tmpHasil.getIsi(),tmpHasil.getPengarang(),tmpHasil.getPenerbit(),tmpHasil.getNamakategori(),tmpHasil.getGambar());
                    }
                    //ctr.close();
                    Intent intent = new Intent(mycontext, Login.class);
                    startActivity(intent);
                    finish();
                } else {

                    Toast.makeText(getApplicationContext(), "Data Sedang Tidak tersedia", Toast.LENGTH_LONG).show();
                    progress.dismiss();
                }

            }

            @Override
            public void failure(RetrofitError error) {
                progress.dismiss();
                Toast.makeText(getApplicationContext(), "Akses Database ke server Gagal" + error.getMessage(), Toast.LENGTH_LONG).show();
                //Intent intent = new Intent(mycontext, Login.class);
                //startActivity(intent);
            }
        });
    }
}
