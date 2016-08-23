package tugas.develops.project.ceritaApps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;

public class Login extends AppCompatActivity {

    private SharedPreferences pref;
    // A SharedPreferences.Editor for writing data
    private SharedPreferences.Editor editor;
    private final String KEY_NAME = "name";
    public boolean service=false;
    private String file = "mydata";
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        AppEventsLogger.activateApp(getApplicationContext());
        setContentView(R.layout.activity_login);


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //initialize the prefs object using the getSharedPreferences method andby passing in String
//Mode_Private means that any class, in this app only, can access it
        pref = getSharedPreferences("mypreferences", MODE_PRIVATE);
        String savedName = pref.getString(KEY_NAME, "-");
        //TextView tvSavedName = (TextView) findViewById(R.id.txtViewName);
        //tvSavedName.setText(savedName);
        final EditText Name = (EditText) findViewById(R.id.username);
        Button bSave = (Button) findViewById(R.id.login);
        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String name = Name.getText().toString();
                if (name.equals("")) {
                    Toast.makeText(Login.this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
//Initialized prefs object to initialize editor object by calling the edit method
                    editor = pref.edit();
//Save the name that we have in a string
//Then write the data to the internal memory of the device
                    editor.putString(KEY_NAME, name);
                    editor.commit();
//Reload the name values that the previous code saved.
//We could even declare our variables and initialize themwith the stored values:
                    String savedName = pref.getString(KEY_NAME, "-");

                   /* Intent intent=new Intent(getApplication(),MainActivity.class);
                    intent.putExtra(MainActivity.Username, savedName);
                    startActivity(intent);*/
                    Intent intent=new Intent(getApplication(),HomeActivity.class);
                    startActivity(intent);

                    service=true;
                    //start service
                    Intent inten = new Intent(Login.this, service.class);
                    startService(inten);

                    //internal storage
                    String data;
                    data = savedName;
                    try {
//Call the openFileOutput() method with the name of the file
                        FileOutputStream fOut = openFileOutput(file, MODE_WORLD_READABLE);
//Call write method to write data on the file
                        fOut.write(data.getBytes());
                        fOut.close();
                        Toast.makeText(getBaseContext(),savedName,
                                Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    }



                }
            }
        });

        info = (TextView) findViewById(R.id.info);
        loginButton = (LoginButton) findViewById(R.id.login_button);

        //Call Facebook Login API
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request =
                        GraphRequest.newMeRequest(loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object, GraphResponse
                                            response) {
                                        JSONObject json = response.getJSONObject();
                                        try {
                                            String name=json.getString("name");
                                            Intent intent = new Intent(Login.this, MainActivity.class);
                                            intent.putExtra(MainActivity.Username, name);
                                            startActivity(intent);

                                            service=true;
                                            //start service
                                            Intent inten = new Intent(Login.this, service.class);
                                            startService(inten);
                                            finish();
                                        }catch(JSONException e){
                                            e.printStackTrace();
                                        }

                                    }
                                });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
                info.setText("Login attempt canceled.");
                Log.e("test", "can");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Login attempt failed.");
                Log.e("test", "fail");
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }








}
