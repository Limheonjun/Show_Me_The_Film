package com.example.m.smtf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerviewAdapterWeeklyBoxoffice extends RecyclerView.Adapter<RecyclerviewAdapterWeeklyBoxoffice.Holder> {


    private Context context;
    private List<WeeklyBoxoffice> list;





    public RecyclerviewAdapterWeeklyBoxoffice(Context context, List<WeeklyBoxoffice> list) {
        this.context = context;
        this.list = list;
    }



    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    // test
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
        holder.name.setText(list.get(itemposition).movieNm);
        holder.price.setText(list.get(itemposition).openDt);



    }

    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    @Override
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }



    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView price;
        public LinearLayout click;

        public Holder(View view){
            super(view);

            click = (LinearLayout)view.findViewById(R.id.click);
            name = (TextView) view.findViewById(R.id.id);
            price = (TextView) view.findViewById(R.id.content);



            name = (TextView) view.findViewById(R.id.movieNm);
            price = (TextView) view.findViewById(R.id.openDt);
        }
    }
}


