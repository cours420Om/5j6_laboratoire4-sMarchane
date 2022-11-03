package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    TextView nomRecu, telephoneRecu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nomRecu = (TextView) findViewById(R.id.tv_nomClientRecu);
        telephoneRecu = (TextView) findViewById(R.id.tv_telephoneRecu);


        Intent retour = getIntent();
        Bundle b = retour.getExtras();
        String nom = b.getString("nom");
        String phone = b.getString("telephone");
        nomRecu.setText(nom);
        telephoneRecu.setText(phone);

    }
}