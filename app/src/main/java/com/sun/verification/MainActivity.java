package com.sun.verification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button toPay = findViewById(R.id.toPay);
        toPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayDailog payDailog = new PayDailog(MainActivity.this);
                payDailog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                payDailog.show();
            }
        });
    }

}
