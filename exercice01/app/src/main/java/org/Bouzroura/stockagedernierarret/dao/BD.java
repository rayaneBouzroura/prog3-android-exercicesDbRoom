package org.Bouzroura.stockagedernierarret.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import org.Bouzroura.stockagedernierarret.modele.dernierArretModele;

@Database(entities = {dernierArretModele.class}, version = 2)
@TypeConverters(Converters.class)
public abstract class BD extends RoomDatabase {
    public abstract monDao dao();
}
