package com.example.m.smtf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//주간 박스오피스
/**
 * A simple {@link Fragment} subclass.
 */
public class Weekly_Boxoffice extends Fragment  {




    private RecyclerView recyclerView;

    private RecyclerviewAdapterWeeklyBoxoffice adapter;


    public Weekly_Boxoffice() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_weekly_boxoffice,        container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        Gson gson = new GsonBuilder().setLenient()
                .create();

        GsonConverterFactory factory = GsonConverterFactory.create(gson);

        Retrofit retrofit = new Retrofit.Builder()

                .addConverterFactory(factory)

                .baseUrl("http://emergency.ga:3000/") // url과 포트

                .addConverterFactory(GsonConverterFactory.create())

                .build();
        final RemoteService remote = retrofit.create(RemoteService.class);

        Call<List<WeeklyBoxoffice>> call = remote.getWeeklyBoxoffice();
        call.enqueue(new Callback<List<WeeklyBoxoffice>>() {
            @Override
            public void onResponse(Call<List<WeeklyBoxoffice>> call, Response<List<WeeklyBoxoffice>> response) {
                String test;
                List<WeeklyBoxoffice> fd = response.body();

                String Name

               ;
                Log.i("Log", "Check Data : " + fd.get(0).getMovieNm());
                recyclerView.setHasFixedSize(true);
                adapter = new RecyclerviewAdapterWeeklyBoxoffice(getActivity(), fd);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<List<WeeklyBoxoffice>> call, Throwable t) {

            }
        });

        return rootView;
    }


}

