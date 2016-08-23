package tugas.develops.project.ceritaApps.Response;

import java.util.List;

import tugas.develops.project.ceritaApps.Model.BukuModel;

/**
 * Created by Hita Do on 01/06/2016.
 */
public class BukuResponse {
    private String error;
    private List<BukuModel> allBuku;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setAllBuku(List<BukuModel> resep) {
        this.allBuku = resep;
    }

    public List<BukuModel> getAllBuku() {
        return this.allBuku;
    }

}
