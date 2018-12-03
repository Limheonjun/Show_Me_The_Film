package com.example.m.smtf;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;





public class Info extends AppCompatActivity {

    SQLiteDatabase database;

    CustomerDatabaseHelper databaseHelper;

    String tableName = "PRODUCT";

    String databaseName = "memberJoin";

    String Cnum;

    String Cpass;

    String Cname;

    String Cmajor;


Info(){

    try




    {

        if (database == null) {

            //  database = openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);

            databaseHelper = new CustomerDatabaseHelper(getApplicationContext(), databaseName, null, 1);

            database = databaseHelper.getWritableDatabase();

        } else if (database != null) {

            Toast.makeText(getApplication(), "이미 디비열렸음", Toast.LENGTH_SHORT).show();
        }
    } catch (
            Exception e
            )
    {
        e.printStackTrace();
    }
    try {

        if (database != null) {

            database.execSQL("CREATE TABLE if not exists " + tableName + "(" +

                    "_id integer PRIMARY KEY autoincrement," +

                    "name text," +

                    "pass text," +

                    "passCheck text," +

                    "num text," +

                    "major text" +

                    ")");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);




        try




        {

            if (database == null) {

                //  database = openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);

                databaseHelper = new CustomerDatabaseHelper(getApplicationContext(), databaseName, null, 1);

                database = databaseHelper.getWritableDatabase();



            } else if (database != null) {

                Toast.makeText(getApplication(), "이미 디비열렸음", Toast.LENGTH_SHORT).show();

            }




        } catch (

                Exception e

                )




        {

            e.printStackTrace();

        }

        try {

            if (database != null) {

                database.execSQL("CREATE TABLE if not exists " + tableName + "(" +

                        "_id integer PRIMARY KEY autoincrement," +

                        "name text," +

                        "pass text," +

                        "passCheck text," +

                        "num text," +

                        "major text" +

                        ")");

            }

        } catch (Exception e) {




            e.printStackTrace();

        }




    }

    static class CustomerDatabaseHelper extends SQLiteOpenHelper {

        CustomerDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

            super(context, name, factory, version);

        }




        @Override

        public void onOpen(SQLiteDatabase database) {

            super.onOpen(database);

        }




        @Override

        public void onCreate(SQLiteDatabase database) {

        }




        @Override

        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {




        }

    }




}

