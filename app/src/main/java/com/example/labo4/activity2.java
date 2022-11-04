package com.example.labo4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Button btn_commander;

    NotificationManager mng_notif;
    @RequiresApi(api = Build.VERSION_CODES.O)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Fragment2 fragment2 = new Fragment2();
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment2, fragment2).commit();
        Fragment2 fragment = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        mng_notif = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //creationCanalNotification("1", "Démo", "Commande");
        lv_repas = (ListView)findViewById(R.id.lv_fragment1);
        nomRecu = (TextView) findViewById(R.id.tv_nomClientRecu);
        telephoneRecu = (TextView) findViewById(R.id.tv_telephoneRecu);
        btn_commander = (Button)findViewById(R.id.btn_commander);


        //ArrayAdapter<repas> adapter = new ArrayAdapter<repas>(this, android.R.layout.simple_list_item_1)


        Intent retour = getIntent();
        Bundle b = retour.getExtras();
        String nom = b.getString("nom");
        String phone = b.getString("telephone");
        nomRecu.setText(nom);
        telephoneRecu.setText(phone);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Notif", "Notif", NotificationManager.IMPORTANCE_LOW);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btn_commander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                NotificationCompat.Builder builder = new NotificationCompat.Builder(activity2.this, "Notif");
                builder.setContentTitle(telephoneRecu.getText());
                builder.setContentText("Votre commande: " + fragment.notification);
                builder.setSmallIcon(R.drawable.ic_notif);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(activity2.this);
                managerCompat.notify(1, builder.build());

                //onClick_btn_commander(view);
            }
        });

    }

    /*@RequiresApi(api = Build.VERSION_CODES.O)
    protected void creationCanalNotification(String id, String nom, String description) {

        int priorite = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel canal = new NotificationChannel(id, nom, priorite);

        canal.setDescription(description);
        canal.enableLights(true);
        canal.setLightColor(Color.RED);

        mng_notif.createNotificationChannel(canal);
    }*/
    /*@RequiresApi(api = Build.VERSION_CODES.O)
    public void onClick_btn_commander(View vue){
        int notificationID = 101;
        String canalID = "1";
        Notification nbuilder = new Notification.Builder(this, canalID)
                .setContentTitle("Exemple")
                .setContentText("Exemple de notification")
                .setChannelId(canalID)

                .build();
        mng_notif.notify(notificationID, nbuilder);
    }*/

}