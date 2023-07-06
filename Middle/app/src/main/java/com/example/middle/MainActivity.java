package com.example.middle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitClient rc = new RetrofitClient();
        RetrofitInterface api = rc.getRetrofit().create(RetrofitInterface.class); //레스로핏 초기화 식
        api.getCu().enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("레트로핏", "onResponse: ");
                CustomerVO vo = new Gson().fromJson(response.body(), CustomerVO.class);
                Log.d("레트로핏", "onResponse: "+vo);
                Log.d("레트로핏", "onResponse: "+vo.getName());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("레트로핏", "onResponse: ");
            }
        });

        api.getCuList().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                //TypeToken: 버그 있음. new TypdToken 바로 못찾음.
                ArrayList<CustomerVO> list = new Gson().fromJson(
                        result, new TypeToken<ArrayList<CustomerVO>>(){}.getType()
                );
                Log.d("레트로피", "onResponse: "+list.size());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


    }
}