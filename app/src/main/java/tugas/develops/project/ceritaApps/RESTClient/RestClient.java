package tugas.develops.project.ceritaApps.RESTClient;

import retrofit.RestAdapter;
import tugas.develops.project.ceritaApps.API.API;

/**
 * Created by Hita Do on 01/06/2016.
 */
public class RestClient {
    private static API REST_CLIENT;
    private static  String URL_RESEP="http://192.168.43.65/kumpulancerita";

    static {
        setupRestClient();
    }

    public static API getRestClient(){
        return REST_CLIENT;
    }

    private  static  void setupRestClient(){
        RestAdapter builder=new RestAdapter.Builder().setEndpoint(URL_RESEP).build();
        REST_CLIENT=builder.create(API.class);
    }
}
