package com.senati.appmantenimientoalumnos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Dbalumnos extends DbHelper {

    Context context;

    //creamos el constructor
    public Dbalumnos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    //creamos un metodo
    public long insertarContactos(String nombre, String apellido, String dni, String telefono,
                                  String correo_electronico, String carrera, String ciclo,
                                  String seccion, String direccion, String fecha_nacimiento) {
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("dni", dni);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);
            values.put("carrera", carrera);
            values.put("ciclo", ciclo);
            values.put("seccion", seccion);
            values.put("direccion", direccion);
            values.put("fecha_nacimiento", fecha_nacimiento);

            id = db.insert(TABLE_CONCTACTOS, null, values);

        } catch (Exception ex) {
            android.util.Log.e("DB_ERROR", ex.toString());
        }
        return id;
    }
}