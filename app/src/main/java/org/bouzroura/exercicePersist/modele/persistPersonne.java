package org.bouzroura.exercicePersist.modele;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


//@Entity
@Entity
public class persistPersonne {

    public enum Genre {
        Homme, Femme, Complexe};


    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public String nom;

    @ColumnInfo
    public Genre genre;

    @ColumnInfo
    public Date dateNaissance;






}
