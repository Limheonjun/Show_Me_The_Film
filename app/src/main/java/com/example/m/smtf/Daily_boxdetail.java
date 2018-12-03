package com.example.m.smtf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Daily_boxdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_boxdetail);

        TextView salesAmt, audiCnt, openDt, date, rank, rankOldAndNew, audiAcc, movieNm;
        Button search;


        Intent intent = getIntent();
        final String c1 = intent.getStringExtra("movieNm");
        String c2 = intent.getStringExtra("salesAmt");
        String c3 = intent.getStringExtra("openDt");
        String c4 = intent.getStringExtra("audiCnt");
        String c5 = intent.getStringExtra("date");
        String c6 = intent.getStringExtra("rank");
        String c7 = intent.getStringExtra("rankOldAndNew");
        String c8 = intent.getStringExtra("audiAcc");

        salesAmt = findViewById(R.id.salesAmt);
        audiCnt = findViewById(R.id.audiCnt);
        openDt = findViewById(R.id.openDt);
        audiAcc = findViewById(R.id.audiAcc);
        movieNm = findViewById(R.id.movieNm);
        date = findViewById(R.id.date);
        rank = findViewById(R.id.rank);
        rankOldAndNew = findViewById(R.id.rankOldAndNew);

        search = findViewById(R.id.search);

        movieNm.setText("영화명 : " + c1);
        rank.setText("오늘 박스오피스 순위 : " + c6);
        openDt.setText("영화 개봉일 : " + c3);
        rankOldAndNew.setText("랭킹 신규 진입 여부 : " + c7);
        audiCnt.setText("오늘 관객수 : " + c4);
        date.setText("박스오피스 조회 일자 : " + c5);
        salesAmt.setText("오늘 매출액 : " + c2);
        audiAcc.setText("누적 관객수 : " + c8);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), webview.class);
                intent.putExtra("movieNm", c1);
                startActivity(intent);
            }
        });

    }
}
