package com.prostiemathprimeri.mathematicalexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView textGameAct1, textGameAct2, textGameAct4;
    EditText textGameAct3;
    int position = 0, positionEnd, pravotvet=0;
    String voprs, otvet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textGameAct1 = (TextView) findViewById(R.id.textGameAct1);
        textGameAct2 = (TextView) findViewById(R.id.textGameAct2);
        textGameAct3 = (EditText) findViewById(R.id.textGameAct3);
        textGameAct4 = (TextView) findViewById(R.id.textGameAct4);
        randomPrimer();
        positionEnd = 14;
        voprosPos();
    }

    public void btnNextVopros(View view){
        if(position<positionEnd) {
            if(!textGameAct3.getText().toString().replaceAll("\\s+","").equals("")){
                if(textGameAct3.getText().toString().replaceAll("\\s+","").equals(otvet)){
                    pravotvet++;
                }
                position++;
                randomPrimer();
                voprosPos();
                textGameAct3.setText("");
            }else Toast.makeText(getBaseContext(), "Введите ответ!!!", Toast.LENGTH_SHORT).show();

        } else startActivity();
    }

    private void startActivity(){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("pravOtvet", Integer.toString(pravotvet));
        startActivity(intent);finish();
    }

    public void voprosPos(){
        if(position<=positionEnd) {
            textGameAct1.setText("Вопрос №" + Integer.toString(position + 1));
            textGameAct2.setText(voprs);
        }
    }

    private void randomPrimer(){
        if (position < 9){
            Random random = new Random();
            int znak = random.nextInt(2);

            int min = 1;
            int max = 30;
            int diff = max - min;
            int i = random.nextInt(diff + 1);
            i += min;
            int i2;
            if(znak == 1) {
                do {
                    i2 = random.nextInt(diff + 1);
                } while (i < i2);
            } else i2 = random.nextInt(diff + 1);

            if (znak == 1){
                voprs = Integer.toString(i) + " - " + Integer.toString(i2) + " =";
                otvet =  Integer.toString(i - i2);
            }else {
                voprs = Integer.toString(i) + " + " + Integer.toString(i2) + " =";
                otvet =  Integer.toString(i + i2);
            }
        } else {
            Random random = new Random();
            int znak = random.nextInt(2);

            int min = 1;
            int max = 30;
            int diff = max - min;
            int i = random.nextInt(diff + 1);
            i += min;
            int i2;
            if(znak == 1) {
                do {
                    i2 = random.nextInt(diff + 1);
                    if (i2 == 0 )i2 = random.nextInt(diff + 1);
                } while (i % i2 != 0 );
            } else i2 = random.nextInt(diff + 1);

            if (znak == 1){
                voprs = Integer.toString(i) + " / " + Integer.toString(i2) + " =";
                otvet =  Integer.toString(i / i2);
            }else {
                voprs = Integer.toString(i) + " * " + Integer.toString(i2) + " =";
                otvet =  Integer.toString(i * i2);
            }
        }
    }

    // Системная кнопка назад
    @Override
    public void onBackPressed(){
        Intent backintent = new Intent(this, MainActivity.class);
        startActivity(backintent);finish();
    }
}