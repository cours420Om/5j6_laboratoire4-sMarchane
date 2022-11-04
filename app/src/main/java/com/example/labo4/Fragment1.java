package com.example.labo4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {


    View fragment1View;
    ListView lv_liste;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Fragment1 fragment1 = new Fragment1();
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment1, fragment1).commit();
        String dataFichierJson = ouvrirFichierJson(getContext(), "menu.json");
        Gson gson = new Gson();
        Type listRepasType = new TypeToken<List<repas>>() { }.getType();
        List<repas> listeRepas = gson.fromJson(dataFichierJson, listRepasType);

        /*StringBuilder builder = new StringBuilder();
        for(repas rep: listeRepas){
            builder.append(rep.getNom()).append("\t");
            builder.append(rep.getPrix()).append("$\n");
        }*/

        ArrayAdapter<repas> adapter = new ArrayAdapter<repas>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, listeRepas);
        Log.i("Test", String.valueOf(listeRepas.get(0)));

        fragment1View =  inflater.inflate(R.layout.fragment_1, container, false);
        lv_liste = fragment1View.findViewById(R.id.lv_fragment1);
        lv_liste.setAdapter(adapter);


        // Inflate the layout for this fragment

       lv_liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Fragment2 fragment2 = (Fragment2)getFragmentManager().findFragmentById(R.id.fragment2);
                fragment2.setmethod(listeRepas.get(i).toString2());

                //view.setBackground(Drawable.createFromPath("#34b356"));
           }
       });




        return fragment1View;
    }


    static String ouvrirFichierJson(Context contexte, String nomFichier){
        String stringJson;
        try{

            InputStream in = contexte.getAssets().open(nomFichier);

            int taille = in.available();
            byte[] tampon = new byte[taille];
            in.read(tampon);
            in.close();

            stringJson = new String(tampon, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return stringJson;
    }
}