package com.cmps312.peoplepower.httpRequests;

import com.cmps312.peoplepower.models.Result;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserClient {

    String BASE_URL = "https://randomuser.me";

    @GET("/api/")
    Call<Result> getUsers(@Query("results") String results, @Query("format") String format);
}
