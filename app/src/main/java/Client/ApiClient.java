package Client;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MICHELL on 03/12/2017.
 */

public class ApiClient {

    private static IApiClient apiClient;

    public static IApiClient getApiClient() {

        if(apiClient == null) {
            Retrofit retrofit = new Retrofit
                    .Builder()
                    .baseUrl("http://192.168.1.37:8082/Proyecto_DSWII_2017-II/rest/persona/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiClient = retrofit.create(IApiClient.class);
        }

        return apiClient;
    }

}
