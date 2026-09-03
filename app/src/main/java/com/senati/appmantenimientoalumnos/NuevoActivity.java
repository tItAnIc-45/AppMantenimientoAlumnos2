package com.senati.appmantenimientoalumnos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.senati.appmantenimientoalumnos.db.Dbalumnos;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class NuevoActivity extends AppCompatActivity {
    //Asignar nuestras variables
    private EditText txtnombre, txtApellido, txtDni, txtTelefono, txtCorreoElectronico,
            txtCarrera, txtCiclo, txtSeccion, txtDireccion, txtFechaNacimiento;
    private Button btnguarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo);

        //añadiendo las variables los elementos de la vista.
        txtnombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtDni = findViewById(R.id.txtDni);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        txtCarrera = findViewById(R.id.txtCarrera);
        txtCiclo = findViewById(R.id.txtCiclo);
        txtSeccion = findViewById(R.id.txtSeccion);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        btnguarda = findViewById(R.id.BtnGuarda);

        btnguarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cambiar el nombre de la clase alumnos por Dbalumnos
                Dbalumnos dbalumnos = new Dbalumnos(NuevoActivity.this);
                long id = dbalumnos.insertarContactos(
                        txtnombre.getText().toString(),
                        txtApellido.getText().toString(),
                        txtDni.getText().toString(),
                        txtTelefono.getText().toString(),
                        txtCorreoElectronico.getText().toString(),
                        txtCarrera.getText().toString(),
                        txtCiclo.getText().toString(),
                        txtSeccion.getText().toString(),
                        txtDireccion.getText().toString(),
                        txtFechaNacimiento.getText().toString()
                );

                if(id > 0){
                    Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void limpiar() {
        txtnombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
        txtCarrera.setText("");
        txtCiclo.setText("");
        txtSeccion.setText("");
        txtDireccion.setText("");
        txtFechaNacimiento.setText("");
    }
}