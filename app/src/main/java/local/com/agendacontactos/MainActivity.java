package local.com.agendacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import local.com.agendacontactos.model.Contacto;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> agenda;

    Button añadirBTN;
    Button buscarBTN;
    Button verTodosBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        añadirBTN = findViewById(R.id.buttonAñadir);
        buscarBTN = findViewById(R.id.buttonBuscar);
        verTodosBTN = findViewById(R.id.buttonVerTodos);

        agenda = new ArrayList<Contacto>();
    }

    //Metodo con arrays
    public void anadir(View view) {
        Intent intent = new Intent(this, AgregarActivity.class);

        //  Envia agenda a la otra pantalla
        intent.putExtra("agenda", agenda);

        //  Lo recupera
        this.startActivityForResult(intent, 1);
        Log.d("TAG", "agenda: " + agenda);
    }

    //  Abre la Activity AgregarActivity
    //  para poder insertar un registro de
    //  manera directa en la DBContactos
    public void abrirParaInsertarEnDB(View view) {
        Intent intent = new Intent(this,
                AgregarActivity.class);

        startActivity(intent);

    }

    public void buscarDB(View view){
        Intent intent = new Intent(this,
                BuscarActivity.class);

        startActivity(intent);
    }

    public void listadoDB(View view){
        Intent intent = new Intent(this, ListadoActivity.class);
    }

    //Metodo con arrays
    public void buscar(View view) {
        Intent intent = new Intent(this, BuscarActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);
    }

    //Metodo con arrays
    public void verTodos(View view) {
        Intent intent = new Intent(this, ListadoActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);
    }

    @Override
    public void onActivityResult(int cod, int result, Intent data) {
        super.onActivityResult(cod, result, data);
        agenda = (ArrayList<Contacto>) data.getSerializableExtra("miagenda");
    }


}
