package com.uninorte.quiz2dannamolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView tvsalida;
    float res = 0;
    String oper = null;
    float num1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout);
        tvsalida = (TextView) findViewById(R.id.tvsalida);
    }

    public void Numero(View view) {
        Button boton = (Button) view;
        int n = Integer.parseInt(boton.getText().toString());
        res = res * 10 +n;
        tvsalida.setText (String.format("%.0f",res));
    }

    public void Operacion(View view) {
        Button boton = (Button) view;
        if (oper != null) {
            switch (oper) {
                case "+":
                    num1 += res ;
                    break;
                case "-":
                    num1 -= res ;
                    break;
            }
            if (Objects.equals(boton.getText().toString(),"=")){
                res = num1;
                num1 = 0;
                oper = null;
            } else {
                res = 0;
                oper = boton.getText().toString();
            }
        } else {
            num1 = res;
            oper= boton.getText().toString();
            res = 0;
        }
        tvsalida.setText(String.format("%.0f",res));
    }
}
