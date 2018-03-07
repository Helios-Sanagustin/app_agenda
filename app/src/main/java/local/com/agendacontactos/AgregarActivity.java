package local.com.agendacontactos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import local.com.agendacontactos.Utils.Utilidades;
import local.com.agendacontactos.model.Contacto;
import local.com.agendacontactos.model.UtilsContactos;

/**
 * Created by user on 01/03/2018.
 */

public class AgregarActivity extends Activity {

    ArrayList<Contacto> miagenda;
    EditText nombreET;
    EditText emailET;
    EditText edadET;

    //  Creamos referencia para usar los metodos de la clase Utilidades
    Utilidades u = new Utilidades();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_agregar);

        /*Método con arrays (sin db)
        Intent intent= this.getIntent();
        miagenda=(ArrayList<Contacto>)intent.getSerializableExtra("agenda");*/

        nombreET = findViewById(R.id.editTextNombre);
        emailET = findViewById(R.id.editTextEmail);
        edadET = findViewById(R.id.editTextEdad);
    }


    //Metodo con arrays
    public void guardar(View view){

        String nombre = nombreET.getText().toString();
        String email = emailET.getText().toString();
        int edad = Integer.parseInt(edadET.getText().toString());
        Toast.makeText(this, "prueba", Toast.LENGTH_SHORT).show();


        Contacto c = new Contacto(nombre, email, edad);
       /* Log.d("TAG", "nombre:" + nombre );
        Log.d("TAG", "email:" + email );
        Log.d("TAG", "edad:" + edad );
        Log.d("TAG", "contacto: " + c);*/
        miagenda.add(c);


        Intent intent=new Intent();
        intent.putExtra("miagenda", miagenda);
        this.setResult(0, intent);
        //cerramos la actividad
        this.finish();
    }

public void insertarContactoADB(View view){

    //  Recupera los componentes de la vista
    String nombre = nombreET.getText().toString();
    String email = emailET.getText().toString();
    int edad = Integer.parseInt(edadET.getText().toString());

    Log.d("TAG", "*******IniInsertar*******");

        if(TextUtils.isEmpty(nombreET.getText()) ||
                TextUtils.isEmpty(emailET.getText()) ||
                TextUtils.isEmpty(edadET.getText()) ){

            Log.d("TAG", "*******If*******");

            //Mostramos mensaje de error "Campos vacios"

            //  Creamos un objeto de tipo Resources para acceder a los String
            //  Se crea rs para poder acceder a las Strings
            ///Resources rs = getResources();

            ///u.mostrarMensaje(this, rs.getString(R.string.campos_vacios));

        }else{
            Log.d("TAG", "*******else*******");            // Creamos objeto contacto
            Contacto c=new Contacto(nombre, email, edad);

            // Creamos un UtilsContactos(clase con los métodos)
            // y añadimos el nuevo contacto
            UtilsContactos gestion =
                    new UtilsContactos(this);
            gestion.insertarContacto(c);
            Log.d("TAG", "" + c.getNombre());
            Log.d("TAG", "" + c.getEmail());
            Log.d("TAG", "" + c.getEdad());


            // Cerramos la base de datos
            gestion.close();
            Log.d("TAG", "*******FinInsertar*******");

            // Finalizamos la actividad
            this.finish();
        }
}

private void cerrarActivity(View view){
    //  Cerramos la actividad
    this.finish();
}

}
