package org.retrofit2.automation.factory;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

public class RetrofitClientFactory {

    private RetrofitClientFactory() {
    }

    public static <T> T createApiClient(Retrofit retrofit, Class<T> service) {
        return retrofit.create(service);
    }

    public static <T> Response<T> executeCall(Call<T> call) {
        Response<T> response = null;
        try {
            response = call.execute();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return response;
    }
}
