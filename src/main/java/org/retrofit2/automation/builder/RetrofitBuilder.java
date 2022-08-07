package org.retrofit2.automation.builder;

import okhttp3.OkHttpClient;
import org.retrofit2.automation.function.ConverterFactoryFunction;
import retrofit2.Retrofit;


public class RetrofitBuilder {

    private static Retrofit.Builder retrofitBuilder;

    private RetrofitBuilder() {

    }

    public static RetrofitBuilder builder() {
        retrofitBuilder = new Retrofit.Builder();
        return new RetrofitBuilder();
    }

    public RetrofitBuilder setBaseUrl(final String baseUrl) {
        retrofitBuilder.baseUrl(baseUrl);
        return this;
    }

    public RetrofitBuilder setCallAdapterFactory(final String converter) {
        retrofitBuilder.addConverterFactory(ConverterFactoryFunction.getConverterAdapterFactory(converter));
        return this;
    }

    public RetrofitBuilder client(final OkHttpClient okHttpClient) {
        retrofitBuilder.client(okHttpClient);
        return this;
    }

    public Retrofit build() {
        return retrofitBuilder.build();
    }

}
