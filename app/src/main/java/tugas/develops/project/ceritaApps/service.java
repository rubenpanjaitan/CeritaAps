package tugas.develops.project.ceritaApps;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Hita Do on 02/06/2016.
 */
public class service extends Service {

    private static final String TAG = "MyService";
    private boolean isRunning = false;

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");
        isRunning = true;
    }

    /* The service is starting, due to a call to startService() */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service onStartCommand");
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return Service.START_STICKY;
    }

    /* A client is binding to the service with bindService() */
    @Override
    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "Service onBind");
        return null;
    }

    public void onDestroy() {
        isRunning = false;
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
        Log.i(TAG, "Service onDestroy");
    }
}