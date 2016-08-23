package tugas.develops.project.ceritaApps.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import tugas.develops.project.ceritaApps.Database.DBHelper;
import tugas.develops.project.ceritaApps.Model.BukuModel;

/**
 * Created by Hita Do on 01/06/2016.
 */
public class BukuController {

    private DBHelper dbHelper;
    private SQLiteDatabase database;

    public static final String TABLE_NAME="buku";
    public static final String id="id";
    public static final String judul="judul";
    public static final String tanggalterbit="tanggalterbit";
    public static final String harga="harga";
    public static final String isbn="isbn";
    public static final String jumlahhalaman="jumlahhalaman";
    public static final String berat="berat";
    public static final String dimensi="dimensi";
    public static final String sinopsis="sinopsis";
    public static final String gambar="gambar";
    public static final String namapengarang="namapengarang";
    public static final String namapenerbit="namapenerbit";
    public static final String namakategori="namakategori";

    public static final String CREATE_BUKU = "CREATE TABLE "+TABLE_NAME+" "+"("+id+" integer primary  key, "+
            judul+" TEXT, "+ tanggalterbit+" TEXT, "+ harga+" TEXT, "+isbn+" TEXT, "+ jumlahhalaman+" TEXT, "+berat+" TEXT, "+dimensi+" TEXT, "+sinopsis+" TEXT, "+
            gambar+" TEXT, "+namapengarang+" TEXT, "+namapenerbit+" TEXT, "+namakategori+" TEXT)";

    private String[] TABLE_COLOUMS={id,judul,tanggalterbit,harga,isbn,jumlahhalaman,berat,dimensi,sinopsis,gambar,namapengarang,namapenerbit,namakategori};

    public BukuController(Context context){
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

    public void insertData(int _id,String _judul,String _tanggalterbit,String _harga,String _isbn,String _jumlahhalaman,String _berat,String _dimensi,String _sinopsis,String _gambar,String _namapengarang,String _namapenerbit,String _namakategori){
        ContentValues contentValues=new ContentValues();
        contentValues.put(id,_id);
        contentValues.put(judul,_judul);
        contentValues.put(tanggalterbit,_tanggalterbit);
        contentValues.put(harga,_harga);
        contentValues.put(isbn,_isbn);
        contentValues.put(jumlahhalaman,_jumlahhalaman);
        contentValues.put(berat,_berat);
        contentValues.put(dimensi,_dimensi);
        contentValues.put(sinopsis,_sinopsis);
        contentValues.put(gambar,_gambar);
        contentValues.put(namapengarang,_namapengarang);
        contentValues.put(namapenerbit,_namapenerbit);
        contentValues.put(namakategori,_namakategori);

        database.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<BukuModel> getData(String jenis){
        ArrayList<BukuModel> allData=new ArrayList<>();
        Cursor cursor=null;
        database=dbHelper.getWritableDatabase();
        //cursor=database.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE "+JENIS+" = ?",new String[]{jenis});
        cursor = database.query(TABLE_NAME, TABLE_COLOUMS,null, null, null, null, id + " ASC");
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            allData.add(parseData(cursor));

            cursor.moveToNext();

        }
        cursor.close();

        return allData;
    }

    private BukuModel parseData(Cursor cursor) {
        BukuModel curData = new BukuModel();

       curData.setId(cursor.getInt(0));
        curData.setJudul(cursor.getString(1));
        curData.setTanggalterbit(cursor.getString(2));
        curData.setHarga(cursor.getString(3));
        curData.setIsbn(cursor.getString(4));
        curData.setJumlahhalaman(cursor.getString(5));
        curData.setBerat(cursor.getString(6));
        curData.setDimensi(cursor.getString(6));
        curData.setSinopsis(cursor.getString(8));
        curData.setGambar(cursor.getString(9));
        curData.setNamapengarang(cursor.getString(10));
        curData.setNamapenerbit(cursor.getString(11));
        curData.setNamakategori(cursor.getString(12));

        return curData;
    }
}
