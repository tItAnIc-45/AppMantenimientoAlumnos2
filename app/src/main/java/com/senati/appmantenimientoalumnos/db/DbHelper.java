package com.senati.appmantenimientoalumnos.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    //definimos variables con una variables vamos a controlar los cambios en la base de datos
    private static final int DATABASE_VERSION = 2; // antes era 1
    private static final String DATABASE_NOMBRE = "senati.db";
    public static final String TABLE_CONCTACTOS = "alumnos";

    //Constructor DbHelper
    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }
    //Evento se va crear : para crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONCTACTOS + "(" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT ," +   // no cuenta como atributo
                " nombre TEXT NOT NULL," +                     // 1
                " apellido TEXT NOT NULL," +                   // 2
                " dni TEXT NOT NULL," +                         // 3
                " telefono TEXT NOT NULL," +                    // 4
                " correo_electronico TEXT," +                   // 5
                " carrera TEXT," +                               // 6
                " ciclo TEXT," +                                 // 7
                " seccion TEXT," +                               // 8
                " direccion TEXT," +                             // 9
                " fecha_nacimiento TEXT)");                      // 10
    }
    // Evento se ejecuta cuando cambia la version de la base de datos.
    // cuando cambio la version a 2 ejem: DATABASE_VERSION=2 se ejecuta el metodo
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // primero nos elimine la tabla que tenemos y luego que agrege una nueva tabla
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_CONCTACTOS);
        onCreate(sqLiteDatabase);
    }
}