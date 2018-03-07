package local.com.agendacontactos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import local.com.agendacontactos.model.Contacto;
import local.com.agendacontactos.model.UtilsContactos;

/**
 * Created by user on 01/03/2018.
 */

public class BuscarActivity extends Activity {

    ArrayList<Contacto> miagenda;
    String mail;
    TextView resultTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_buscar);

        /*Método con arrays (sin db)*/
        ///Intent intent = this.getIntent();
        ///miagenda = (ArrayList<Contacto>) intent.getSerializableExtra("agenda");

        resultTV = (this.findViewById(R.id.textViewResult));
    }

    public void buscarPorEmailDB(View view){

        Log.d("TAG", "*******IniBuscar*******");

        mail = ((EditText)this.findViewById(R.id.editTextMail)).getText().toString();
        Log.d("TAG", "*******Var mail recogida*******");

        UtilsContactos utils = new UtilsContactos(this);

        Contacto con;
        con = utils.buscarPorEmail(mail);
        Log.d("TAG", "*******Contacto Insertado*******");

        System.out.println("nombre: " + con.getNombre() + " email: "+ con.getEmail() + " edad: " +con.getEdad());
        resultTV.setText("Nombre: "+con.getNombre()+"\nEmail: "+con.getEmail()+"\nEdad: "+con.getEdad());

        Log.d("TAG", "*******FinBuscar*******");
        utils.close();
    }


public void buscar(View view) {

    mail = ((EditText)this.findViewById(R.id.editTextMail)).getText().toString();
    Contacto c = null;
    for (Contacto con : miagenda) {

        if (con.getEmail().toString().equals(mail)) {
            c = con;

            break;
        }
    }
    mostrarDato(c);
}


    private void mostrarDato(Contacto c){
        if(c == null){
            resultTV.setText("Contacto no encontrado");
        }
        else{
            resultTV.setText("Nombre: "+c.getNombre()+"\nEmail: "+c.getEmail()+"\nEdad: "+c.getEdad());

            String datos="Nombre: "+c.getNombre()+
                    "\n Email:"+c.getEmail()+
                    "\n Edad:"+c.getEdad();

        }

    }




public void salir (View view){
    this.finish();
}

}

