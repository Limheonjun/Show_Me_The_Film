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

        setContentView(R.layout.webview);

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

        Intent intent = getIntent(); //
        String c1 = intent.getStringExtra("movieNm");


        web.loadUrl("https://search.naver.com/search.naver?sm=tab_sug.top&where=nexearch&query=" + c1); //네이버 검색uri와 daily_boxoffice 에 있는 movieNm 받아와서 합쳐서 로드함


        CheckTypesTask task = new CheckTypesTask(); //progressDialog 객체생성
        task.execute(); //실행

    }


//
//// 스레드를 사용할일이 있을때 시간에 따라 처리되는 일을 관리해주는 메소드 ( AsyncTask) 메소드를 상속받아 CheckTypesTask메소드를 생성
private class CheckTypesTask extends AsyncTask<Void, Void, Void> {

    ProgressDialog asyncDialog = new ProgressDialog(
            webview.this);

    @Override //작업시작 메소드 progress 객체 생성 및 시작
    protected void onPreExecute() {
        asyncDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        asyncDialog.setMessage("로딩중입니다...");

        // show dialog
        asyncDialog.show();
        super.onPreExecute();
    }

    @Override //진행중인 메소드 progress 진행정도 표현
    protected Void doInBackground(Void... arg0) {
        try {
            for (int i = 0; i < 5; i++) {
                //asyncDialog.setProgress(i * 30);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override //종료 메소드, progress 종료 부분 구현
    protected void onPostExecute(Void result) {
        asyncDialog.dismiss();
        super.onPostExecute(result);
    }
}}


