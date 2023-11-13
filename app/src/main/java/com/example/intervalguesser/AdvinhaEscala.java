package com.example.intervalguesser;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import org.jfugue.player.Player;
import org.jfugue.theory.Intervals;
import org.jfugue.theory.Note;
import org.jfugue.theory.Scale;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AdvinhaEscala extends BaseActivity {
    Random aleatorio = new Random();
    Button alternativa_um;
    Button alternativa_dois;
    Button alternativa_tres;
    Button alternativa_quatro;
    int resultadoFinal;


    int respostasCorretas = 0;
    int respostasErradas = 0;

    private Intervals misturaIntervalos() {
        String[] notas = Note.NOTE_NAMES_COMMON;
        Intervals intervaloFrigio = new Intervals("1 b2 b3 4 5 b6 b7").setRoot(notas[aleatorio.nextInt(notas.length)]);
        Intervals intervaloLidio = new Intervals("1 2 3 4# 5 6 7").setRoot(notas[aleatorio.nextInt(notas.length)]);
        Intervals intervaloPentBlues = new Intervals("1 b3 4 b5 5 b7").setRoot(notas[aleatorio.nextInt(notas.length)]);
        Intervals intervaloMixolidio = new Intervals("1 2 3 4 5 6 b7").setRoot(notas[aleatorio.nextInt(notas.length)]);
        Intervals intervaloDorico = new Intervals("1 2 b3 4 5 6 b7").setRoot(notas[aleatorio.nextInt(notas.length)]);
        Intervals intervaloEolio = new Intervals("1 2 b3 4 5 b6 b7").setRoot(notas[aleatorio.nextInt(notas.length)]);
        Intervals intervaloJonio = new Intervals("1 2 3 4 5 6 7").setRoot(notas[aleatorio.nextInt(notas.length)]);
        Intervals intervaloLocrio = new Intervals("1 b2 b3 4 b5 b6 b7").setRoot(notas[aleatorio.nextInt(notas.length)]);
        List<Intervals> intervalos = new ArrayList<>();
        intervalos.add(intervaloLocrio);
        intervalos.add(intervaloLidio);
        intervalos.add(intervaloMixolidio);
        intervalos.add(intervaloDorico);
        intervalos.add(intervaloJonio);
        intervalos.add(intervaloFrigio);
        intervalos.add(intervaloEolio);
        Intervals intPlay = intervalos.get(aleatorio.nextInt(intervalos.size()));
        return intPlay;

    }

    private void tocaEscala() {
        Player pl = new Player();
        pl.play(misturaIntervalos());
        }
    private String nomeiaEscala(){
        String escala = "";
        Intervals intervaloAleatorio = misturaIntervalos();
		switch(intervaloAleatorio.toString()) {
        case "1 b2 b3 4 5 b6 b7":
            escala = "frígio";
            break;
        case "1 2 3 4# 5 6 7":
            escala = "lídio";
            break;
        case "1 b3 4 b5 5 b7":
            escala = "pentatônica blues";
            break;
        case "1 2 3 4 5 6 b7":
            escala = "mixolídio";
            break;
        case "1 2 b3 4 5 6 b7":
            escala = "dório";
            break;
        case "1 2 b3 4 5 b6 b7":
            escala = "eólio";
            break;
        case "1 2 3 4 5 6 7":
            escala = "jônio";
            break;
        case "1 b2 b3 4 b5 b6 b7":
            escala = "lócrio";
            break;
    }
    return escala;
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_advinha_escala);
            String escala = nomeiaEscala();
            List<String> escalas = Arrays.asList("jônio", "dório", "frígio", "mixolídio", "lídio", "lócrio","pentatônica blues", "éolio");
            String respostaCorreta = nomeiaEscala();
            alternativa_um = (Button) findViewById(R.id.questao_um);
            alternativa_dois = (Button) findViewById(R.id.questao_dois);
            alternativa_tres = (Button) findViewById(R.id.questao_tres);
            alternativa_quatro = (Button) findViewById(R.id.questao_quatro);

            for(int i = 0; i<11; i++) {
                int buttonIndexCorrectAnswer = 1 + (int) Math.floor(4 * Math.random());

                switch (buttonIndexCorrectAnswer) {
                    case 1:
                        alternativa_um.setText(respostaCorreta);
                        alternativa_dois.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_tres.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_quatro.setText(escalas.get(new Random().nextInt(escalas.size())));

                    case 2:
                        alternativa_um.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_dois.setText(respostaCorreta);
                        alternativa_tres.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_quatro.setText(escalas.get(new Random().nextInt(escalas.size())));
                    case 3:
                        alternativa_um.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_dois.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_tres.setText(respostaCorreta);
                        alternativa_quatro.setText(escalas.get(new Random().nextInt(escalas.size())));
                    case 4:
                        alternativa_um.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_dois.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_tres.setText(escalas.get(new Random().nextInt(escalas.size())));
                        alternativa_quatro.setText(respostaCorreta);
                }


                public void onClick (View v){
                    if (v == alternativa_um) {
                        if (alternativa_um.equals(alternativa_um)) {
                            respostasCorretas++;
                            Toast.makeText(this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                        } else {
                            respostasErradas++;
                            Toast.makeText(this, "Resposta Inorreta. A escale é a  " + escala, Toast.LENGTH_SHORT).show();
                        }
                    } else if (v == alternativa_dois) {
                        if (v == alternativa_tres) {
                            respostasCorretas++;
                            Toast.makeText(this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                        } else {
                            respostasErradas++;
                            Toast.makeText(this, "Resposta Inorreta. A escale é a  " + escala, Toast.LENGTH_SHORT).show();
                        }

                    } else if (v == alternativa_tres) {
                        if (v == alternativa_tres) {
                            respostasCorretas++;
                            Toast.makeText(this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                        } else {
                            respostasErradas++;
                            Toast.makeText(this, "Resposta Inorreta. A escale é a  " + escala, Toast.LENGTH_SHORT).show();
                        }
                    } else if (v == alternativa_quatro) {
                        if (v == alternativa_tres) {
                            respostasCorretas++;
                            Toast.makeText(this, "Resposta Correta", Toast.LENGTH_SHORT).show();
                        } else {
                            respostasErradas++;
                            Toast.makeText(this, "Resposta Inorreta. A escale é a  " + escala, Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }

            resultadoFinal = 10 - respostasErradas;
            Bundle b = new Bundle();
            b.putInt("result", resultadoFinal);
            Intent intent = new Intent(this, PontosEscala.class);
            intent.putExtras(b);
            startActivity(intent);
            finish();
            }

    }


}   