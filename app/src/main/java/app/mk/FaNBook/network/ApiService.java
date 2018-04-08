package app.mk.FaNBook.network;

/**
 * Created by Michael Kruszcyznski on 08/04/2018.
 */



    public class ApiService extends RetrofitGsonSpiceService {

    private final static String BASE_URL = "https://bookweb.ciolek.info/api/v1";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(ApiInterface.class);
    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }

}
