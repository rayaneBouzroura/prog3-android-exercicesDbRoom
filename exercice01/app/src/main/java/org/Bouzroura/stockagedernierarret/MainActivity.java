package org.Bouzroura.stockagedernierarret;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import org.Bouzroura.stockagedernierarret.dao.BD;
import org.Bouzroura.stockagedernierarret.databinding.ActivityMainBinding;
import org.Bouzroura.stockagedernierarret.modele.dernierArretModele;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    TextView tv;
    BD db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tv = binding.tvEntree;


        //recuperation de la bd
        //recuperer la bd
        db = Room.databaseBuilder(getApplicationContext(),
                BD.class, "bd-log").allowMainThreadQueries().build();

        ecrireEntree();

    }
    @Override
    protected void onStop () {
        //appelle la super classe
        super.onStop();
        //ecrire dans la db
        dernierArretModele model = new dernierArretModele();
        model.heure = new Date();
        db.dao().creerEntrer(model);
    }


    private void ecrireEntree() {
        if(db.dao().touteLesEntrees().isEmpty()){
            tv.setText("aucune entree");
        }
        else {
            Date derniereEntree = db.dao().touteLesEntrees().get(0).heure;
            tv.setText(derniereEntree.toString());
        }
    }
}