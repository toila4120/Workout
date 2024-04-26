package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class chest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest);

        Bundle bundle= getIntent().getExtras();
        if (bundle==null) {
            return;
        }
        User user= (User) bundle.get("chest");
        TextView textView=findViewById(R.id.chest);
        textView.setText(user.getName());
    }
}