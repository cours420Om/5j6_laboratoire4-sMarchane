package com.example.labo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nom, telephone;
    Button choix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choix = (Button)findViewById(R.id.btn_choix);
        nom = (EditText) findViewById(R.id.et_nom);
        telephone = (EditText) findViewById(R.id.et_telephone);



        choix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent affichageActivity = new Intent(MainActivity.this, activity2.class);
               Bundle b = new Bundle();
               b.putString("nom", nom.getText().toString());
               b.putString("telephone", telephone.getText().toString());
               affichageActivity.putExtras(b);
               startActivity(affichageActivity);
            }
        });

    }
}