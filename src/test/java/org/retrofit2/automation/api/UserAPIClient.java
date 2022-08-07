package org.retrofit2.automation.api;

import org.retrofit2.automation.models.request.User;
import org.retrofit2.automation.models.response.Pages;
import org.retrofit2.automation.models.response.SingleUserResponse;
import org.retrofit2.automation.models.response.UserCreated;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserAPIClient {

    @GET("api/users/{id}")
    Call<SingleUserResponse> getUsersById(@Path("id") String id);

    @POST("api/users")
    Call<UserCreated> createUser(@Body User user);

    @GET("api/users")
    Call<Pages> getUserDetailsWithPagination(@Query("page") int pageRecords);

}

