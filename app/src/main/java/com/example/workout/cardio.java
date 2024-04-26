package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class cardio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);

        Bundle bundle= getIntent().getExtras();
        if (bundle==null) {
            return;
        }
        User user= (User) bundle.get("cardio");
        TextView textView=findViewById(R.id.cardio);
        textView.setText(user.getName());
    }
}