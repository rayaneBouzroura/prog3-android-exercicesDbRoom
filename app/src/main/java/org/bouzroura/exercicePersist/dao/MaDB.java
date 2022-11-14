package org.bouzroura.exercicePersist.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import org.bouzroura.exercicePersist.modele.persistPersonne;

@Database(entities = {persistPersonne.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class MaDB extends RoomDatabase {
    public abstract DbRoomDAO dao();
}

