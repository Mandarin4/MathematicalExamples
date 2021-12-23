package com.prostiemathprimeri.mathematicalexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView otvetpravBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        otvetpravBTN= findViewById(R.id.otvetpravBTN);
        String otvetprav = getIntent().getStringExtra("pravOtvet");
        otvetpravBTN.setText(otvetprav);
    }
    public void mainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);finish();

    }

    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        Intent backintent = new Intent(this, MainActivity.class);
        startActivity(backintent);finish();
    }
}