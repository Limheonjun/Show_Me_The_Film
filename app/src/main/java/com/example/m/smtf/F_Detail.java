package com.example.m.smtf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class F_Detail extends AppCompatActivity {

    TextView movieNmEn, prdtYear, openDt, typeNm, movieNm, prdtStatNm, repNationNm, repGenreNm;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f__detail);

        Intent intent = getIntent();
        final String c1 = intent.getStringExtra("movieNm");
        String c2 = intent.getStringExtra("movieNmEn");
        String c3 = intent.getStringExtra("openDt");
        String c4 = intent.getStringExtra("prdtYear");
        String c5 = intent.getStringExtra("prdtStatNm");
        String c6 = intent.getStringExtra("repNationNm");
        String c7 = intent.getStringExtra("repGenreNm");
        String c8 = intent.getStringExtra("typeNm");

        movieNmEn = findViewById(R.id.movieNmEn);
        prdtYear = findViewById(R.id.prdtYear);
        openDt = findViewById(R.id.openDt);
        typeNm = findViewById(R.id.typeNm);
        movieNm= findViewById(R.id.movieNm);
        repNationNm = findViewById(R.id.repNationNm);
        prdtStatNm = findViewById(R.id.prdtStatNm);
        repGenreNm = findViewById(R.id.repGenreNm);

        search = findViewById(R.id.search);

        movieNm.setText("영화명 : "+c1);
        movieNmEn.setText("영화명(영문) : "+c2);
        openDt.setText("개봉년도 : "+c3);
        prdtYear.setText("제작년도 : "+c4);
        typeNm.setText("영화유형 : "+c8);
        prdtStatNm.setText("제작상태 : "+c5);
        repNationNm.setText("제작국가 : "+c6);
        repGenreNm.setText("장르 : "+c7);


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
