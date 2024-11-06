package com.example.albumy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Album> albumy = new ArrayList<>();
    ImageButton buttonDalej;
    ImageButton buttonWstecz;
    Button buttonPobierz;
    TextView textViewWykonawca;
    TextView textViewAlbum;
    TextView textViewRok;
    TextView textViewPobrania;
    int nrAlbumu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        albumy.add(new Album("Gorillaz", "The Now Now", 2018, 11, 11000102));
        albumy.add(new Album("My Chemical Romance:", "The Black Parade",2006,14,304666444));
        albumy.add(new Album("Wilki", "Wilki",1992,16,4000230));

        buttonDalej = findViewById(R.id.imageButton2);
        buttonWstecz =findViewById(R.id.imageButton);
        buttonPobierz =findViewById(R.id.button3);
        textViewWykonawca =findViewById(R.id.textViewWykonawca);
        textViewAlbum =findViewById(R.id.textViewAlbum);
        textViewRok =findViewById(R.id.textViewDetale);
        textViewPobrania = findViewById(R.id.textViewPobrania);

        wyswietlPiesn(nrAlbumu);
        wstecz();
        dalej();

    }
    private void wyswietlPiesn(int i){
    Album album = albumy.get(i);
    textViewWykonawca.setText(album.getWykonawca());
    textViewRok.setText(String.valueOf(album.getRok()));
    textViewPobrania.setText(String.valueOf(album.getPobrania()));
    textViewAlbum.setText(album.getNazwa());
    }
    private void dalej(){
        buttonDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nrAlbumu++;
                        if (nrAlbumu == albumy.size()){
                            nrAlbumu = 0;
                        }
                        wyswietlPiesn(nrAlbumu);
                    }
                }
        );
    }
    private void wstecz(){
        buttonWstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nrAlbumu--;
                        if (nrAlbumu < 0){
                            nrAlbumu = albumy.size()-1;
                        }
                        wyswietlPiesn(nrAlbumu);
                    }
                }
        );
    }
    private void pobierz(){
        buttonPobierz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }
        );
    }
}