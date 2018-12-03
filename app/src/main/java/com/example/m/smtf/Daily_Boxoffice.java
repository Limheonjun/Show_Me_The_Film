package com.example.m.smtf;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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

        final ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_daily_boxoffice, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        date = rootView.findViewById(R.id.clockYear);


//
//        final WebView web;
//        web = (WebView) wbView.findViewById(R.id.webView);
//
////        WebSettings webSet = web.getSettings();
//
//        web.setWebViewClient(new WebViewClient(){
//
//            @Override //웹뷰가 실행되어 url을 불러올때의 이벤트 설정 메소드
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//
//                //progressDiago setting (선택)
////                dialog.setMessage("로딩중...");
////                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
////                dialog.show();
//            }
//
//            @Override  //외부에서 찾지 않고 자체적으로 웹뷰실행 메소드
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
//            }
//
//            @Override//로드가 끝나고 나서의 이벤트 설정
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
////                dialog.dismiss();
//            }
//        }); //웹뷰 등록

//
//        webSet.setJavaScriptEnabled(true);  //웹뷰에서 javaScript 사용여부
//        webSet.setBuiltInZoomControls(true); // 웹뷰에서 화면 확대/축소 아이콘 보이기




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
//                web.loadUrl("\n" +
//                        "https://search.naver.com/search.naver?sm=tab_sug.top&where=nexearch&query="+fd.get(0).getMovieNm());

            }

            @Override
            public void onFailure(Call<List<DailyBoxoffice>> call, Throwable t) {

            }
        });

        return rootView;
    }


}

