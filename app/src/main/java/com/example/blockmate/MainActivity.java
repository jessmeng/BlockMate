package com.example.blockmate;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;


public class MainActivity extends AppCompatActivity {

    ActionBar toolbar;
//    Context context;
    private FirebaseOptions.Builder builder;
    private FirebaseOptions options;

    // public FirebaseDatabase dataBase;
    // public DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new FirebaseOptions.Builder();
        builder.setApiKey("AIzaSyDjiOg_OVDKPVF0i2x29f-ikpiljiH9Vf0");
        builder.setApplicationId("blockmate-bdb3c");
        builder.setDatabaseUrl("https://blockmate-bdb3c.firebaseio.com/");
        FirebaseOptions options = builder.build();
        FirebaseApp.initializeApp(this, options);

        FirebaseDatabase dataBase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = dataBase.getReference("message");
        myRef.setValue("Hello, World!");
        Log.d("DEBUG", "onCreate: created msg");

        toolbar = getSupportActionBar();
        BottomNavigationView navigation = findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_buy:
                        Intent a = new Intent(MainActivity.this,ActivityBuy.class);
                        startActivity(a);
                        break;
                    case R.id.navigation_sell:
                        Intent b = new Intent(MainActivity.this,ActivitySell.class);
                        startActivity(b);
                        break;
                }
                return false;
            }
        });
    }
}
