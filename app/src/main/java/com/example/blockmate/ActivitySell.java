package com.example.blockmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivitySell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText name = findViewById(R.id.nameText);
                final EditText blocks = findViewById(R.id.blocksText);
                final EditText cost = findViewById(R.id.costText);
                final EditText time = findViewById(R.id.timeText);

                String nameVal = name.getText().toString();
                String blocksVal = blocks.getText().toString();
                String costVal = cost.getText().toString();
                String timeVal = time.getText().toString();

                //Call some function
                Intent a = new Intent(ActivitySell.this, SubmitActivity.class);
                startActivity(a);
            }
        });
    }
}
