package com.example.middle;

//Retrofit retrofit = new Retrofit.Builder()
//    .baseUrl("https://api.github.com/")
//    .addConverterFactory(GsonConverterFactory.create())
//    .build();
//
//GitHubService service = retrofit.create(GitHubService.class);

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    //baseUrl(http://192.168.0.119:8080/middle/) : spring에서 프로젝트까지 경로(Home)
    //ScalarsConverterFactory
    public Retrofit getRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.119:8080/middle/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit;
    }


}
