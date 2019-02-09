package com.example.blockmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.*;
import java.util.Map;

public class ActivitySell extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        context = this;

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText name = findViewById(R.id.nameText);
                final EditText blocks = findViewById(R.id.blocksText);
                final EditText cost = findViewById(R.id.costText);
                final EditText date = findViewById(R.id.dateText);
                final EditText time = findViewById(R.id.timeText);

                String nameVal = name.getText().toString();
                String blocksVal = blocks.getText().toString();
                String costVal = cost.getText().toString();
                String dateVal = date.getText().toString();
                String timeVal = time.getText().toString();

                //Call some function


//                boolean[] locations = {true, false, true, false, true, true, false, false};
                // Transaction trans = new Transaction(nameVal, blocksVal, costVal, dateVal, timeVal, locations);

                FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
                builder.setApiKey("AIzaSyDjiOg_OVDKPVF0i2x29f-ikpiljiH9Vf0");
                builder.setApplicationId("blockmate-bdb3c");
                builder.setDatabaseUrl("https://blockmate-bdb3c.firebaseio.com/");
                FirebaseOptions options = builder.build();

                FirebaseApp.initializeApp(context, options);

                FirebaseDatabase dataBase = FirebaseDatabase.getInstance();

                DatabaseReference myRef = dataBase.getReference(nameVal);
                // myRef.setValue(90);
                List<String> entries = Arrays.asList(nameVal, blocksVal, costVal, timeVal);
                myRef.setValue(entries);
                Log.d("TEST", "onClick: SENT DATA");




                Intent a = new Intent(ActivitySell.this, SubmitActivity.class);
                startActivity(a);
            }
        });
    }
}
