package tugas.develops.project.ceritaApps.API;

import retrofit.Callback;
import retrofit.http.POST;
import tugas.develops.project.ceritaApps.Response.BukuResponse;
import tugas.develops.project.ceritaApps.Response.CeritaResponse;

/**
 * Created by Hita Do on 01/06/2016.
 */
public interface API {
    @POST("/allCerita")
    public void getMenu(Callback<CeritaResponse> callback);


}
