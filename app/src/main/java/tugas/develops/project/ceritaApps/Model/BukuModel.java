package tugas.develops.project.ceritaApps.Model;

/**
 * Created by Hita Do on 01/06/2016.
 */
public class BukuModel {

    private int ID;
    private String judul;
    private String tanggalterbit;
    private String harga;
    private String isbn;
    private String jumlahhalaman;
    private String berat;
    private String dimensi;
    private String sinopsis;
    private String gambar;
    private String namapengarang;
    private String namapenerbit;
    private String namakategori;

    public int getId() {
        return ID;
    }
    public void setId(int id) {
        this.ID = id;
    }



    public String getBerat() {
        return berat;
    }

    public String getDimensi() {
        return dimensi;
    }

    public String getGambar() {
        return gambar;
    }

    public String getHarga() {
        return harga;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getJudul() {
        return judul;
    }

    public String getJumlahhalaman() {
        return jumlahhalaman;
    }

    public String getNamakategori() {
        return namakategori;
    }

    public String getNamapenerbit() {
        return namapenerbit;
    }

    public String getTanggalterbit() {
        return tanggalterbit;
    }

    public String getNamapengarang() {
        return namapengarang;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public void setDimensi(String dimensi) {
        this.dimensi = dimensi;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setJumlahhalaman(String jumlahhalaman) {
        this.jumlahhalaman = jumlahhalaman;
    }

    public void setNamakategori(String namakategori) {
        this.namakategori = namakategori;
    }

    public void setNamapenerbit(String namapenerbit) {
        this.namapenerbit = namapenerbit;
    }

    public void setNamapengarang(String namapengarang) {
        this.namapengarang = namapengarang;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setTanggalterbit(String tanggalterbit) {
        this.tanggalterbit = tanggalterbit;
    }

}
