package com.example.m.smtf;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    android.app.FragmentManager manager = getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager.beginTransaction().add(R.id.test, new First()).commit();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navigation_home:
                        manager.beginTransaction().replace(R.id.test, new First()).commit();
                        return true;
                    case R.id.navigation_dashboard:
                        manager.beginTransaction().replace(R.id.test, new Second()).commit();
                        return true;
                    case R.id.navigation_notifications:
                        manager.beginTransaction().replace(R.id.test, new Third()).commit();
                        return true;
                }
                return false;

            }
        });
    }
}
