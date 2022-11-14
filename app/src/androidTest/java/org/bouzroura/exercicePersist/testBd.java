package org.bouzroura.exercicePersist;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.bouzroura.exercicePersist.dao.MaDB;
import org.bouzroura.exercicePersist.modele.persistPersonne;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class testBd {
    public Random r = new Random();
    @Test
    public void testRecupererBd() {

        Context context = ApplicationProvider.getApplicationContext();
        //elle met la bd dans la memoire vivante
        MaDB db = Room.inMemoryDatabaseBuilder(context, MaDB.class).build();
        //elle met la bd dans le local storage
        //MaDB db = Room.databaseBuilder(context, MaDB.class, "peepo").build();

        for (int i = 0; i < 5; i++) {
            persistPersonne a = new persistPersonne();
            a.nom = "Personne #" + i;
            a.dateNaissance = new Date();
            a.genre = persistPersonne.Genre.values()[r.nextInt(3)];
            db.dao().creerPersonne(a);
        }
        List<persistPersonne> albums = db.dao().recupererPersonnes();
        assertEquals(5, albums.size());


        //make sure de fermer la bd sinon trop d'instance reeeeeeeeeeee
        db.close();
    }

    @Test
    public void testRecupererSelonGenre(){
        Context context = ApplicationProvider.getApplicationContext();
        //elle met la bd dans la memoire vivante
        MaDB db = Room.inMemoryDatabaseBuilder(context, MaDB.class).build();
        //peupler la db
        peuplerBd(db,10);
        //listes de testes
        List<persistPersonne> personnes = new ArrayList<>();
        List<persistPersonne> personnesHomme = new ArrayList<>();
        List<persistPersonne> personnesFemmes = new ArrayList<>();
        List<persistPersonne> personnesPersonalisable = new ArrayList<>();
        personnes = db.dao().recupererPersonnes();
        personnesHomme = db.dao().recupererPersonnesSelonSex(persistPersonne.Genre.Homme);
        personnesFemmes = db.dao().recupererPersonnesSelonSex(persistPersonne.Genre.Femme);
        personnesPersonalisable = db.dao().recupererPersonnesSelonSex(persistPersonne.Genre.Complexe);
        db.close();
        for (persistPersonne p:personnesHomme
             ) {
            Assert.assertEquals(p.genre, persistPersonne.Genre.Homme);

        }
        for (persistPersonne p:personnesFemmes
        ) {
            Assert.assertEquals(p.genre, persistPersonne.Genre.Femme);

        }
        for (persistPersonne p:personnesPersonalisable
        ) {
            Assert.assertEquals(p.genre, persistPersonne.Genre.Complexe);

        }
    }

    private void peuplerBd(MaDB db , int nbrElements) {

        for (int i = 0; i < nbrElements; i++) {
            persistPersonne a = new persistPersonne();
            a.nom = "Personne #" + i;
            a.dateNaissance = new Date();
            a.genre = persistPersonne.Genre.values()[r.nextInt(3)];
            db.dao().creerPersonne(a);
        }
    }
}