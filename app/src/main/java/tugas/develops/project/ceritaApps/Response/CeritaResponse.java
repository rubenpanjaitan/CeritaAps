package tugas.develops.project.ceritaApps.Response;

import java.util.List;


import tugas.develops.project.ceritaApps.Model.CeritaModel;

/**
 * Created by Hita Do on 17/08/2016.
 */
public class CeritaResponse {

    private String error;
    private List<CeritaModel> allCerita;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setAllBuku(List<CeritaModel> cerita) {
        this.allCerita = cerita;
    }

    public List<CeritaModel> getAllCerita() {
        return this.allCerita;
    }
}
