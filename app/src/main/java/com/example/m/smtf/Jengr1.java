package com.example.m.smtf;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Jengr1 extends Fragment {


    public Jengr1() {

    }

    private RecyclerView recyclerView;
    private RecyclerviewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_jengr1, container, false);

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

        Call<List<FilmDetail>> call = remote.getFlimDetail();
        call.enqueue(new Callback<List<FilmDetail>>() {
            @Override
            public void onResponse(Call<List<FilmDetail>> call, Response<List<FilmDetail>> response) {
                String test;
                List<FilmDetail> fd = response.body();

                Log.i("Log", "Check Data : " + fd.get(0).getMovieNm());
                recyclerView.setHasFixedSize(true);
                adapter = new RecyclerviewAdapter(getActivity(), fd);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<FilmDetail>> call, Throwable t) {

            }
        });

        return rootView;
    }

}
