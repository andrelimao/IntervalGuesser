package com.example.intervalguesser;

import static android.content.Intent.getIntent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Pontos extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        int pontuacao = getIntent().getIntExtra("result", 0);
        TextView resultado = (TextView) findViewById(R.id.texto_resultado);
        resultado.setText(pontuacao);
        Button voltaAoMenu = (Button) findViewById(R.id.volta_menu);
        Button repeteDesafio =(Button) findViewById(R.id.desafio);
        voltaAoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Pontos.this, MenuInicial.class));
            }
        });
        repeteDesafio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
