package com.example.m.smtf;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class Daily_Boxoffice extends Fragment {

    TextView date;

    public Daily_Boxoffice() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;

    private RecyclerviewAdapterBoxoffice adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_daily_boxoffice, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        date = rootView.findViewById(R.id.clockYear);



        Gson gson = new GsonBuilder().setLenient()
                .create();

        GsonConverterFactory factory = GsonConverterFactory.create(gson);

        Retrofit retrofit = new Retrofit.Builder()

                .addConverterFactory(factory)

                .baseUrl("http://emergency.ga:3000/") // url과 포트

                .addConverterFactory(GsonConverterFactory.create())

                .build();


        final RemoteService remote = retrofit.create(RemoteService.class);

        Call<List<DailyBoxoffice>> call = remote.getDailyBoxoffice();
        call.enqueue(new Callback<List<DailyBoxoffice>>() {
            @Override
            public void onResponse(Call<List<DailyBoxoffice>> call, Response<List<DailyBoxoffice>> response) {
                String test;
                List<DailyBoxoffice> fd = response.body();

                Log.i("Log", "Check Data : " + fd.get(0).getMovieNm());
                date.setText(fd.get(0).getDate());
                recyclerView.setHasFixedSize(true);
                adapter = new RecyclerviewAdapterBoxoffice(getActivity(), fd);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<DailyBoxoffice>> call, Throwable t) {

            }
        });

        return rootView;
    }

}

