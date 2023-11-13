package com.example.intervalguesser;

import static android.os.Build.VERSION_CODES.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Intervals;
import org.jfugue.player.*;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.R;

public class AdvinhaAcorde extends Activity {
    Intent intent;
    int resultadoFinal;

    int respostasCorretas = 0;
    int respostasErradas = 0;
    Button maior;
    Button menor;
    Button aumentado;
    Button diminuto;
    Random aleatorio;
    List<Button> listaBotoes;

    public Chord geraAcorde() {
        List<String> acordes = new ArrayList<>();
        acordes.add("Cmaj");
        acordes.add("Cmin");
        acordes.add("Caug");
        acordes.add("Cdim");
        acordes.add("C#maj");
        acordes.add("C#min");
        acordes.add("C#aug");
        acordes.add("C#dim");
        acordes.add("Dmaj");
        acordes.add("Dmin");
        acordes.add("Daug");
        acordes.add("Ddim");
        acordes.add("D#maj");
        acordes.add("D#min");
        acordes.add("D#aug");
        acordes.add("D#dim");
        acordes.add("Emaj");
        acordes.add("Emin");
        acordes.add("Eaug");
        acordes.add("Edim");
        acordes.add("Fmaj");
        acordes.add("Fmin");
        acordes.add("Faug");
        acordes.add("Fdim");
        acordes.add("F#maj");
        acordes.add("F#min");
        acordes.add("F#aug");
        acordes.add("F#dim");
        acordes.add("Gmaj");
        acordes.add("Gmin");
        acordes.add("Gaug");
        acordes.add("Gdim");
        acordes.add("G#maj");
        acordes.add("G#min");
        acordes.add("G#aug");
        acordes.add("G#dim");
        acordes.add("Amaj");
        acordes.add("Amin");
        acordes.add("Aaug");
        acordes.add("Adim");
        acordes.add("A#maj");
        acordes.add("A#min");
        acordes.add("A#aug");
        acordes.add("A#dim");
        acordes.add("Bmaj");
        acordes.add("Bmin");
        acordes.add("Baug");
        acordes.add("Bdim");
        String acordeAleatorio = acordes.get(aleatorio.nextInt(acordes.size()));
        Chord acorde = new Chord(acordeAleatorio);
        return acorde;
    }

    private void tocaAcorde(Chord acorde) {
        Player pl = new Player();
        pl.play(acorde);
    }
    private boolean isAugmented(Chord acorde){
        boolean flag;
        acorde = geraAcorde();
        Intervals intervalo = acorde.getIntervals();
        String intervaloTexto = intervalo.toString();
        if(intervaloTexto.equals("1 3 #5")){
            flag = true;
        }
        else{
            flag = false;
        }
        return flag;
}
    private boolean isDiminished(Chord acorde) {
        boolean flag;
        acorde = geraAcorde();
        Intervals intervalo = acorde.getIntervals();
        String intervaloTexto = intervalo.toString();
        if (intervaloTexto.equals("1 3 b5")) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    private String nomeiaQualidade(Chord acorde) {

        List<Chord> maiores = new ArrayList<>();
        List<Chord> menores = new ArrayList<>();
        List<Chord> aumentados = new ArrayList<>();
        List<Chord> diminutos = new ArrayList<>();
        acorde = geraAcorde();
        String qualidadeAcorde = "";
        boolean checaAumentado = isAugmented(acorde);
        boolean checaDiminuto = isDiminished(acorde);

        if (acorde.isMajor()) {
            maiores.add(acorde);
            qualidadeAcorde = "Maior";
        } else if (acorde.isMinor()) {
            menores.add(acorde);
            qualidadeAcorde = "Menor";
        } else if (checaAumentado) {
            aumentados.add(acorde);
            qualidadeAcorde = "Aumentado";
        } else if (checaDiminuto) {
            aumentados.add(acorde);
            qualidadeAcorde = "Diminuto";
        }
        return qualidadeAcorde;

    }

    private void configurarBotoes(int indiceRespostaCorreta) {
        List<String> opcoes = new ArrayList<>();
        opcoes.add("Maior");
        opcoes.add("Menor");
        opcoes.add("Aumentado");
        opcoes.add("Diminuto");

        for (int i = 0; i < 4; i++) {
            if (i == indiceRespostaCorreta) {
                listaBotoes.get(i).setText(nomeiaQualidade(geraAcorde()));
            } else {
                int indiceOpcaoAleatoria = aleatorio.nextInt(opcoes.size());
                listaBotoes.get(i).setText(opcoes.get(indiceOpcaoAleatoria));
                opcoes.remove(indiceOpcaoAleatoria);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        List<Button> listaBotoes = new ArrayList<>();
        Chord chord = geraAcorde();

        final TextView questao = (TextView) findViewById(R.id.text_view_id);
        String acordeQualidade = nomeiaQualidade(chord);
        listaBotoes.add(maior);
        listaBotoes.add(menor);
        listaBotoes.add(aumentado);
        listaBotoes.add(diminuto);

        for (int i = 0; i < 11; i++) {

            maior = (Button) findViewById(R.id.botao_maior);
            maior.setText("Maior");
            menor = (Button) findViewById(R.id.botao_menor);
            menor.setText("Menor");
            aumentado = (Button) findViewById(R.id.botao_aumentado);
            aumentado.setText("Aumentado");
            diminuto = (Button) findViewById(R.id.botao_diminuto);
            diminuto.setText("Diminuto");
            final View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v == maior) {
                        if (acordeQualidade.equals(maior.getText().toString())) {
                            respostasCorretas++;
                            Toast.makeText(AdvinhaAcorde.this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                        } else {
                            respostasErradas++;
                            Toast.makeText(AdvinhaAcorde.this, "A resposta incorreta é a ", Toast.LENGTH_SHORT).show();
                        }

                    } else if (v == menor) {
                        if (acordeQualidade.equals(menor.getText().toString())) {
                            respostasCorretas++;
                            Toast.makeText(AdvinhaAcorde.this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                        } else {
                            respostasErradas++;
                            Toast.makeText(AdvinhaAcorde.this, "Resposta Inorreta. A escale é a  " + acordeQualidade, Toast.LENGTH_SHORT).show();
                        }


                    } else if (v == diminuto) {
                        if (acordeQualidade.equals(diminuto.getText().toString())) {
                            respostasCorretas++;
                            Toast.makeText(AdvinhaAcorde.this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                        } else {
                            respostasErradas++;
                            Toast.makeText(AdvinhaAcorde.this, "Resposta Inorreta. A escale é a  " + acordeQualidade, Toast.LENGTH_SHORT).show();
                        }

                    } else if (v == aumentado)
                        if (acordeQualidade.equals(aumentado.getText().toString())) {
                            respostasCorretas++;
                            Toast.makeText(AdvinhaAcorde.this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                        } else {
                            respostasErradas++;
                            Toast.makeText(AdvinhaAcorde.this, "Resposta Inorreta. A escale é a  " + acordeQualidade, Toast.LENGTH_SHORT).show();
                        }

                    for (Button b : listaBotoes) {
                        b.setOnClickListener(listener);
                    }
                    int resultadoFinal = 10 - respostasErradas;
                    Intent i = new Intent(AdvinhaAcorde.this, Pontos.class);
                    Bundle b = new Bundle();
                    b.putInt("score", resultadoFinal);
                    i.putExtras(b);
                    startActivity(i);
                }
            };
        }
    }
}


