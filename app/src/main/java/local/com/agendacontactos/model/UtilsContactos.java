package local.com.agendacontactos.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import local.com.agendacontactos.constants.Constantes;

/**
 * Created by user on 05/03/2018.
 */
//Esta clase es para poder usar DatabaseContactos
public class UtilsContactos /*DBContactos.java*/ {

    //  Atributos
    private SQLiteDatabase db = null;
    //  Objeto que referencia a la clase anteriormente creada(DatabaseContactos)
    private DatabaseContactos dbcontactos = null;

    //  Contexto
    Context context;

    //  TODO: Constructor de nuestra clase
    //  para instanciar la clase DatabaseContactos
    //  y usar los métodos para escribir en nuestra
    //  base de datos

    public UtilsContactos(Context contexto) {
        this.context = contexto;

        //  crea una instancia del helper
        dbcontactos = new DatabaseContactos(context);

        //  crea un objeto SQLiteDatabase para operar
        //  contra la base de datos
        //  Una vez iniciado esto, se podrá modificar la base de datos
        db = dbcontactos.getWritableDatabase();
    }

    public void close() {
        dbcontactos.close();

    }

    public long insertarContacto(Contacto c) {

        //  TODO: Usamos un objeto de tipo ContentValues
        //  para guardar todas las "keys" de cada campo
        //  de nuestro contacto e insertarlo en la tabla
        ContentValues initialValues = new ContentValues();
        initialValues.put("nombre", c.getNombre());
        initialValues.put("email", c.getEmail());
        initialValues.put("edad", c.getEdad());

        //  Inserta el Contacto en la base de datos
        return db.insert(Constantes.CONTACTOS_TABLA,
                        null,
                         initialValues);
    }

    public Cursor recuperarContactos() {
        return db.query("contactos", new String[]{"_id", "nombre", "email", "edad"}, null, null, null, null, null);
    }

    public Contacto buscarPorEmail(String email) {

        Contacto con = null;
        //Creamos un cursor para guardar una query
        //de seleccion y un criterio para el campo
        //email =?
        Cursor c = db.query(Constantes.CONTACTOS_TABLA, new String[]{Constantes.CAMPO_ID, Constantes.CAMPO_NOMBRE, Constantes.CAMPO_EMAIL, Constantes.CAMPO_EDAD}, "email=?", new String[]{email}, null, null, null);
        if (c.moveToNext()) {
            con = new Contacto(c.getString(1), c.getString(2), c.getInt(3));
        }
        return con;
    }
}
