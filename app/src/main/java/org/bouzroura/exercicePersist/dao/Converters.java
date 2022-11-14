package org.bouzroura.exercicePersist.dao;

import androidx.room.TypeConverter;

import org.bouzroura.exercicePersist.modele.persistPersonne;

import java.util.Date;

public class Converters {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static persistPersonne.Genre fromString(String genre) {
        return genre == null ? null : persistPersonne.Genre.valueOf(genre);
    }

    @TypeConverter
    public static String fromEnum(persistPersonne.Genre genreEnum) {
        return genreEnum == null ? null : String.valueOf(genreEnum.values()[genreEnum.ordinal()]);
    }









}
