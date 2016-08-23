package tugas.develops.project.ceritaApps.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tugas.develops.project.ceritaApps.Controller.BukuController;
import tugas.develops.project.ceritaApps.Controller.CeritaController;

/**
 * Created by Hita Do on 01/06/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "cerita.db";

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //generate databae
        db.execSQL(CeritaController.CREATE_CERITA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        //doing action
    }
}
