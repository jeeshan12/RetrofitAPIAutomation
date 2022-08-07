package org.retrofit2.automation.tests;

import com.github.javafaker.Faker;
import okhttp3.OkHttpClient;
import org.retrofit2.automation.api.UserAPIClient;
import org.retrofit2.automation.builder.HeadersBuilder;
import org.retrofit2.automation.builder.OkhttpClientBuilder;
import org.retrofit2.automation.builder.RetrofitBuilder;
import org.retrofit2.automation.factory.RetrofitClientFactory;
import org.retrofit2.automation.models.request.User;
import org.retrofit2.automation.models.response.Pages;
import org.retrofit2.automation.models.response.SingleUserResponse;
import org.retrofit2.automation.models.response.UserCreated;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserAPITests {


    private UserAPIClient userAPIClient;

    @BeforeClass
    public void setUp() {
        OkHttpClient okHttpClient = OkhttpClientBuilder.builder().addHeaders(HeadersBuilder.builder().setHeaders("Content-Type", "application/json").build()).build();
        Retrofit retrofit = RetrofitBuilder.builder().setBaseUrl("https://reqres.in/").setCallAdapterFactory("gson").client(okHttpClient).build();
        this.userAPIClient = RetrofitClientFactory.createApiClient(retrofit, UserAPIClient.class);

    }

    @Test
    public void testUserDetailsForSpecificID() {
        Response<SingleUserResponse> singleUserResponseResponse = RetrofitClientFactory.executeCall(userAPIClient.getUsersById("2"));
        Assert.assertEquals(singleUserResponseResponse.code(), 200, "Status Code");
        Assert.assertEquals(singleUserResponseResponse.body().getData().getId(), 2, "User ID");
        Assert.assertEquals(singleUserResponseResponse.body().getData().getEmail(), "janet.weaver@reqres.in", "Email");
        Assert.assertEquals(singleUserResponseResponse.body().getData().getFirst_name(), "Janet", "First Name");
        Assert.assertEquals(singleUserResponseResponse.body().getData().getLast_name(), "Weaver", "Last Name");
        Assert.assertEquals(singleUserResponseResponse.body().getData().getAvatar(), "https://reqres.in/img/faces/2-image.jpg", "Avatar");
    }

    @Test
    public void testCreateUser() {
        Faker faker = new Faker();
        final String name = faker.name().fullName();
        final String job = faker.commerce().department();
        Response<UserCreated> userCreatedResponse = RetrofitClientFactory.executeCall(userAPIClient.createUser(User.builder().name(name).job(job).build()));
        System.out.println(userCreatedResponse.body().toString());
        Assert.assertEquals(userCreatedResponse.code(), 201, "Status Code");
        Assert.assertEquals(userCreatedResponse.body().getName(), name, "Full Name");
        Assert.assertEquals(userCreatedResponse.body().getJob(), job, "Job");
    }

    @Test
    public void testUserDetailsForPagination() {
        Response<Pages> recordsResponse = RetrofitClientFactory.executeCall(userAPIClient.getUserDetailsWithPagination(2));
        Assert.assertEquals(recordsResponse.code(), 200, "Status Code");
        Assert.assertEquals(recordsResponse.body().getData().length, 6, "Data Count");
    }
}
