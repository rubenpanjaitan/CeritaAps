package tugas.develops.project.ceritaApps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    public static final String Username = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Intent intent=getIntent();
        String UsernameValue=intent.getStringExtra(Username);
        TextView username=(TextView)findViewById(R.id.username);
        username.setText("Hello, " + UsernameValue);

        this.registerReceiver(this.myBatteryReceiver, new
                IntentFilter(Intent.ACTION_BATTERY_CHANGED));

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
        }

        return super.onOptionsItemSelected(item);
    }

    public void kategori(View view){
        Intent intent=new Intent(this,Activity1.class);
        startActivity(intent);
    }
    public void about(View view){
        Intent intent=new Intent(this,About.class);
        startActivity(intent);
    }


    private BroadcastReceiver myBatteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int lvl = intent.getIntExtra("level", 0);
            // batteryLevel.setText("Battery anda saat ini : " + String.valueOf(lvl) + "%");
            // mBatteryLevelProgress.setProgress(lvl);
            if (lvl > 95) {
                Toast.makeText(context, "Baterai penuh.", Toast.LENGTH_LONG).show();


            }if(lvl<20){
                Toast.makeText(context,"Baterai lemah", Toast.LENGTH_LONG).show();

            }
        }
    };


}
