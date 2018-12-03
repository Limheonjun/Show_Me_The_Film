package com.example.m.smtf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Holder> {

    private Context context;
    private List<FilmDetail> list;

    public RecyclerviewAdapter(Context context, List<FilmDetail> list) {
        this.context = context;
        this.list = list;
    }



    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fd, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {
        // 각 위치에 문자열 세팅
        final int itemposition = position;
        holder.movieNm.setText("영화명 : "+list.get(itemposition).movieNm);
        holder.openDt.setText("개봉년도 : "+list.get(itemposition).openDt);
        holder.repNationNm.setText("제작국가 : "+list.get(itemposition).repNationNm);
        holder.repGenreNm.setText("장르 : "+list.get(itemposition).repGenreNm);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, F_Detail.class);
                intent.putExtra("movieNm", list.get(itemposition).movieNm);
                intent.putExtra("movieNmEn", list.get(itemposition).movieNmEn);
                intent.putExtra("openDt", list.get(itemposition).openDt);
                intent.putExtra("prdtYear",list.get(itemposition).prdtYear);
                intent.putExtra("prtdStatNm", list.get(itemposition).prdtStatNm);
                intent.putExtra("repNationNm", list.get(itemposition).repNationNm);
                intent.putExtra("repGenreNm", list.get(itemposition).repGenreNm);
                intent.putExtra("typeNm", list.get(itemposition).typeNm);
                context.startActivity(intent);

            }
        });
    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public TextView movieNm, openDt, repNationNm, repGenreNm;

        public Holder(View view){
            super(view);
            movieNm = (TextView) view.findViewById(R.id.movieNm);
            openDt = (TextView) view.findViewById(R.id.openDt);
            repNationNm = (TextView) view.findViewById(R.id.repGenreNm);
            repGenreNm = (TextView) view.findViewById(R.id.repGenreNm);
        }
    }
}


