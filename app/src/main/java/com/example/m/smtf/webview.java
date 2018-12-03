package com.example.m.smtf;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class webview extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        Button goBtn = (Button) findViewById(R.id.goBtn);
        Button backBtn = (Button) findViewById(R.id.backBtn);

        WebView web;
        web = (WebView) findViewById(R.id.webView);

        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);

            }
        });
        Intent intent = getIntent(); // film_detail.class 로 부터 인텐트 받아옴
        String c1 = intent.getStringExtra("movieNm");


        web.loadUrl("https://search.naver.com/search.naver?sm=tab_sug.top&where=nexearch&query=" + c1); //네이버 검색uri와 daily_boxoffice 에 있는 movieNm 받아와서 합쳐서 로드함


    }
}
