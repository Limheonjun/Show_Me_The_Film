package com.example.m.smtf;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.database.Cursor;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageButton;

import android.widget.Toast;




public class Member extends Info {

    EditText NAME,PASS,PASSSIGN,NUM,MAJOR;

    String Tname, Tpass, Tpasssign,Tnum,Tmajor;




    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        final Context context = this;


        setContentView(R.layout.activity_member);

        NAME = (EditText) findViewById(R.id.name);

        PASS = (EditText) findViewById(R.id.password);

        PASSSIGN = (EditText) findViewById(R.id.passsign);

        NUM = (EditText) findViewById(R.id.num);

        MAJOR = (EditText) findViewById(R.id.major);







        Button join = (Button) findViewById(R.id.join);

        join.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                Tname = NAME.getText().toString();

                Tpass = PASS.getText().toString();

                Tpasssign = PASSSIGN.getText().toString();

                Tnum = NUM.getText().toString();

                Tmajor = MAJOR.getText().toString();

                Cursor cursor = database.rawQuery("SELECT name, num, major FROM " + tableName, null);

                int count = cursor.getCount();

                for(int i=0;i<count;i++) {

                    cursor.moveToNext();




                    Cname = cursor.getString(0);

                    Cnum = cursor.getString(1);

                    Cmajor = cursor.getString(2);




                }

                if (Tname.length()<2) {

                    Toast.makeText(getApplicationContext(), "이름을 정확하게 입력해주세요.",

                            Toast.LENGTH_SHORT).show();

                } else if (Tpass.length() <4) {

                    Toast.makeText(getApplicationContext(), "비밀번호를 4자리 이상 입력하세요.",

                            Toast.LENGTH_SHORT).show();

                } else if (Tpasssign.length() <4) {

                    Toast.makeText(getApplicationContext(), "비밀번호를 입력하세요.",

                            Toast.LENGTH_SHORT).show();

                } else if (Tnum.length() <5 || Tname.equals(Cnum)) {

                    Toast.makeText(getApplicationContext(), "이미 등록된 학번이거나 정확하지 않습니다.",

                            Toast.LENGTH_SHORT).show();

                } else if (Tmajor.length() <3) {

                    Toast.makeText(getApplicationContext(), "학과이름을 정확히 입력해주세요.",

                            Toast.LENGTH_SHORT).show();

                } else {

                    try{

                        if (database != null) {

                            database.execSQL("INSERT INTO " + tableName + "(name, pass, passCheck, num, major) VALUES" +

                                    "(" + "'" + Tname + "'" + "," + "'" + Tpass + "'" + "," + "'" + Tpasssign + "'" + "," + Tnum + "," + "'" + Tmajor + "'" + ")");

                        }




                    } catch (Exception e) {

                        e.printStackTrace();

                    }
                    switch (v.getId()){
                        case  R.id.join:
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                            alertDialogBuilder.setTitle("회원가입");

                            alertDialogBuilder.setMessage("회원가입에 동의 하십니까?")
                                    .setCancelable(false)
                                    .setPositiveButton("동의", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Intent login = new Intent(getApplication(), Login.class);

                                            startActivity(login);

                                            finish();

                                            Toast.makeText(getApplication(), Tname + "님 회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog alertDialog = alertDialogBuilder.create();

                            // 다이얼로그 보여주기
                            alertDialog.show();
                            break;

                        default:
                            break;

                    }
                    /*Intent login = new Intent(getApplication(), Login.class);

                    startActivity(login);

                    finish();

                    Toast.makeText(getApplication(), Tname + "님 회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();*/







                }




            } });

    }




}


