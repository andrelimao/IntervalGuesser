package com.example.intervalguesser;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MenuInicial extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent;
        Button advinhaEscala = (Button) findViewById(R.id.primeiro_botao);
        advinhaEscala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Intent(MenuInicial.this, AdvinhaEscala.class);
                startActivity(new Intent(MenuInicial.this, AdvinhaEscala.class);

            }
        });
        Button advinhaIntervalo = (Button) findViewById(R.id.segundo_botao);
        advinhaIntervalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuInicial.this, AdvinhaIntervalo.class));
            }
        });
        Button advinhaNotasAcorde = (Button) findViewById(R.id.terceiro_botao);
        advinhaNotasAcorde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuInicial.this, AdvinhaAcorde.class));
            }
        });







        }


    }
}