package com.example.m.smtf;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaCas;
import android.os.Bundle;
import android.app.Fragment;
import android.service.textservice.SpellCheckerService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {
    Button btn;
    TextView idlogin;
    TextView nums;
    TextView majors;

    Info n = new Info();

    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        idlogin = (TextView) view.findViewById(R.id.names);
        nums = (TextView) view.findViewById(R.id.nums);
        majors = (TextView) view.findViewById(R.id.majors);

        btn = (Button) view.findViewById(R.id.bt_search);
        n.databaseHelper = new Info.CustomerDatabaseHelper(getActivity(), n.databaseName, null, 1);
        n.database = n.databaseHelper.getWritableDatabase();
        if (n.database != null) {

            Cursor cursor = n.database.rawQuery("SELECT name, num, pass, major FROM " + n.tableName, null);

            int count = cursor.getCount();

            for (int i = 0; i < count; i++) {

                cursor.moveToNext();


                n.Cname = cursor.getString(0);

                n.Cnum = cursor.getString(1);

                n.Cpass = cursor.getString(2);

                n.Cmajor = cursor.getString(3);

            }

            String Id = idlogin.getText().toString();

            idlogin.setText("아이디 : "+n.Cnum);
            nums.setText(n.Cname+"님 환영합니다. ");
            majors.setText("학과는 : "+ n.Cmajor);
        }



            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    new AlertDialog.Builder(getActivity())
                            .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
                            .setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Intent i = new Intent(getActivity(), Login.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    startActivity(i);
                                }
                            })
                            .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }
                            })
                            .show();
                }



            });

        return view;
    }
    }





