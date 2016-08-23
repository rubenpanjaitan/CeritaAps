package tugas.develops.project.ceritaApps.Model;

/**
 * Created by Hita Do on 17/08/2016.
 */
public class CeritaModel {
    private int ID;
    private String judul;
    private String tahun;
    private String isi;
    private String gambar;
    private String pengarang;
    private String penerbit;
    private String namakategori;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJudul(){
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTahun() {
        return tahun;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getNamakategori() {
        return namakategori;
    }

    public void setNamakategori(String namakategori) {
        this.namakategori = namakategori;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
}
