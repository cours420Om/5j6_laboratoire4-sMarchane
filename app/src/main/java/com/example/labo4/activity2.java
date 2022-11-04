package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class activity2 extends AppCompatActivity {

    TextView nomRecu, telephoneRecu;
    ListView lv_repas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Fragment1 fragment1 = new Fragment1();
        //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //transaction.add(R.id.fragment1, fragment1).commit();
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment1, fragment1).commit();
        lv_repas = (ListView)findViewById(R.id.lv_fragment1);
        nomRecu = (TextView) findViewById(R.id.tv_nomClientRecu);
        telephoneRecu = (TextView) findViewById(R.id.tv_telephoneRecu);


        //ArrayAdapter<repas> adapter = new ArrayAdapter<repas>(this, android.R.layout.simple_list_item_1)


        Intent retour = getIntent();
        Bundle b = retour.getExtras();
        String nom = b.getString("nom");
        String phone = b.getString("telephone");
        nomRecu.setText(nom);
        telephoneRecu.setText(phone);

    }



}