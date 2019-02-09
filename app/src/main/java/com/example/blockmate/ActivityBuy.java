package com.example.blockmate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;
import android.graphics.Color;

public class ActivityBuy extends AppCompatActivity {

    boolean[] l1 = {true, true, true, true, true, true, true, true};
    Transaction[] temp = {new Transaction("Neil", "2", "3.56", "2/7/19", "2:13", l1)};
    boolean[] locations = {true, false, true, false, true, true, false, false};

    private boolean commonLocs(boolean[] loc1, boolean[] loc2) {
        for (int i = 0; i < loc1.length; i++) {
            if (loc1[i] && loc2[i]) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        String[] textarray = {"Hello", "World"};
        LinearLayout linearlayout = new LinearLayout(this);
        setContentView(linearlayout);
        linearlayout.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < temp.length; i++) {
            if (commonLocs(locations, temp[i].locations)) {

                TextView displaytext = new TextView(this);
                displaytext.setText(textarray[i]);
                displaytext.setPadding(20, 50, 20, 50);
                displaytext.setTextSize((float) 18);
                displaytext.setBackgroundColor(Color.parseColor("#FFCCCC"));
                linearlayout.addView(displaytext);

            }
        }
    }
}
