package org.Bouzroura.stockagedernierarret.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.Bouzroura.stockagedernierarret.modele.dernierArretModele;

import java.util.List;

@Dao
public abstract class monDao {
    @Insert
    public abstract long creerEntrer(dernierArretModele dateEntree);


    @Query("SELECT * FROM dernierArretModele")
    public abstract List<dernierArretModele> touteLesEntrees();

}
