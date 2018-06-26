package com.example.gef.myrollerdice;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final int VALEUR_DE_MIN_MAX[] = {1,6};
    private static final String VALEUR = "VAL";
    private static final String VALEUR_RESET = "VALEUR_RESET";

    private int valeur[] = {0,0,0};
    private boolean reset = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reset
        if(savedInstanceState != null) {
            reset = savedInstanceState.getBoolean(VALEUR_RESET);
            reset = !reset;
        }

        // valeur random
        if(savedInstanceState == null || reset) {

            for (int i = 0; i < valeur.length; i++ ) {
                valeur[i]= getAnInt();
            }
            reset = true;
        }
        else {
            // récupération des valeurs sauvegardées
            valeur = savedInstanceState.getIntArray(VALEUR);
        }
        TextView textView1 = this.findViewById(R.id.des_top);
        TextView textView2 = this.findViewById(R.id.des_centre);
        TextView textView3 = this.findViewById(R.id.des_bottom);

        textView1.setText(String.valueOf(valeur[0]));
        Log.i("des",valeur.toString());

        textView2.setText(String.valueOf(valeur[1]));
        textView3.setText(String.valueOf(valeur[2]));
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putIntArray(VALEUR,valeur);
        outState.putBoolean(VALEUR_RESET,reset);
    }

    private int getAnInt() {
        return new Random().nextInt(5) + 1;
    }
}
