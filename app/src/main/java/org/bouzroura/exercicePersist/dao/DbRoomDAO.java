package org.bouzroura.exercicePersist.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import org.bouzroura.exercicePersist.modele.persistPersonne;

import java.util.List;

@Dao
public abstract class DbRoomDAO {

    @Insert
    public abstract Long creerPersonne(persistPersonne personne);

    @Query("SELECT * FROM persistPersonne WHERE genre = :genre")
    public abstract List<persistPersonne> recupererPersonnesSelonSex(persistPersonne.Genre genre);
//
    @Query("SELECT * FROM persistPersonne")
    public abstract List<persistPersonne> recupererPersonnes();
//
//

}




