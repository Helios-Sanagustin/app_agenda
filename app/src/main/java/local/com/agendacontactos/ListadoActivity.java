package local.com.agendacontactos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import java.util.ArrayList;

import local.com.agendacontactos.model.Contacto;

/**
 * Created by user on 01/03/2018.
 */

public class ListadoActivity extends Activity {

    ArrayList<Contacto> miagenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_listado);
        Intent intent = this.getIntent();
        miagenda = (ArrayList<Contacto>) intent.getSerializableExtra("agenda");
        TextView contactosTV = findViewById(R.id.textViewContactos);
        String datos = "";

        for (Contacto con : miagenda) {

            datos += "Nombre: " + con.getNombre() + "\nEmail: " + con.getEmail() + "\nEdad: " + con.getEdad() + "\n****************************\n";
        }
        contactosTV.setText(datos);
    }
}
