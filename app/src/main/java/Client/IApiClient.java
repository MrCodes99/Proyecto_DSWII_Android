package Client;

import Entity.Persona;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MICHELL on 03/12/2017.
 */

public interface IApiClient {

    @GET("json")
    Call<List<Persona>> getPersonas();

}
