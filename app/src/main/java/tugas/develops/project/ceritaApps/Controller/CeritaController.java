package tugas.develops.project.ceritaApps.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tugas.develops.project.ceritaApps.Database.DBHelper;
import tugas.develops.project.ceritaApps.Model.CeritaModel;

/**
 * Created by Hita Do on 17/08/2016.
 */
public class CeritaController {

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public static final String TABLE_NAME="cerita";
    public static final String id="id";
    public static final String judul="judul";
    public static final String tahun="tahun";
    public static final String isi="isi";
    public static final String gambar="gambar";
    public static final String pengarang="pengarang";
    public static final String penerbit="penerbit";
    public static final String namakategori="namakategori";

    public static final String CREATE_CERITA= "CREATE TABLE "+TABLE_NAME+" "+"("+id+" integer primary  key, "+
            judul+" TEXT, "+ tahun+" TEXT, "+ isi+" TEXT, "+ pengarang+" TEXT, "+ penerbit+" TEXT, "+ namakategori+" TEXT, "+ gambar+" TEXT)";

    private String[] TABLE_COLOUMS={id,judul,tahun,isi,pengarang,penerbit,namakategori,gambar};

    public CeritaController(Context context){
        dbHelper=new DBHelper(context);
    }
    public void open(){
        database=dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public void deleteData(){
        database.delete(TABLE_NAME, null, null);
    }

    public void insertData(int _id,String _judul,String _tahun,String _isi,String _pengarang,String _penerbit,String _namakategori,String _gambar){
        ContentValues contentValues=new ContentValues();
        contentValues.put(id,_id);
        contentValues.put(judul,_judul);
        contentValues.put(tahun,_tahun);
        contentValues.put(gambar,_gambar);
        contentValues.put(isi,_isi);
        contentValues.put(pengarang,_pengarang);
        contentValues.put(penerbit,_penerbit);
        contentValues.put(namakategori,_namakategori);
        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<CeritaModel> getData(String jenis){
        ArrayList<CeritaModel> allData=new ArrayList<>();
        Cursor cursor=null;
        database=dbHelper.getWritableDatabase();
        cursor=database.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+namakategori+" = ?",new String[]{jenis});
       // cursor = database.query(TABLE_NAME, TABLE_COLOUMS,null, null, null, null, id + " ASC");
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            allData.add(parseData(cursor));

            cursor.moveToNext();

        }
        cursor.close();

        return allData;
    }

    private CeritaModel parseData(Cursor cursor) {
        CeritaModel curData = new CeritaModel();

        curData.setID(cursor.getInt(0));
        curData.setJudul(cursor.getString(1));
        curData.setTahun(cursor.getString(2));
        curData.setIsi(cursor.getString(3));
        curData.setPengarang(cursor.getString(4));
        curData.setPenerbit(cursor.getString(5));
        curData.setNamakategori(cursor.getString(6));
        curData.setGambar(cursor.getString(7));

        return curData;
    }
}
