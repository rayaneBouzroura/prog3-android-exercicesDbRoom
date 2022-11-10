package org.Bouzroura.stockagedernierarret.modele;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class dernierArretModele {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public Date heure;

}
